function [y_inf,y_sup] = tirage_aleatoire(x,moyennes,ecarts_types,beta_0,gamma_0)
    [a,b] = size(ecarts_types);
    param = randn(a,b).*ecarts_types + moyennes;
    d = (length(param)-1)/2;
    epsilon = param(end);
    beta = [param(1:d-1);epsilon];
    gamma = [param(d:end-1);epsilon];
    y_inf = bezier(x,[beta_0;beta]);
    y_sup = bezier(x,[gamma_0;gamma]);
end