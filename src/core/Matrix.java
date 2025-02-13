import java.util.function.Function;
import java.util.Random;

public class Matrix {
  private double elements[][];
  private int rows;
  private int columns;


  public Matrix (int rows, int columns) {
    this.elements = new double [rows][columns];
    this.rows = rows;
    this.columns = columns; 
  }

  public int getRows () {
    return rows;
  }

  public int getCols () {
    return columns;
  }

  // returns individual element
  public double getElement (int x, int y) {
    if (x > rows) {
      Error.outOfBound("Get element", 'x');
      return -1;
    }
    if (y > columns) {
      Error.outOfBound("Get element", 'y');
      return -1;
    }
    return elements[x][y];
   } 

  // sets individual element
  public void setElement (int x, int y, double value) {
    elements[x][y] = value;
  }
  
  // sets entire elements list
  public void setElements (double elements[][]) {
    this.elements = elements;
  }

  public double[][] getElements () {
    return elements;
  }

  // returns shape as a custom pair class
  public Pair <Integer, Integer> getShape () {
    return new Pair<>(rows, columns);
  }

  public static boolean isSquare (Matrix x) {
    return x.getCols() == x.getRows();
  }



  // returns a new sum matrix
  public Matrix add (Matrix b) {
    Pair<Integer, Integer> otherShape = b.getShape();
    if (rows != otherShape.getFirst () || columns != otherShape.getSecond ()) {
      Error.incorrectMatrixShape ("Matrix addition");
    } 

    Matrix temp = new Matrix (rows, columns);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        double tempVal= elements[i][j] + b.getElement (i, j);
        temp.setElement (i, j, tempVal);
      }
    }
    return temp;
  }

  // returns a new sum matrix
  public Matrix subtract (Matrix b) {
    Pair<Integer, Integer> otherShape = b.getShape();
    if (rows != otherShape.getFirst () || columns != otherShape.getSecond ()) {
      Error.incorrectMatrixShape ("Matrix addition");
    }

    Matrix temp = new Matrix (rows, columns);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        double tempVal= elements[i][j] - b.getElement (i, j);
        temp.setElement (i, j, tempVal);
      }
    }
    return temp;
  }



  // returns a new sum matrix between a matrix and a scalar
  public Matrix addScalar (double s) {
    Matrix temp = new Matrix (this.rows, this.columns);
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++) {
        temp.setElement (i, j, this.elements[i][j] + s);
      }
    }
    return temp;
  }

  // determinant stuff
  private static double determinant2d (Matrix x) {
    double ad = x.getElement (0, 0) * x.getElement (1,1);
    double bc = x.getElement (0, 1) * x.getElement (1,0);
    return ad - bc;
  }


  // returns determinant
  public static double det (Matrix x) {
    if (!Matrix.isSquare(x)){
      Error.incorrectMatrixShape ("square determinant");
      return 69;
    }

    if (x.getCols() == 2) {
      return determinant2d (x);
    }

    int n = x.getCols();
    int stepCount = n-2;
    double det = 0;
    Vector firstRow = x.grabRowVector (0);
    for (int i = 0; i < firstRow.getLength(); i++) {
      double pivot = firstRow.getElement (i);
      Matrix temp = new Matrix (n-1, n-1);
      for (int j = 1; j < x.getRows(); j++) {
        for (int k = 0; k < x.getCols(); k++) {
          if (k == i) continue;
          if (k > i) {
            temp.setElement (j-1, k-1, x.getElement (j,k));
          } else {
            temp.setElement (j-1, k, x.getElement (j, k));
          }
        }
      }
      det += Math.pow(-1, i) * pivot * Matrix.det (temp);
    }
    return det;
  }



