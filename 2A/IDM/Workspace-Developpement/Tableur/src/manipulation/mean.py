# calcul_imc.py
import sys
import statistics  

def mean_value(liste):
    if len(liste) == 0:
        return " "
    else:
        return statistics.mean(liste)  

if __name__ == "__main__":
    liste = [float(arg) for arg in sys.argv[1:]]  # Convertit tous les arguments en nombres flottants
    moyenne = mean_value(liste)
    print(moyenne)