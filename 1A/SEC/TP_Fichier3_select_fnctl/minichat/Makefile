.PHONY: all debug clean
CFLAGS = -Wall

all: serveur console cleanpipes

serveur: serveur.c
	gcc $(CFLAGS) -o serveur serveur.c

console: console.c
	gcc $(CFLAGS) -o console console.c

cleanpipes:
	rm -f ecoute *_c2s *_s2c


# Pour éviter que lorsque je debug console.c ça supprime le ./ecoute du serveur
# Also pour ajouter le flag -g
debug:
	serveur_debug console_debug cleanpipes_debug

serveur_debug: serveur.c
	gcc $(CFLAGS) -g -o serveur serveur.c

console_debug: console.c
	gcc $(CFLAGS) -g -o console console.c

cleanpipes_debug:
	rm -f *_c2s *_s2c


# Nettoyage des pipes et des executables
clean:
	rm -f serveur console ecoute *_c2s *_s2c
