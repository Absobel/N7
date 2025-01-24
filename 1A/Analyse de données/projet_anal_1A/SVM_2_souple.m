function [X_VS,w,c,code_retour] = SVM_2_souple(X, Y, lambda)

    n = length(X);

    f = -ones(1, n);
    H = (X.*Y) * (X.*Y)';
    b = [];
    A = [];
    Aeq = Y';
    beq = 0;
    LB = zeros(n, 1);
    UB = lambda*ones(n, 1);

    [alphas, ~, code_retour] = quadprog(H, f, A, b, Aeq, beq, LB, UB);
    w = (Y.* X)' * alphas;

    eps = 1e-6;
    alphas_B = (lambda - eps) > alphas & alphas > eps;
    X_VS = X(alphas_B, :);
    Y_VS = Y(alphas_B, :);
    c = mean(X_VS*w-Y_VS);
end

