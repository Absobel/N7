clear all; close all; clc;

Fe = 24000;
Te = 1/Fe;

Rb = 3000;
Tb = 1/Rb;

nbits = 1000;
bits = randi([0 1],1,nbits);

% Modulateur 1
% -------------

n = 1;
Ts = n*Tb;
Ns = floor(Ts/Te);
t1 = 0:Te:(Ns-1)*Te;

h1 = t1>=0;
ak1 = 2*bits-1;
x1 = kron(ak1,[1 zeros(1,Ns-1)]);

signal_genere1 = filter(h1,1,x1);
t_correct1 = (0:Te:(length(signal_genere1)-1)*Te)/n;

% DSP
dsp_signal1 = pwelch(signal_genere1,[],[],[],Fe,'centered');
f1 = linspace(-Fe/2,Fe/2,length(dsp_signal1));


% Modulateur 2
% -------------

n = 2;
Ts = n*Tb;
Ns = floor(Ts/Te);
t2 = 0:Te:(Ns-1)*Te;

h2 = t2>=0;
ak2 = zeros(1,length(bits)/2);
for i = 1:2:length(bits)
    if bits(i) == 0 && bits(i+1) == 0
        ak2(i) = -2;
        %ak2(i+1) = -2;
    elseif bits(i) == 0 && bits(i+1) == 1
        ak2(i) = -1;
        %ak2(i+1) = -1;
    elseif bits(i) == 1 && bits(i+1) == 0
        ak2(i) = 2;
        %ak2(i+1) = 2;
    else
        ak2(i) = 1;
        %ak2(i+1) = 1;
    end
end
x2 = kron(ak2,[1 zeros(1,Ns-1)]);
signal_genere2 = filter(h2,1,x2);
t_correct2 = (0:Te:(length(signal_genere2)-1)*Te)/n;

% DSP

dsp_signal2 = pwelch(signal_genere2,[],[],[],Fe,'centered');
f2 = linspace(-Fe/2,Fe/2,length(dsp_signal2));


% Modulateur 3
% -------------

n = 1;
Ts = n*Tb;
Ns = floor(Ts/Te);
t3 = 0:Te:(Ns-1)*Te;

L = 2;
alpha = 0.25;
h3 = rcosdesign(alpha,L,Ns);
ak = 2*bits-1;
x3 = kron(ak,[1 zeros(1,Ns-1)]);

signal_genere3 = filter(h3,1,x3);
t_correct3 = (0:Te:(length(signal_genere3)-1)*Te)/n;

% DSP

dsp_signal3 = pwelch(signal_genere3,[],[],[],Fe,'centered');
f3 = linspace(-Fe/2,Fe/2,length(dsp_signal3));


% plot 

% Modulateur 1

figure(1)
tiledlayout("flow")

ax1 = nexttile;
plot(t_correct1,signal_genere1)
title('Signal généré par le modulateur 1')

ax2 = nexttile;
semilogy(f1, dsp_signal1);
title('DSP du signal généré par le modulateur 1');

% Modulateur 2

figure(2)
tiledlayout("flow")

ax1 = nexttile;
plot(t_correct2,signal_genere2)
title('Signal généré par le modulateur 2')

ax2 = nexttile;
semilogy(f2, dsp_signal2);
title('DSP du signal généré par le modulateur 2');

% Modulateur 3

figure(3)
tiledlayout("flow")

ax1 = nexttile;
plot(t_correct3,signal_genere3)
title('Signal généré par le modulateur 3')

ax2 = nexttile;
semilogy(f3, dsp_signal3);
title('DSP du signal généré par le modulateur 3');