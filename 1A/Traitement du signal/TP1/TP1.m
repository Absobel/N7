clc,
clear all,
close all,

%% I
% 1 :
Fe1 = 10000;
Te1 = 1/Fe1;
N = 90;
t1 = 0:Te1:(N-1)*Te1;
f0 = 1100;
A = 1;

x1 = A*cos(2*pi*f0*t1);

% 2 :
tiledlayout('flow'); 
ax1 = nexttile;
plot(t1,x1); hold on;
% On peut retrouver la fréquence du cosinus car le critère de Shannon est respecté, il suffit de compter le nombre de périodes sur l'intervalle de temps considéré et diviser par le temps.

% 3 :
Fe2 = 1000;
Te2 = 1/Fe2;
t2 = 0:Te2:(N-1)*Te2;

x2 = A*cos(2*pi*f0*t2);

% 4 :
plot(t2,x2); hold off;
xlabel('t'); ylabel('x(t)');
legend(ax1,{'x1(t)','x2(t)'});
% On ne peut plus retrouver la fréquence du cosinus car le critère de Shannon n'est plus respecté.

%% II
% 1 : Il est justifié de calculer la transformée de Fourrier entre 0 et Fe car 

% 2 :
f1 = 0:Fe1/N:(Fe1-Fe1/N); 
f2 = 0:Fe2/N:(Fe2-Fe2/N);

ax2 = nexttile;
X1 = fft(x1,N);
X2 = fft(x2,N);
semilogy(f1,abs(X1)); hold on;
semilogy(f2,abs(X2)); hold off;
xlabel('f'); ylabel('X(f)');
legend(ax2,{'X1(f)','X2(f)'});

% 3 :
nN = 2^nextpow2(90);
nb_courbes = 4;

ax3 = nexttile;
cell_legend = cell(1,length(nN));
for i = 1:nb_courbes
    nN = 2^nextpow2(nN+1);
    nf = 0:Fe1/nN:(Fe1-Fe1/nN);
    semilogy(nf,abs(fft(x1,nN))); hold on;
    cell_legend{i} = sprintf("N' = %d",nN);
end

xlabel('f'); ylabel('X(f)');
legend(ax3,cell_legend);
title(ax3,"Transformée de Fourier de x1(t) sur N' points");

% 4 :
dsp3 = pwelch(x1,[],[],[],Fe1,'twosided');

ax4 = nexttile;
abscisse = linspace(-Fe1/2,Fe1/2,length(dsp3));
semilogy(abscisse,dsp3);
xlabel('f'); ylabel('DSP');
title(ax4,"Densité spectrale de puissance de x1(t)");
legend(ax4,{'périodigramme de Welch'});