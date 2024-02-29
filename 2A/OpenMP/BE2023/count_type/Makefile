CC       = gcc
LINK     = $(CC)

CFLAGS   = -O3 -fopenmp 
LDFLAGS  = $(CFLAGS) 

OBJS = main.o aux.o

main: $(OBJS)
	$(LINK) -o $@  $(LDFLAGS) $(OBJS) -lm

main.o: aux.o




clean:
	(rm -f *.o main)



%.o: %.c
	$(CC)  $(CFLAGS)  $(CINCLUDES) $(INCLUDES) $(CDEFS) $(PREC) -c $<
%.o: %.f90				       
	$(FC)  $(FCFLAGS) $(FINCLUDES) $(INCLUDES) $(FDEFS) $(DEFINE_PREPEND)$(PREC) -c $<




