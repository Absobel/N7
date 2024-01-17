import sys
import math

def calcul_imc(poids, taille):
    try:
        poids = float(poids)
        taille = float(taille)
        if poids == 0 or taille == 0:
            return "Données non valides"
        else:
            return math.ceil(poids / ((taille/100) ** 2))
    except ValueError:
        return ""

if __name__ == "__main__":
        result = calcul_imc(sys.argv[1], sys.argv[2])
        print(result)
