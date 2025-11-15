/**
 * A specialized 2x2 matrix implementation with optimized determinant calculation.
 */
public class Matrix2d extends Matrix {
    /**
     * Constructs a new 2x2 matrix with all elements initialized to 0.0.
     */
    public Matrix2d () {
        super(2, 2);
    }

    /**
     * Calculates the determinant of this 2x2 matrix using the formula ad - bc.
     *
     * @return the determinant value
     */
    public double determinant () {
        double ad = this.getElement (0, 0) * this.getElement (1,1);
        double bc = this.getElement (0, 1) * this.getElement (1,0);
        return ad - bc;
    }
}
