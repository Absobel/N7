CC       = gcc
LINK     = $(CC)

CFLAGS   = -O3 -fopenmp -Wunknown-pragmas
LDFLAGS  = $(CFLAGS) 
LIBS     = -lm
TARGET_DIR = ./target

OBJS =  $(TARGET_DIR)/treetrav_seq.o  $(TARGET_DIR)/treetrav_par.o  $(TARGET_DIR)/main.o

main: $(TARGET_DIR) $(OBJS)
	$(LINK) -o $(TARGET_DIR)/$@  $(LDFLAGS) $(OBJS) $(LIBS)




$(TARGET_DIR):
	mkdir -p $(TARGET_DIR)

clean:
	(rm -rf  $(TARGET_DIR))



$(TARGET_DIR)/%.o: %.c
	$(CC)  $(CFLAGS)  $(CINCLUDES) $(INCLUDES) $(CDEFS) $(PREC) -c $< -o $@
$(TARGET_DIR)/%.o: %.f90				       
	$(FC)  $(FCFLAGS) $(FINCLUDES) $(INCLUDES) $(FDEFS) $(DEFINE_PREPEND)$(PREC) -c $< -o $@