// returns a new product matrix between a matrix and a scalar
  public Matrix scalarProduct (double s) {
    Matrix temp = new Matrix (this.rows, this.columns);
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++) {
        temp.setElement (i, j, this.elements[i][j] * s);
      }
    }
    return temp;
  }

  // returns a new product matrix
  public Matrix multiply (Matrix b) { 
    if (b.getRows () != columns) {
      Error.incorrectMatrixShape ("Matrix multiply");
    }
    Pair<Integer, Integer> newShape = new Pair<>(getRows(), b.getCols());
    Matrix newMatrix = new Matrix (newShape.getFirst(), newShape.getSecond()); 
    double newElements[][] = new double[newShape.getFirst()][newShape.getSecond()];

    for (int i = 0; i < newShape.getFirst(); i++) {
      for (int j = 0; j < newShape.getSecond(); j++) {
        double sum = 0;
        for (int k = 0; k < columns; k++) {
          sum += elements[i][k] * b.getElement (k, j);
        }          
        newElements[i][j] = sum;
      } 
    }
    newMatrix.setElements (newElements);
    return newMatrix;
  }

  //returns tranpose matrix
  public Matrix transpose () {
    Matrix m = new Matrix(columns, rows);
    double temp[][] = new double [columns][rows];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++){
        temp[j][i] = elements[i][j];
      }
    }
    m.setElements(temp);
    return m;
  }



  //argmax
  public double argmax () {
    double max = this.getElement (0, 0);
    
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        max = Math.max (this.getElement (i, j), max);
      }
    }
    return max;
  }

  // apply function to each element of the matrix
  public Matrix applyFunction (Function <Double, Double> function) {
    Matrix temp = new Matrix (rows, columns);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        double tempVal = function.apply (elements[i][j]);
        temp.setElement (i, j, tempVal);
      }
    }
    return temp;
  }

  // gaussian elimination utility
  public Vector grabRowVector (int row) {
    Vector temp = new Vector (elements[row].length); 
    for (int i = 0; i < elements[row].length; i++) {
      temp.setElement (i, elements[row][i]);
    }
    return temp;
  }

  public void replaceRowWithVector (int row, Vector v) {
    if (elements[row].length != v.getLength()) {
      Error.incorrectVectorShape ("replaceRowWithVector");
    }
    for (int i = 0; i < v.getLength(); i++) {
      this.setElement (row, i, v.getElement (i));
    }
  }

  public void swapRows (int aIndex, int bIndex) {
    Vector a = this.grabRowVector (aIndex);
    Vector b = this.grabRowVector (bIndex);
    Vector temp = a;
    this.replaceRowWithVector (aIndex, b);
    this.replaceRowWithVector (bIndex, temp);
  }

  private double reciprical (double n) {
    return 1 / n;
  }

  public void toRowEchelonForm () {
    int pivot = 0;
    while (pivot < this.rows) {
        // turn the pivot into 1
        Vector pivotVector = grabRowVector (pivot);
        double r = reciprical(pivotVector.getElement(pivot));
        pivotVector = pivotVector.scalarProduct (r);
        this.replaceRowWithVector (pivot, pivotVector);
      
      for (int i = pivot + 1; i < this.rows; i++) {
        double current = this.getElement (i, pivot);
        if (current != 0) {
          Vector tempSub = grabRowVector (pivot);
          tempSub = tempSub.scalarProduct (current);
          Vector currentRow = grabRowVector (i);
          currentRow.subtract (tempSub);
          this.replaceRowWithVector (i, currentRow);
        }
      }
     pivot++;
    }     
  }

  public void toReducedEchelonForm () {
    this.toRowEchelonForm ();
    for (int pivot = this.rows - 1; pivot >= 0; pivot--) {
      Vector current = grabRowVector (pivot);
      for (int i = pivot - 1; i >= 0; i--) {
        Vector toNorm = grabRowVector (i);
        double scale = toNorm.getElement (pivot);
        if (scale != 0) {
          toNorm.subtract(current.scalarProduct(scale));
          this.replaceRowWithVector (i, toNorm);
        }
      }
    }
  }      

  // returns randomized elements array (for neural networks)
  public static Matrix randomMatrix (int rows, int columns, int min, int max) {

    Matrix randMatrix = new Matrix (rows, columns);
    Random random = new Random ();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        randMatrix.setElement (i, j, min + (max- min) * random.nextDouble ());
      }
    }
    return randMatrix;
  }


  public void print () {
    System.out.println("Matrix: ");
    int cols = elements[0].length;
    int rows = elements.length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(elements[i][j] + " ");
      }
      System.out.println();
    }
  }


  public void printShape () {
    System.out.print("Matrix Shape: " + rows + ", " + columns);
  }
}

