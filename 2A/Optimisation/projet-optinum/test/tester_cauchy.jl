# Ecrire les tests de l'algorithme du pas de Cauchy
using Test

function tester_cauchy(cauchy::Function)

	@testset "Pas de Cauchy" begin
        # Test gradient nul, solution déjà trouvée
        @test [0; 0] == cauchy([0; 0], [7 0; 0 2], 1)
        
        # Test H def pos, pas de Cauchy dans la région de confiance
        @test -2/9 * [1; 1] ≈ cauchy([1; 1], [7 0; 0 2], 1)
        @test -1/7 * [1; 0] ≈ cauchy([1; 0], [7 0; 0 2], 1)
        
        # Test H def pos, pas de Cauchy en dehors de la région de confiance
        @test -0.1/sqrt(2) * [1; 1] ≈ cauchy([1; 1], [7 0; 0 2], 0.1)
        @test -0.1 * [1; 0] ≈ cauchy([1; 0], [7 0; 0 2], 0.1)

        # Test H non def pos
        @test -0.1 * [1; 0] ≈ cauchy([1; 0], [7 0; 0 -2], 0.1)
        @test -0.1 * [1; 0] ≈ cauchy([1; 0], [-7 0; 0 -2], 0.1)
        
    end

end