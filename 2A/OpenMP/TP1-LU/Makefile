CC       = gcc
FC       = gfortran
LINK     = $(FC)

FCFLAGS  = -O3 -fopenmp
CFLAGS   = -O3 -fopenmp -Wunknown-pragmas
LDFLAGS  = $(FCFLAGS) 
LBLAS    = /usr/lib/libacml.a -lm

TARGET_DIR = ./target

OBJS = $(TARGET_DIR)/aux.o $(TARGET_DIR)/auxf.o $(TARGET_DIR)/lu_seq.o $(TARGET_DIR)/lu_par_loop.o $(TARGET_DIR)/lu_par_tasks.o $(TARGET_DIR)/kernels.o $(TARGET_DIR)/main.o $(TARGET_DIR)/trace.o

main: clean $(TARGET_DIR) $(OBJS)
	export OMP_NUM_THREADS=4
	export OMP_MAX_TASK_PRIORITY=999
	$(LINK) $(LDFLAGS) -o $(TARGET_DIR)/$@ $(OBJS) $(LBLAS)

main_dbg: 
	($(MAKE) clean main CDEFS=-DDBG)

$(TARGET_DIR):
	mkdir -p $(TARGET_DIR)

clean:
	(rm -rf $(TARGET_DIR))

$(TARGET_DIR)/%.o: %.c
	$(CC) $(CFLAGS) $(CINCLUDES) $(INCLUDES) $(CDEFS) $(PREC) -c $< -o $@

$(TARGET_DIR)/%.o: %.f90				       
	$(FC) $(FCFLAGS) $(FINCLUDES) $(INCLUDES) $(FDEFS) $(DEFINE_PREPEND)$(PREC) -c $< -o $@

