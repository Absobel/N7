function [X_VS,w,c,code_retour] = SVM_2(X, Y)

    n = length(X);

    f = -ones(1, n);
    H = (X.*Y) * (X.*Y)';
    Aeq = Y';
    beq = 0;
    LB = zeros(n, 1);

    [alphas, ~, code_retour] = quadprog(H, f, [], [], Aeq, beq, LB);
    w = (Y.* X)' * alphas;

    eps = 1e-6;
    X_VS = X(alphas > eps, :);
    Y_VS = Y(alphas > eps, :);
    c = mean(X_VS*w-Y_VS);
end

