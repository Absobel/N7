function [image_compressed] = image_compression_method2_eig(eigen_calc, image, k)
    [p,q] = size(image);
    
    isALEndroit = p <= q;
    if ~isALEndroit
        image = image';
        [p,q] = size(image);
    end

    if isequal(@eigen_calc, @eig)
        [Uk, diag_eigenU] = eig(image*image');
    else
        [Uk, diag_eigenU] = eigen_calc(image*image', k, 1e-6, 100);
    end

    singularU = sqrt(diag(diag_eigenU));
    [singularU, index] = sort(singularU, 'descend');
    singularUk = singularU(1:k);
    Uk = Uk(:,index(1:k));

    SigmaK = diag(singularUk);

    Vk = zeros(q,k);
    for i = 1:k
        Vk(:,i) = image'*Uk(:,i)/SigmaK(i,i);
    end

    image_compressed = Uk*SigmaK*Vk';

    if ~isALEndroit
        image_compressed = image_compressed';
    end
end