CFLAGS = -g -Wall

all: serveur console cleanpipes

serveur: serveur.c
	gcc $(CFLAGS) -o serveur serveur.c

console: console.c
	gcc $(CFLAGS) -o console console.c

cleanpipes:
	rm -f ecoute *_c2s *_s2c

clean:
	rm -f serveur console ecoute *_c2s *_s2c
