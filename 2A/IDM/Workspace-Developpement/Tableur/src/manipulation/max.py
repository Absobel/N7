import sys

def max_value(liste):
    if len(liste) == 0:
        return " "
    else:
        return max(liste)  

if __name__ == "__main__":
    liste = [float(arg) for arg in sys.argv[1:]]  # Convertit tous les arguments en nombres flottants
    maximum = max_value(liste)
    print(maximum)