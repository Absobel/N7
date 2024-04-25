using LinearAlgebra
include("../src/cauchy.jl")
include("../src/gct.jl")
"""
Approximation de la solution du problème min f(x), x ∈ Rⁿ.

L'algorithme des régions de confiance résout à chaque itération, un modèle quadratique
de la fonction f dans une boule (appelée la région de confiance) de centre l'itéré 
courant. Cette minimisation se fait soit par un pas de Cauchy ou par l'algorithme 
du gradient conjugué tronqué.

# Syntaxe

    x_sol, f_sol, flag, nb_iters, xs = regions_de_confiance(f, gradf, hessf, x0; kwargs...)

# Entrées

    - f       : (Function) la fonction à minimiser
    - gradf   : (Function) le gradient de la fonction f
    - hessf   : (Function) la hessienne de la fonction f
    - x0      : (Vector{<:Real}) itéré initial
    - kwargs  : les options sous formes d'arguments "keywords"
        • max_iter      : (Integer) le nombre maximal d'iterations (optionnel, par défaut 5000)
        • tol_abs       : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel       : (Real) la tolérence relative (optionnel, par défaut 1e-8)
        • epsilon       : (Real) le epsilon pour les tests de stagnation (optionnel, par défaut 1)
        • Δ0            : (Real) le rayon initial de la région de confiance (optionnel, par défaut 2)
        • Δmax          : (Real) le rayon maximal de la région de confiance (optionnel, par défaut 10)
        • γ1, γ2        : (Real) les facteurs de mise à jour de la région de confiance (optionnel, par défaut 0.5 et 2)
        • η1, η2        : (Real) les seuils pour la mise à jour de la région de confiance (optionnel, par défaut 0.25 et 0.75)
        • algo_pas      : (String) l'algorithme de calcul du pas - "cauchy" ou "gct" (optionnel, par défaut "gct")
        • max_iter_gct  : (Integer) le nombre maximal d'iterations du GCT (optionnel, par défaut 2*length(x0))

# Sorties

    - x_sol : (Vector{<:Real}) une approximation de la solution du problème
    - f_sol : (Real) f(x_sol)
    - flag  : (Integer) indique le critère sur lequel le programme s'est arrêté
        • 0  : convergence
        • 1  : stagnation du xk
        • 2  : stagnation du f
        • 3  : nombre maximal d'itération dépassé
    - nb_iters : (Integer) le nombre d'itérations faites par le programme
    - xs    : (Vector{Vector{<:Real}}) les itérés

# Exemple d'appel

    f(x)=100*(x[2]-x[1]^2)^2+(1-x[1])^2
    gradf(x)=[-400*x[1]*(x[2]-x[1]^2)-2*(1-x[1]) ; 200*(x[2]-x[1]^2)]
    hessf(x)=[-400*(x[2]-3*x[1]^2)+2  -400*x[1];-400*x[1]  200]
    x0 = [1; 0]
    x_sol, f_sol, flag, nb_iters, xs = regions_de_confiance(f, gradf, hessf, x0, algo_pas="gct")

"""
function regions_de_confiance(f::Function, gradf::Function, hessf::Function, x0::Vector{<:Real};
    max_iter::Integer=5000, tol_abs::Real=1e-10, tol_rel::Real=1e-8, epsilon::Real=1, 
    Δ0::Real=2, Δmax::Real=10, γ1::Real=0.5, γ2::Real=2, η1::Real=0.25, η2::Real=0.75, algo_pas::String="gct",
    max_iter_gct::Integer = 2*length(x0))

    #
    x_sol = x0
    f_sol = f(x_sol)
    flag  = 3
    nb_iters = 0
    xs = [x0] # vous pouvez faire xs = vcat(xs, [xk]) pour concaténer les valeurs
    Δk = Δ0

    if norm(gradf(x_sol)) <= max(tol_rel*norm(gradf(x0)), tol_abs)
        flag = 0
        return x_sol, f_sol, flag, nb_iters, xs
    end

    for k in 1:max_iter
        x_prev = x_sol
        f_prev = f_sol
        
        if algo_pas == "cauchy"
            sk = cauchy(gradf(x_sol), hessf(x_sol), Δk, tol_abs=tol_abs)
        elseif algo_pas == "gct"
            sk = gct(gradf(x_sol), hessf(x_sol), Δk, max_iter=max_iter_gct, tol_abs=tol_abs, tol_rel=tol_rel)
        end

        function m(s)
            return f(x_sol) + transpose(gradf(x_sol)) * s + 0.5 * transpose(s) * hessf(x_sol) * s
        end

        pk = (f(x_sol) - f(x_sol + sk)) / (m(zeros(length(sk))) - m(sk))

        if pk >= η1
            x_sol = x_sol + sk
        end
        if pk >= η2
            Δk = min(γ2 * Δk, Δmax)
        elseif pk < η1
            Δk = γ1 * Δk
        end

        f_sol = f(x_sol)
        xs = vcat(xs, [x_sol])
        nb_iters = k

        if norm(gradf(x_sol)) <= max(tol_rel*norm(gradf(x0)), tol_abs)
            flag = 0
            break
         elseif x_prev != x_sol && norm(x_sol - x_prev) < epsilon*max(tol_rel*norm(x_prev), tol_abs)
            flag = 1
            break
         elseif x_prev != x_sol && abs(f_sol - f_prev) < epsilon*max(tol_rel*norm(f_prev), tol_abs) 
            flag = 2
            break
        end
    end

    return x_sol, f_sol, flag, nb_iters, xs
end
