.PHONY: all debug clean
CFLAGS = -Wall -Wextra -g

all: serveur console chatmmap cleanpipes

debug: serveur console chatmmap cleanpipes_debug

serveur: serveur.c
	gcc $(CFLAGS) -o serveur serveur.c

console: console.c
	gcc $(CFLAGS) -o console console.c

chatmmap: chatmmap.c
	gcc $(CFLAGS) -o chatmmap chatmmap.c

cleanpipes:
	rm -f ecoute *_c2s *_s2c


# Pour éviter que lorsque je debug console.c ça supprime le ./ecoute du serveur
cleanpipes_debug:
	rm -f *_c2s *_s2c


# Nettoyage des pipes et des executables
clean:
	rm -f serveur console chatmmap ecoute *_c2s *_s2c a
