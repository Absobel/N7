function [X_VS,Y_VS,Alpha_VS,c,code_retour] = SVM_3_souple(X, Y, sigma, lambda)

    n = length(X);

    f = -ones(1, n);
    H = zeros(n);
    K = zeros(n);

    for i=1:n
        for j=1:n
            Xd = X(i, :) - X(j, :);
            K(i,j) = exp(- Xd*Xd'/(2*sigma^2));
            H(i, j) = Y(i)*K(i,j)*Y(j);
        end
    end

    b = [];
    A = [];
    Aeq = Y';
    beq = 0;
    LB = zeros(n, 1);
    UB = lambda*ones(n, 1);

    [alphas, ~, code_retour] = quadprog(H, f, A, b, Aeq, beq, LB, UB);

    eps = 1e-6;
    alphas_B = (alphas > eps) & (lambda - eps > alphas);
    X_VS = X(alphas_B, :);
    Y_VS = Y(alphas_B, :);
    Alpha_VS = alphas(alphas_B, :);
    K_VS = K(:, alphas_B);
    c = (alphas_B.*Y)'*K_VS(:,1)-Y_VS(1);
end

