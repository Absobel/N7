clear all; close all; clc;


tout(1000)
tout(8000)


function [] = tout(BW)
    Fe = 24000;
    Te = 1/Fe;
    Rb = 3000;
    Tb = 1/Rb;
    Ts = Tb;
    Ns = floor(Tb/Te); % car mapping binaire avec filtre rectangulaire de durée égale à la durée symbole
    nbits = 1000;
    
    bits = randi([0 1],1,nbits);
    
    ak = 2*bits-1;
    x = kron(ak,[1 zeros(1,Ns-1)]);
    
    h = ones(1,Ns);
    h_r =fliplr(h);
    t = linspace(-50,50);
    hc = 2*BW*sinc(2*(BW/Fe)*t)/Fe;
    
    g = conv(conv(h,h_r),hc);

    z = filter(g,1,x);

    z_echant = zeros(1,length(z));
    for i = Ns:Ns:length(z)
        z_echant(i:(i+Ns-1)) = z(i);
    end

    decisions = z_echant(Ns:Ns:end)>0;
    erreur_n0_Ns = sum(decisions~=bits)/length(bits);

    % plot

    figure("Name","Réponse impulsionelle globale de la chaîne de transmission")
    plot(g)
    title("Réponse impulsionelle globale de la chaîne de transmission")
    xlabel("n")
    ylabel("g[n]")

    eyediagram(z(Ns:end),2*Ns,2*Ns,Ns-1)
    
    
    figure("Name","Tracé de filtres");
    H =fft(h,1024);
    H_r =fft(h,1024);
    H_c = fft(hc,1024);
    G = abs(H.*H_r);
    f = linspace(-Fe/2, Fe/2, 1024); % Ajout de l'échelle de fréquence
    semilogy(f, fftshift(G) ); hold on;
    semilogy(f, fftshift(abs(H_c))); hold off;
    xlabel('Fréquence (Hz)');
    ylabel('Magnitude');
    legend('Filtre de mise en forme et réception', 'Filtre canal');
    title('Tracé de filtres');

end