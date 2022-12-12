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
tiledlayout('flow'); 
ax1 = nexttile;
plot(t1,x1); hold on;
plot(t1,x2); hold off
xlabel('t'); ylabel('x(t)');
legend(ax1, {'x1(t)', 'x2(t)'});
ax2 = nexttile;
plot(t1,x3);
xlabel('t'); ylabel('x(t)');
legend(ax2, {'(x1+x2)(t)'});

% 3 :
N = 2048;
X3 = fft(x3,N);
ax3 = nexttile;
f = linspace(0,Fe1,N);
semilogy(f,abs(X3));
xlabel('f'); ylabel('X(f)');
legend(ax3, {"X3(f)"});

%% II :
% 1 :
