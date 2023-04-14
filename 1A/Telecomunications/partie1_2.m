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
dsp_signal1 = pwelch(signal_genere1,[],[],[],Fe,'twosided');
f1 = linspace(-Fe/2,Fe/2,length(dsp_signal1));
dsp_signal1_th = Ts*(sinc(f1*Ts)).^2/4;

% Modulateur 2
% -------------

n = 2;
Ts = n*Tb;
Ns = floor(Ts/Te);
t2 = 0:Te:(Ns-1)*Te;

h2 = t2>=0;
mapping = [-3, -1, 3, 1];
ak2 = reshape(bits, 2, []);
ak2 = mapping(bi2de(ak2', 'left-msb')+1);

x2 = kron(ak2,[1 zeros(1,Ns-1)]);
signal_genere2 = filter(h2,1,x2);
t_correct2 = (0:Te:(length(signal_genere2)-1)*Te)/n;

% DSP

dsp_signal2 = pwelch(signal_genere2,[],[],[],Fe,'twosided');
f2 = linspace(-Fe/2,Fe/2,length(dsp_signal2));
dsp_signal2_th = 5*Ts*sinc(f2*Ts).^2/4;

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

dsp_signal3 = pwelch(signal_genere3,[],[],[],1,'twosided'); % mettre 1 parce que sinon pwelch divise par Fe
f3 = linspace(-Fe/2,Fe/2,length(dsp_signal3));

sigma = 1;
dsp_signal3_th = sigma^2/Ts*ones(1,length(f3));

condition1 = abs(f3) <= (1-alpha)/(2*Ts);
condition2 = (abs(f3) > (1-alpha)/(2*Ts)) & (abs(f3) <= (1+alpha)/(2*Ts));
condition3 = abs(f3) > (1+alpha)/(2*Ts);

dsp_signal3_th(condition1) = dsp_signal3_th(condition1) * Ts;
dsp_signal3_th(condition2) = dsp_signal3_th(condition2) .* Ts .* (1 + cos(pi * Ts/alpha * (abs(f3(condition2)) - (1-alpha)/(2*Ts)))) / 2;
dsp_signal3_th(condition3) = 0;




% plot 

% Modulateur 1

figure("Name","Modulateur 1");
tiledlayout("flow");

ax1 = nexttile;
plot(t_correct1,signal_genere1);
title('Signal généré par le modulateur 1');


ax2 = nexttile;
semilogy(f1, fftshift(abs(dsp_signal1))); hold on;
semilogy(f1, abs(dsp_signal1_th)); hold off;
title('DSP du signal généré par le modulateur 1');
legend('DSP','DSP théorique') ;

ax3 = nexttile;
semilogy(f1, fftshift(abs(dsp_signal1)));
title('DSP du signal généré par le modulateur 1');

% Modulateur 2

figure("Name","Modulateur 2");
tiledlayout("flow");

ax1 = nexttile;
plot(t_correct2,signal_genere2);
title('Signal généré par le modulateur 2');

ax2 = nexttile;
semilogy(f2, fftshift(abs(dsp_signal2))); hold on;
semilogy(f2, abs(dsp_signal2_th)); hold off;
title('DSP du signal généré par le modulateur 2');
legend('DSP','DSP théorique');

ax3 = nexttile;
semilogy(f2, fftshift(abs(dsp_signal2)));
title('DSP du signal généré par le modulateur 2');

% Modulateur 3

figure("Name","Modulateur 3");
tiledlayout("flow");

ax1 = nexttile;
plot(t_correct3,signal_genere3);
title('Signal généré par le modulateur 3');

ax2 = nexttile;
semilogy(f3, fftshift(abs(dsp_signal3))  ); hold on;
semilogy(f3, abs(dsp_signal3_th)); hold off;
title('DSP du signal généré par le modulateur 3');
legend('DSP','DSP théorique');

ax3 = nexttile;
semilogy(f3, fftshift(abs(dsp_signal3)));
title('DSP du signal généré par le modulateur 3');

% Superposition des DSP

figure("Name","Superposition des DSP");
semilogy(f1, dsp_signal1); hold on;
semilogy(f2, dsp_signal2); hold on;
semilogy(f3, dsp_signal3); hold off;
title('DSP des signaux générés par les modulateurs 1, 2 et 3');
legend('Modulateur 1','Modulateur 2','Modulateur 3');

% Superposition des DSP théoriques

figure("Name","Superposition des DSP théoriques");
semilogy(f1, abs(dsp_signal1_th)); hold on;
semilogy(f2, abs(dsp_signal2_th)); hold on;
semilogy(f3, abs(dsp_signal3_th)); hold off;
title('DSP théoriques des signaux générés par les modulateurs 1, 2 et 3');
legend('Modulateur 1','Modulateur 2','Modulateur 3');