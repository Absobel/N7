function V = vraisemblance(valeurs_carac_1i, valeurs_carac_2j, mu, Sigma)
    X = [valeurs_carac_1i; valeurs_carac_2j];
    Xc = X - mu;
    V = exp(-0.5*Xc'*(Sigma\Xc))/(2*pi*sqrt(det(Sigma)));
end