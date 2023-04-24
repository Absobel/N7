%% I :
% 1 :
Fe1 = 10000;
Te1 = 1/Fe1;
N = 100;
t1 = 0:Te1:(N-1)*Te1;
f1 = 1000;
f2 = 3000;
A = 1;

x1 = A*cos(2*pi*f1*t1);
x2 = A*cos(2*pi*f2*t1);
x3 = x1 + x2;

% 2 :
    % figure(1);
    % tiledlayout('flow'); 
    % ax1 = nexttile;
    % plot(t1,x1); hold on;
    % plot(t1,x2); hold off
    % xlabel('t'); ylabel('x(t)');
    % legend(ax1, {'x1(t)', 'x2(t)'});
    % ax2 = nexttile;
    % plot(t1,x3);
    % xlabel('t'); ylabel('x(t)');
    % legend(ax2, {'(x1+x2)(t)'});

% 3 :
N = 2048;
X3 = fft(x3,N);
ax3 = nexttile;
f = linspace(0,Fe1,N);

    % semilogy(f,abs(X3));
    % xlabel('f'); ylabel('X(f)');
    % legend(ax3, {"X3(f)"});

%% II :
% 1 :
ordre1 = 11;
fc = 2000;
hc1 = (2*fc/Fe1)*sinc(2*fc/Fe1*[-(ordre1-1)/2:(ordre1-1)/2]);
ordre2 = 61;
hc2 = (2*fc/Fe1)*sinc(2*fc/Fe1*[-(ordre2-1)/2:(ordre2-1)/2]);

% 2 :
    % figure(2);
    % tiledlayout('flow');
    % ax1 = nexttile;
    % plot(hc1); hold on;
    % plot(hc2); hold off;
    % xlabel('t'); ylabel('hc(t)');
    % legend(ax1, {'ordre 11', 'ordre 61'});

% 3 :
HC1 = fft(hc1,N);
HC2 = fft(hc2,N);
ax2 = nexttile;
f = linspace(0,Fe1,N);

    % semilogy(f,abs(HC1)); hold on;
    % semilogy(f,abs(HC2));
    % semilogy(f,abs(X3)); hold off;
    % xlabel('f');
    % legend(ax2, {'ordre 11', 'ordre 61', 'X3(f)'});


%% III :
% 1 :
M = length(X3);
HC1 = fft(hc1,M);
HC2 = fft(hc2,M);
f = linspace(0,Fe1,M);

    tiledlayout('flow');
    ax1 = nexttile;
    semilogy(f,abs(X3)); hold on;
    semilogy(f,abs(HC1)); hold on;
    semilogy(f,abs(HC2)); hold off;
    xlabel('f');
    legend(ax1, {'X3(f)', 'HC1(f)', 'HC2(f)'});

% 2 :
y1 = filter(hc1,1,x3);
y2 = filter(hc2,1,x3);

    ax2 = nexttile;
    plot(t1,x3); hold on;
    plot(t1,y1);
    plot(t1,y2); hold off;
    xlabel('t');
    legend(ax2, {'x3(t)', 'y1(t)', 'y2(t)'});

% Y1 = X3.*HC1;
% Y2 = X3.*HC2;
%     ax2 = nexttile;
%     semilogy(f,abs(Y1)); hold on;
%     semilogy(f,abs(Y2)); hold off;
%     xlabel('f');
%     legend(ax2, {'Y1(f)', 'Y2(f)'});
