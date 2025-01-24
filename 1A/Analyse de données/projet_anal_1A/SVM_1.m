function [X_VS,w,c,code_retour] = SVM_1(X, Y)

    f = [0; 0; 0];
    H = [1 0 0; 0 1 0; 0 0 0];
    b = -ones(length(X), 1);
    A = -Y.*[X(:,1) X(:,2) b];

    [W, ~, code_retour] = quadprog(H, f, A, b);
    w = W(1:2);
    c = W(3);

    eps = 1e-6;
    X_VS = X(abs(A*W-b) <= eps, :);

end

