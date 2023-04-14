clear all;
clc;
close all;
%%%%Constante
afficher = true;
NbBits = 100000;
Fe = 24000;
Rb = 3000;
Te = 1/Fe;

T = 0:Rb/Fe^2:(NbBits-Rb/Fe)*Te;
SNR_dB = 0:1:8;
SNR = 10.^(SNR_dB/10);
%On initialise les TEB
TEB1 = zeros(1, length(SNR));
TEB2 = zeros(1, length(SNR));
TEB3 = zeros(1, length(SNR));
TEB1_theo = zeros(1, length(SNR));
TEB2_theo = zeros(1, length(SNR));
TEB3_theo = zeros(1, length(SNR));

for index = 1:length(SNR)
    %%%%%Génération du signal d'origine
    Signal = randi([0 1], NbBits, 1);
    %%%%%Modulation du signal
    [signal_module1,Ns1] = modulateur_1(Signal,Fe,Rb);
    [signal_module2,Ns2] = modulateur_2(Signal,Fe,Rb);
    [signal_module3,Ns3] = modulateur_3(Signal,Fe,Rb);
    
    %%%%%Ajout du bruit
    %calcul de la puissance
    Px1 = mean(abs(signal_module1).^2);
    Px2 = mean(abs(signal_module2).^2);
    Px3 = mean(abs(signal_module3).^2);
    %calcul de sigma
    sigma1 = sqrt(Px1*Ns1/(2*SNR(index)));
    sigma2 = sqrt(Px2*Ns2/(2*SNR(index))); 
    sigma3 = sqrt(Px3*Ns3/(2*2*SNR(index)));
    %génération du bruit
    bruit1 = sigma1*randn(1, length(signal_module1))';
    bruit2 = sigma2*randn(1, length(signal_module2))';
    bruit3 = sigma3*randn(1, length(signal_module3))';
    %ajout du bruit
    signal_bruite1 = signal_module1 + bruit1;
    signal_bruite2 = signal_module2 + bruit2;
    signal_bruite3 = signal_module3 + bruit3;

    %%%%%Reception
    %filtre de réception
    h1 = ones(1, Ns1);
    h2 = [ones(1, (floor(Ns2/2))),zeros(1, (floor(Ns2/2)))];
    h3 = ones(1, Ns3);
    %filtrage
    z1 = filter(h1, 1, signal_bruite1);
    z2 = filter(h2, 1, signal_bruite2);
    z3 = filter(h3, 1, signal_bruite3);
    %on fait le choix sur le dernier
    resul1 = reshape(z1, [], NbBits)';
    resul1 = (resul1(:,end)/Ns1+1)/2>0.5;
    %on fait le choix sur celui du milieu
    resul2 = reshape(z2, [], NbBits)';
    resul2 = (resul2(:,floor(Ns2/2)+1)/Ns2+1)/2>0.5;
    
    %on prend a t0=Ns3
    r3_ech = reshape(z3,[Ns3 NbBits/2])';
    r3_ech = r3_ech(:, end);
    
    resul3 = zeros(1, NbBits/2);
    %on fait les décision
    Echantillon_recep_10 = r3_ech >= (2*Ns3);
    Echantillon_recep_11 = r3_ech < (2*Ns3) & r3_ech >= 0;
    Echantillon_recep_01 = r3_ech < 0 & r3_ech >= -(2*Ns3);
    Echantillon_recep_00 = r3_ech < -(2*Ns3);
    %on met les bits correspondant
    resul3(Echantillon_recep_00==1) = 0;
    resul3(Echantillon_recep_01==1) = 1;
    resul3(Echantillon_recep_10==1) = 2;
    resul3(Echantillon_recep_11==1) = 3;
    resul3 = int2bit(resul3, 2);
    %on remet en forme
    resul3 = reshape(resul3, [NbBits 1]);

    %%%%Calcul des taux d'erreur
    taux1 = sum(abs(Signal-resul1))/NbBits;
    taux2 = sum(abs(Signal-resul2))/NbBits;
    taux3 = sum(abs(Signal-resul3))/NbBits;
    
    TEB1(index) = taux1;
    TEB2(index) = taux2;
    TEB3(index) = taux3;

    TEB1_theo(index) = qfunc(sqrt(2*SNR(index)));
    TEB2_theo(index) = qfunc(sqrt(SNR(index)));
    TEB3_theo(index) = 3/4*qfunc(sqrt(4/5*SNR(index)));

end
%%%%%Affichage
figure(1)
semilogy(SNR_dB, TEB1)
hold on; grid on;
semilogy(SNR_dB, TEB1_theo)
legend('TEB','TEB théorique')
xlabel("SNR")
ylabel("TEB")
title("Comparaison des TEB de la chaine 1")

figure(2)
semilogy(SNR_dB, TEB2)
hold on; grid on;
semilogy(SNR_dB, TEB2_theo)
legend('TEB','TEB théorique')
xlabel("SNR")
ylabel("TEB")
title("Comparaison des TEB de la chaine 2")

figure(3)
semilogy(SNR_dB, TEB3)
hold on; grid on;
semilogy(SNR_dB, TEB3_theo)
legend('TEB','TEB théorique')
xlabel("SNR")
ylabel("TEB")
title("Comparaison des TEB de la chaine 3")

figure(4)
semilogy(SNR_dB, TEB1)
hold on; grid on;
semilogy(SNR_dB, TEB2)
hold on; grid on;
semilogy(SNR_dB, TEB3)
legend('TEB1','TEB2','TEB3')
xlabel("SNR")
ylabel("TEB")
title("Comparaison des TEB pratiquee des trois chaines")

%%%%%fonction pour les modulateurs
%Modulateur 1
function [signal_filtre, Ns] = modulateur_1(signal_binaire,Fe,Rb)
    Ns = Fe/Rb;
    %mapping
    map = zeros(Ns, 1);
    map(1) = 1;
    signal_module = kron(2*signal_binaire-1,map);
    %filtrage par une porte
    signal_filtre = filter(ones(1, Ns), 1, signal_module);
end

%Modulateur 2
function [signal_filtre, Ns] = modulateur_2(signal_binaire,Fe,Rb)
    Ns = Fe/Rb;
    %mapping
    map = zeros(Ns, 1);
    map(1) = 1;
    signal_module = kron(2*signal_binaire-1,map);
    %filtrage par une porte
    signal_filtre = filter(ones(1, Ns), 1, signal_module);
end

%Modulateur 3
function [signal_filtre, Ns] = modulateur_3(signal_binaire,Fe,Rb)
    Ns = 2*Fe/Rb;
    %on reshape pour pouvoir sommer
    signal_resh =reshape(signal_binaire', [2 length(signal_binaire)/2]);
    %on trouve les entiers associé au bits
    signal_int = sum(signal_resh.*[2; 1]);
    %on remplace par les valeurs permettant d'avoir le code de gray
    signal00 = signal_int ==0;
    signal01 = signal_int ==1;
    signal10 = signal_int ==2;
    signal11 = signal_int ==3;
    signal_int(signal00) = -3;
    signal_int(signal01) = -1;
    signal_int(signal10) = 3;
    signal_int(signal11) = 1;
    %on fait le mapping
    map = zeros(Ns, 1);
    map(1) = 1;
    signal_module = kron(signal_int',map);
    %on fait le filtre de mise en forme
    signal_filtre = filter(ones(1, Ns), 1, signal_module);

end