clear all; close all; clc;

Fe = 24000;
Te = 1/Fe;
Rb = 3000;
Tb = 1/Rb;
Ts = Tb;
Ns = floor(Tb/Te); % car mapping binaire avec filtre rectangulaire de durée égale à la durée symbole
nbits = 1000;

bits = randi([0 1],1,nbits);
h = ones(1,Ns);

g = conv(h,h);

ak = 2*bits-1;
x = kron(ak,[1 zeros(1,Ns-1)]);
z = filter(g,1,x);

z_echant = zeros(1,length(z));
for i = Ns:Ns:length(z)
    z_echant(i:(i+Ns-1)) = z(i);
end

decisions = z_echant(Ns:Ns:end)>0;
erreur_n0_Ns = sum(decisions~=bits)/length(bits)

decisions = z_echant(3:Ns:end)>0;
size(bits)
size(decisions)
erreur_n0_3 = sum(decisions~=bits)/length(bits)



% plot

figure("Name","Signal généré en sortie du filtre de reception");
plot(z);
title('Signal généré en sortie du filtre de reception');

figure("Name","Réponse impulsionnelle de g");
stem(g);
title('Réponse impulsionnelle de g');

%figure(3)
%ax1 = nexttile;
%plot(reshape(z(Ns+1:end),Ns,(length(z)-Ns)/Ns));
eyediagram(z(Ns+1:end),2*Ns,2*Ns,Ns-1);
title('Diagramme oeil');


