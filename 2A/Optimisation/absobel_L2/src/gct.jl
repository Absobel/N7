using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s, sous la contrainte ‖s‖ ≤ Δₖ

# Syntaxe

    s = gct(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Matrix{<:Real}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • max_iter : le nombre maximal d'iterations (optionnel, par défaut 100)
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel  : la tolérence relative (optionnel, par défaut 1e-8)

# Sorties

    - s : (Vector{<:Real}) une approximation de la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = gct(g, H, Δ)

"""

function gct(g::Vector{<:Real}, H::Matrix{<:Real}, Δ::Real; 
    max_iter::Integer = 100, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8)

    n = length(g)

    s = zeros(length(g))
    g0 = g
    j = 0
    p = -g

    function solve(sj, pj)
        a = transpose(pj) * pj
        b = 2*transpose(sj) * pj
        c = transpose(sj) * sj - Δ^2
        σ1 = (-b + sqrt(b^2 - 4*a*c)) / (2*a)
        σ2 = (-b - sqrt(b^2 - 4*a*c)) / (2*a)

        return σ1, σ2
    end

    function presque_q(s)
        return transpose(g) * s + 0.5 * transpose(s) * H * s
    end

    while j < 2*n && norm(g) > max(norm(g0)*tol_rel, tol_abs)
        k = transpose(p) * H * p
        if k <= 0
            #  la racine de ∥sj + σpj ∥ = ∆ pour laquelle q(sj + σpj ) est la plus petite
            σ1, σ2 = solve(s, p)
            if presque_q(s + σ1 * p) < presque_q(s + σ2 * p)
                σ = σ1
            else
                σ = σ2
            end
            return s + σ * p
        end
        α = transpose(g) * g / k
        if norm(s + α * p) >= Δ
            #  la racine positive de ∥sj + σpj ∥ = ∆
            σ1, σ2 = solve(s, p)
            σ = max(σ1, σ2)
            return s + σ * p
        end
        s = s + α * p
        g_prev = g
        g = g + α * H * p
        β = (transpose(g) * g) / (transpose(g_prev) * g_prev)
        p = -g + β * p
        j += 1
    end

   return s
end
