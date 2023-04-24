function sortie = demoduler(signal,Fe,Rb,F0,F1,theta0,theta1)
    Te = 1/Fe;
    Ts = 1/Rb;
    Ns = floor(Ts/Te);

    t = 0:Te:(length(signal)-1)*Te;
    Nbits = floor(length(signal)/Ns);

    x_int0_0 = reshape(signal.*cos(2*pi*F0*t+theta0),Ns,Nbits);
    x_int00_0 = trapz(x_int0_0);
    x_int00_1 = x_int00_0.^2;

    x_int0_1 = reshape(signal.*sin(2*pi*F0*t+theta0),Ns,Nbits);
    x_int00_2 = trapz(x_int0_1);
    x_int00_3 = x_int00_2.^2;

    x_int1_0 = reshape(signal.*cos(2*pi*F1*t+theta1),Ns,Nbits); 
    x_int11_0 = trapz(x_int1_0);
    x_int11_1 = x_int11_0.^2;

    x_int1_1 = reshape(signal.*sin(2*pi*F1*t+theta1),Ns,Nbits);
    x_int11_2 = trapz(x_int1_1);
    x_int11_3 = x_int11_2.^2;

    new_energie = (x_int11_1 + x_int11_3) - (x_int00_1 + x_int00_3);
    bits_detectes = new_energie > 0;

    sortie = bits_detectes;
end