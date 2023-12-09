using Test
include("../test/fonctions_de_tests.jl")

"""
Tester l'algorithme des régions de confiance avec le gradient conjugué tronqué

# Entrées

	- afficher : (Bool) affichage ou non des résultats de chaque test

# les cas de test (dans l'ordre)

	- fct 1 : x011, x012
	- fct 2 : x021, x022, x023

"""
function tester_rc_gct(rc::Function, afficher::Bool)

    println("Affichage des résultats des algorithmes : ", afficher, "\n")

	# La tolérance utilisée dans les tests
	tol_erreur = 1e-2

	# 
	algo_pas = "gct"

	# l'ensemble de tests
	@testset "RC et gct" begin

		# cas de test 1
		x_sol, f_sol, flag, nb_iters, _ = rc(fct1, grad_fct1, hess_fct1, pts1.x011, algo_pas=algo_pas)
		if (afficher)
			afficher_resultats("RC et " * algo_pas, "f1", pts1.x011, x_sol, f_sol, flag, nb_iters, sol_exacte_fct1)
		end
		@test x_sol ≈ sol_exacte_fct1 atol=tol_erreur
		@test flag == 0
		@test nb_iters == 1

		# cas de test 2
		x_sol, f_sol, flag, nb_iters  = rc(fct1, grad_fct1, hess_fct1, pts1.x012, algo_pas=algo_pas)
		if (afficher)
			afficher_resultats("RC et " * algo_pas, "f1", pts1.x012, x_sol, f_sol, flag, nb_iters, sol_exacte_fct1)
		end
		@test x_sol ≈ sol_exacte_fct1 atol=tol_erreur
		@test flag == 0
		@test nb_iters == 3

		# cas de test 3
		x_sol, f_sol, flag, nb_iters, _ = rc(fct2, grad_fct2, hess_fct2, pts1.x021, algo_pas=algo_pas)
		if (afficher)
			afficher_resultats("RC et " * algo_pas, "f2", pts1.x021, x_sol, f_sol, flag, nb_iters, sol_exacte_fct2)
		end
		@test x_sol ≈ sol_exacte_fct2 atol=tol_erreur
		@test flag == 0
		@test nb_iters == 31

		# cas de test 4
		x_sol, f_sol, flag, nb_iters, _ = rc(fct2, grad_fct2, hess_fct2, pts1.x022, algo_pas=algo_pas)
		if (afficher)
			afficher_resultats("RC et " * algo_pas, "f2", pts1.x022, x_sol, f_sol, flag, nb_iters, sol_exacte_fct2)
		end
		@test x_sol ≈ sol_exacte_fct2 atol=tol_erreur
		@test flag == 0
		@test nb_iters == 44

		# cas de test 5
		x_sol, f_sol, flag, nb_iters, _ = rc(fct2, grad_fct2, hess_fct2, pts1.x023, algo_pas=algo_pas)
		if (afficher)
			afficher_resultats("RC et " * algo_pas, "f2", pts1.x023, x_sol, f_sol, flag, nb_iters, sol_exacte_fct2)
		end
		@test x_sol ≈ sol_exacte_fct2 atol=tol_erreur
		@test flag == 0
		@test nb_iters == 19
	
	end
end
