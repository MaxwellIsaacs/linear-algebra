public class Matrix3d{
    /*
    public Matrix3d () {
        super(3,3);
        boolean isNegative;
    }

    public Matrix3d (String elements) {
        super(3,3);
        // add error handling
        int current_col, current_row = 0;
        String current_string = "";

        for (int i = 0; i < elements.length(); i++) {
          if (elements.charAt(i).equals(' ')) {
             double current_val = (double) current_string;
             if (isNeg) current_val *= -1;
             this.setElement(current_row, current_col, current_val);
             current_col++;
             isNeg = false;
             current_string = "";
             continue;
          }
          else if (elements.charAt(i) == ';') {
              current_row++;
              double current_val = (double) current_string;
              if (isNeg) current_val *= -1;
              this.setElement(current_row, current_col, current_val);
              isNeg = false;
              current_string = "";
              continue;
          }
          else if (elements.charAt(i).equals('-')) isNeg = true;
          current_string = current_string + elements.charAt(i);
        }
    }

    @Overload
    public double determinant() {
        return super.getElement(0, 0) * (super.getElement(1, 1) * super.getElement(2, 2) - super.getElement(1, 2) * super.getElement(2, 1))
             - super.getElement(0, 1) * (super.getElement(1, 0) * super.getElement(2, 2) - super.getElement(1, 2) * super.getElement(2, 0))
             + super.getElement(0, 2) * (super.getElement(1, 0) * super.getElement(2, 1) - super.getElement(1, 1) * super.getElement(2, 0));
    }

 //   public double
 //   */
}
