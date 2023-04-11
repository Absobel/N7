function [X_VS,w,c,code_retour] = SVM_2(X,Y)
    n = length(X);
    f = -ones(n,1);
    H = (Y.*X)*(Y.*X)';
    Aeq = Y';
    lb = zeros(n,1);

    [alpha,~,code_retour] = quadprog(H,f,[],[],Aeq,0,lb,[]);

    w = X'*(alpha.*Y);
    c = X*w - 1./Y;
    eps = 1e-6;
    X_VS = X(alpha > eps,:);
    Y_VS = Y(alpha > eps,:);
    c = mean(X_VS*w - Y_VS);
end