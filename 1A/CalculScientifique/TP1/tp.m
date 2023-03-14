%--------------------------------------------------------------------------
% ENSEEIHT - 1SN - Calcul scientifique
% TP1 - Orthogonalisation de Gram-Schmidt
% tp.m
%--------------------------------------------------------------------------

clear
close all
clc

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

%% Calcul de la perte d'orthogonalite

% Rang de la matrice
n = 4;

% Puissance de 10 maximale pour le conditionnement
k = 16;

% Matrice U de test
U = gallery('orthog',n);

% Matrice de reference
D = eye(n);

% Initialisation de la matrice pour recuperer les pertes d'orthogonalite
po = zeros(6,k);
% Initialisation de la matrice pour recuperer les conditionnements
condA = zeros(1,k);
condQ = zeros(6,k);

for i = 1:k
  
  % Conditionnement de la matrice A
  %TO DO: modifier D pour obtenir A tel K(A)=10^k
  D(1,1) = 10^i;
  A = U*D*U';
  condA(i) = cond(A);
  
  % Perte d'orthogonalite avec algorithme classique
  Qcgs = cgs(A);
  po(1,i) = norm(eye(n)-Qcgs'*Qcgs);
  condQ(1,i) = cond(Qcgs);
  
  % Perte d'orthogonalite avec algorithme modifie
  Qmgs = mgs(A);
  po(2,i) = norm(eye(n)-Qmgs'*Qmgs);
  condQ(2,i) = cond(Qmgs);

  % classique 2 fois
  Qcgs2 = cgs(Qcgs);
  po(3,i) = norm(eye(n)-Qcgs2'*Qcgs2);
  condQ(3,i) = cond(Qcgs2);

  % modifie 2 fois
  Qmgs2 = mgs(Qmgs);
  po(4,i) = norm(eye(n)-Qmgs2'*Qmgs2);
  condQ(4,i) = cond(Qmgs2);

  % classique 3 fois
  Qcgs3 = cgs(Qcgs2);
  po(5,i) = norm(eye(n)-Qcgs3'*Qcgs3);
  condQ(5,i) = cond(Qcgs3);

  % modifie 3 fois
  Qmgs3 = mgs(Qmgs2);
  po(6,i) = norm(eye(n)-Qmgs3'*Qmgs3);  
  condQ(6,i) = cond(Qmgs3);
end

%% Affichage des courbes d'erreur

x = 10.^(1:k);

figure('Position',[0.1*L,0.1*H,0.8*L,0.75*H])
subplot(2,1,1)

    loglog(x,po(1,:),'r','lineWidth',2)
    hold on
    loglog(x,po(2,:),'b','lineWidth',2)
    loglog(x,po(3,:),'r--','lineWidth',2)
    loglog(x,po(4,:),'b--','lineWidth',2)
    loglog(x,po(5,:),'r:','lineWidth',2)
    loglog(x,po(6,:),'b:','lineWidth',2)
    grid on
    leg = legend('Gram-Schmidt classique',...
                 'Gram-Schmidt modifie',...
                  'Gram-Schmidt classique 2 fois',...
                  'Gram-Schmidt modifie 2 fois',...
                  'Gram-Schmidt classique 3 fois',...
                  'Gram-Schmidt modifie 3 fois',...
                 'Location','NorthWest');
    set(leg,'FontSize',14);
    xlim([x(1) x(end)])
    hx = xlabel('\textbf{Conditionnement $\mathbf{\kappa(A_k)}$}',...
                'FontSize',14,'FontWeight','bold');
    set(hx,'Interpreter','Latex')
    hy = ylabel('$\mathbf{|| I - Q_k^\top Q_k ||}$','FontSize',14,'FontWeight','bold');
    set(hy,'Interpreter','Latex')
    title('Evolution de la perte d''orthogonalite en fonction du conditionnement',...
          'FontSize',20)

subplot(2,1,2)

    loglog(x,condQ(1,:),'r','lineWidth',2)
    hold on
    loglog(x,condQ(2,:),'b','lineWidth',2)
    loglog(x,condQ(3,:),'r--','lineWidth',2)
    loglog(x,condQ(4,:),'b--','lineWidth',2)
    loglog(x,condQ(5,:),'r:','lineWidth',2)
    loglog(x,condQ(6,:),'b:','lineWidth',2)
    grid on
    leg = legend('Gram-Schmidt classique',...
                 'Gram-Schmidt modifie',...
                  'Gram-Schmidt classique 2 fois',...
                  'Gram-Schmidt modifie 2 fois',...
                  'Gram-Schmidt classique 3 fois',...
                  'Gram-Schmidt modifie 3 fois',...
                 'Location','NorthWest');
    set(leg,'FontSize',14);
    xlim([x(1) x(end)])
    hx = xlabel('\textbf{Conditionnement $\mathbf{\kappa(A_k)}$}',...
                'FontSize',14,'FontWeight','bold');
    set(hx,'Interpreter','Latex')
    hy = ylabel('$\mathbf{\kappa(Q_k)}$','FontSize',14,'FontWeight','bold');
    set(hy,'Interpreter','Latex')
    title('Evolution du conditionnement de la matrice Q en fonction du conditionnement de A',...
          'FontSize',20)


