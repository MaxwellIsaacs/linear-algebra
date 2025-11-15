 /**
 * Utility class for error logging and matrix/vector debugging operations.
 * Provides centralized error handling for the linear algebra library.
 */
public class Error {
  /**
   * Logs an error message with the specified severity level.
   *
   * @param status the error severity level (1=INFO, 2=WARNING, 3=CRITICAL, 4=blank line)
   * @param message the error message
   * @param function the name of the function where the error occurred
   */
  public static void logError (int status, String message, String function) {
    switch (status) {
      case 1:
        System.out.println("INFO - " + function + " "  + message);
        break;
      case 2:
        System.out.println("WARNING - "  + function + " " + message);
        break;
      case 3:
        System.out.println("CRITICAL - " + function + " | " + message);
        break;
      case 4:
        System.out.println("");
        break;
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
      for (int j = 0; j < m.getCols(); j++) {
        System.out.print(m.getElement(i,j) + " ");
      }
      System.out.println();
    }
  }
  public static void outOfBound (String function, char d) {
    String message = d == 'x' ? "Your row input was out of bounds" : "Your columns input was out of bounds";
    logError (3, message, function);
  }
}
