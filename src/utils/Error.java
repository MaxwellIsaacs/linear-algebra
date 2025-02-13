 
public class Error {
  public static void logError (int status, String message, String function) {
    switch (status) {
      case 1:
        System.out.println("INFO - " + function + " "  + message);
      case 2:
        System.out.println("WARNING - "  + function + " " + message);
      case 3:
        System.out.println("CRITICAL - " + function + " | " + message);
      case 4:
        System.out.println("");
    }
  }

  public static void incorrectMatrixShape (String function) {
    logError (2, "Matrices do not have the correct shape", function);
  }

  public static void incorrectVectorShape (String function) {
    logError (2, "Vectors do not have the correct shape", function);
  }

  public static void cannotSetElementsMatrix (String function) {
    logError (3, "The list you gave has different dimensions than the matrix", function);
  }

  public static void cannotSetElementsVector (String function) {
    logError (3, "The list you gave has different dimensions than the vector", function);
  }

  public static void print (Matrix m) {
    System.out.println("Matrix: ");
    for (int i = 0; i < m.getRows(); i++) {
      for (int j = 0; i < m.getCols(); j++) {
        System.out.print(m.getElement(i,j) + " ");
      }
      System.out.println();
    }
  }
  public static void outOfBound (String function, char d) {
    String message = d == 'x' ? "Your row input was out of bounds" : "Your columns input was out of bounds";
    logError (3, message, function);
  }
  //public static void  
}
