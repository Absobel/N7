function parametres = moindres_carres_paire(d,x,y_inf,y_sup,beta_0,gamma_0)
    p = length(x);
    Aj = zeros(2*p,2*d-1);
    for k = 1:d-1
        Aj(1:p,k) = (nchoosek(d,k)*x.^k.*(1-x).^(d-k))';
        Aj(p+1:end,k+d-1) = (nchoosek(d,k)*x.^k.*(1-x).^(d-k))';
    end
    Aj(1:p,2*d-1) = x.^d;
    Aj(p+1:end,2*d-1) = x.^d;
    Bjinf = y_inf - beta_0*(1-x).^d;
    Bjsup = y_sup - gamma_0*(1-x).^d;
    Bj = [Bjinf;Bjsup];

    parametres = Aj\Bj;
end