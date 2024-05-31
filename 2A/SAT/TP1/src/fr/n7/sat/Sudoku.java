package fr.n7.sat;

import java.io.*;
import java.util.*;
import com.microsoft.z3.*;

class OutOfBoundsException extends Exception {
    public OutOfBoundsException(String message) {
        super(message);
    }
}

class Sudoku {
    // Sudoku dimension
    private int                 nInit;
    private Context             context;
    private Solver              solver;

    // a cube representing the grid
    private BoolExpr            grid[][][];

    // the initial values on the grid represented as
    // boolean values
    private ArrayList<BoolExpr> initValues;

    public void XorArray(BoolExpr[] values) {
        solver.add(context.mkOr(values));
        for (int k1 = 0; k1 < values.length; k1++) {
            for (int k2 = k1 + 1; k2 < values.length; k2++) {
                solver.add(context.mkNot(context.mkAnd(values[k1], values[k2])));
            }
        }
    }

    /**
     * This method should add existence constraints: each cell has
     * at least one value.
     */
    private void addExistenceConstraints() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                BoolExpr[] values = new BoolExpr[this.grid.length];

                for (int k = 0; k < this.grid.length; k++) {
                    values[k] = this.grid[i][j][k];
                }

                XorArray(values);
            }
        }
    }

    /**
     * This method should add columns constraints: each value
     * appears exactly one time in each column.
     */
    private void addColumnConstraints() {
        
        for (int j = 0; j < this.grid.length; j++) {
            for (int k = 0; k < this.grid.length; k++) {
                BoolExpr[] values = new BoolExpr[this.grid.length];
                
                for (int i = 0; i < this.grid.length; i++) {
                    values[i] = this.grid[i][j][k];
                }

                XorArray(values);
            }
        }
    }

    /**
     * This method should add rows constraints: each value
     * appears exactly one time in each row.
     */
    private void addRowConstraints() {
        
        for (int i = 0; i < this.grid.length; i++) {
            for (int k = 0; k < this.grid.length; k++) {
                BoolExpr[] values = new BoolExpr[this.grid.length];
                
                for (int j = 0; j < this.grid.length; j++) {
                    values[j] = this.grid[i][j][k];
                }
    
                XorArray(values);
            }
        }
    }

    /**
     * This method should add subgrids constaints: each value
     * appears exactly one time in each subgrid.
     */
    private void addSubGridsConstraints() {
        int nb_subgrids = this.grid.length / 3;
        for (int i = 0; i < this.grid.length; i += this.nInit) {
            BoolExpr[] values = new BoolExpr[this.grid.length];
            int is = i / this.nInit;
            int js = i % this.nInit;    
        }
    }

    /**
     * Build a Sudoku problem.
     *
     * @param n the Sudoku dimension. The row and column length
     *          is therefore n * n.
     */
    Sudoku(int n) {
        this.initValues = new ArrayList<>();

        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");

        this.context = new Context(cfg);
        this.solver  = context.mkSolver();
        this.nInit   = n;

        int w = n * n;

        this.grid = new BoolExpr[w][w][w];

        // build Z3 decision variables for each cell/value
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < w; k++) {
                    this.grid[i][j][k] =
                        this.context.mkBoolConst("" + i + "_" + j + "_" + (k + 1));
                }
            }
        }

        long startTime = System.currentTimeMillis();

        this.addExistenceConstraints();
        this.addColumnConstraints();
        this.addRowConstraints();
        this.addSubGridsConstraints();

        long stopTime    = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("time to build constraints: " + elapsedTime + "ms");
    }

    /**
     * Prints Sudoku solution if it exists.
     *
     * If there are no values for a cell, "_" is printed.
     * If there are multiple values for a cell, the first value is
     * in inverse video.
     */
    void print() {
        Model m = this.solver.getModel();

        if (m == null) {
            return;
        }

        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                boolean multipleValues = false;
                int     value          = -1;

                for (int k = 0; k < this.grid.length; k++) {
                    if (m.getConstInterp(this.grid[i][j][k]) != null &&
                        m.getConstInterp(this.grid[i][j][k]).isTrue()) {
                        if (value != -1) {
                            multipleValues = true;
                        } else {
                            value = k + 1;
                        }
                    }
                }

                if (value != -1) {
                    if (multipleValues) {
                        System.out.print("\033[7m" + value + "\033[0m ");
                    } else {
                        System.out.print("" + value + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }

            System.out.println();
        }
    }

    /**
     * Solves the current Sudoku problem.
     */
    Status solve() {
        long startTime = System.currentTimeMillis();

        Status s = this.solver.check();

        long stopTime    = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;

        System.out.println("time to solve problem: " + elapsedTime + "ms");

        return s;
    }

    /**
     * Adds a value in the grid as initial constraint.
     *
     * @param i the row of the value
     * @param j the column of the value
     * @param v the value
     */
    void addValue(int i, int j, int v) throws OutOfBoundsException {
        if (i < 0 || j < 0 || v < 1 ||
            i >= this.grid.length || j >= this.grid.length || v > this.grid.length) {
            throw new OutOfBoundsException(String.format("problem when adding (%d, %d, %d)", i , j, v));
        }

        this.initValues.add(this.grid[i][j][v - 1]);
        this.solver.add(this.grid[i][j][v - 1]);
    }

    /**
     * Loads an initial situation from a file and returns the
     * corresponding Sudoku.
     *
     * @param filename a CSV file containing the initial situation
     * @return a Sudoku object
     */
    static Sudoku loadSudoku(String filename) throws OutOfBoundsException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));

        // first line contains dimension
        String line   = br.readLine();
        int    n      = Integer.parseInt(line);
        Sudoku sudoku = new Sudoku(n);

        // parse each line
        int i = 0;

        while ((line = br.readLine()) != null) {
            String values[] = line.split(",");

            for (int j = 0; j < values.length; j++) {
                if (! values[j].equals("")) {
                    sudoku.addValue(i, j, Integer.parseInt(values[j]));
                }
            }

            i++;
        }

        br.close();

        return sudoku;
    }

    /**
     * A simple program to load a Sudoku from a file using
     * command line arguments.
     *
     * If you use the Makefile, use the following command:
     *
     * make run-sudoku SUDOKU_FILE=file_to_use 
     */
    public static void main(String[] args) throws OutOfBoundsException, IOException, InterruptedException {
        String selectedFile = "files/le-monde.csv";

        Sudoku            sudoku = Sudoku.loadSudoku(selectedFile);
        InputStreamReader aux    = new InputStreamReader(System.in);
        BufferedReader    in     = new BufferedReader(aux);

        if (sudoku.solve() == Status.SATISFIABLE) {
            System.out.println("Solution found!\n");

            sudoku.print();
        } else {
            System.out.println("No solution found!\n");
        }
    }
}
