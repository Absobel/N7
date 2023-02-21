function beta = moindres_carres(d,x,y,beta_0)
    p = length(x);
    Aj = zeros(p,d);
    for k = 1:d
        Aj(:,k) = (nchoosek(d,k)*x.^k.*(1-x).^(d-k))';
    end
    Bj = y - beta_0*(1-x).^d

    beta = Aj\Bj;
end