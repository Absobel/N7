function y = bezier(x, beta_vect)
    beta_0 = beta_vect(1);
    beta = beta_vect(2:end);
    d = length(beta);

    y = beta_0*(1-x).^d;
    for k = 1:d
        Bdk = nchoosek(d,k)*x.^k.*(1-x).^(d-k);
        y = y + beta(k)*Bdk;
    end
end