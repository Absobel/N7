# Ce makefile a été modifié pour que ça mache strictement sur ma machine

JAVAC = javac
JAVA = java
CP_OPTS = -cp $$CLASSPATH:lib/com.microsoft.z3.jar
JAVAC_OPTS = $(CP_OPTS) -d classes
JAVA_OPTS = $(CP_OPTS):./classes

SRC_DIR = src/fr/n7/sat

_SRC_FILES = SimpleBooleanProblem.java Sudoku.java
SRC_FILES = $(patsubst %,$(SRC_DIR)/%,$(_SRC_FILES))

.PHONY: compile run-example run-sudoku

compile: $(SRC_FILES) | classes
	$(JAVAC) $(JAVAC_OPTS) $^

run-example: compile
	$(JAVA) $(JAVA_OPTS) fr.n7.sat.SimpleBooleanProblem

run-sudoku: compile
	$(JAVA) $(JAVA_OPTS) fr.n7.sat.Sudoku $(SUDOKU_FILE)

classes:
	mkdir -p $@

clean:
	- rm -rf classes *.log **/*~
