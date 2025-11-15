/**
 * A specialized 3x3 matrix implementation with optimized determinant calculation
 * and string-based initialization.
 */
public class Matrix3d extends Matrix {
    /**
     * Constructs a new 3x3 matrix with all elements initialized to 0.0.
     */
    public Matrix3d () {
        super(3,3);
    }

    /**
     * Constructs a 3x3 matrix from a string representation.
     * Elements should be space-separated, rows separated by semicolons.
     * Example: "1 2 3; 4 5 6; 7 8 9"
     *
     * @param elements the string representation of matrix elements
     */
    public Matrix3d (String elements) {
        super(3,3);
        // add error handling
        int currentCol = 0;
        int currentRow = 0;
        String currentString = "";
        boolean isNeg = false;

        for (int i = 0; i < elements.length(); i++) {
          if (elements.charAt(i) == ' ') {
             double currentVal = Double.parseDouble(currentString);
             if (isNeg) currentVal *= -1;
             this.setElement(currentRow, currentCol, currentVal);
             currentCol++;
             isNeg = false;
             currentString = "";
             continue;
          }
          else if (elements.charAt(i) == ';') {
              currentRow++;
              currentCol = 0;
              double currentVal = Double.parseDouble(currentString);
              if (isNeg) currentVal *= -1;
              this.setElement(currentRow, currentCol, currentVal);
              isNeg = false;
              currentString = "";
              continue;
          }
          else if (elements.charAt(i) == '-') {
              isNeg = true;
          }
          else {
              currentString = currentString + elements.charAt(i);
          }
        }
    }

    public double determinant() {
        return super.getElement(0, 0) * (super.getElement(1, 1) * super.getElement(2, 2) - super.getElement(1, 2) * super.getElement(2, 1))
             - super.getElement(0, 1) * (super.getElement(1, 0) * super.getElement(2, 2) - super.getElement(1, 2) * super.getElement(2, 0))
             + super.getElement(0, 2) * (super.getElement(1, 0) * super.getElement(2, 1) - super.getElement(1, 1) * super.getElement(2, 0));
    }
}
