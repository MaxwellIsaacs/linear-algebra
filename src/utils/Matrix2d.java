public class Matrix2d extends Matrix {
    public Matrix2d () {
        super(2, 2);
    }

    //public Matrix2d ()

    @Overload
    public double determinant () {
        double ad = this.getElement (0, 0) * this.getElement (1,1);
        double bc = this.getElement (0, 1) * this.getElement (1,0);
        return ad - bc;
    }
}
