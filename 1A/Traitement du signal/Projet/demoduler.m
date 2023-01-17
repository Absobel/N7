function sortie = demoduler(signal)
    F0 = 1180; F1 = 980;
    theta0 = rand*2*pi; theta1 = rand*2*pi;
    Fe = 48000;
    Te = 1/Fe;
    Rb = 300;
    Ts = 1/Rb;
    Ns = floor(Ts/Te);
    Nbits = length(signal)/Ns;
    bits = randi([0 1],1,Nbits);
    NRZ = kron(bits,ones(1,Ns));
    long = length(NRZ);
    t = 0:Te:(long-1)*Te;

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