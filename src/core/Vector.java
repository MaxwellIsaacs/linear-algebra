import java.util.Random;
import java.util.function.Function;


public class Vector {

  private double elements[];
  private int length;

  public Vector (int size) {
    this.elements = new double[size];
    this.length = size;
    Pair<Integer, Integer> shape;
 }

  public double getElement (int index) {
    return elements[index];
  }

  public int getLength () {
    return this.length;
  }

  public void setElement (int index, double weight) {
    elements[index] = weight;
  }

  public void setElements (double values[]) {
    if (length != values.length) {
      Error.cannotSetElementsVector ("Set Elements");
    }
    this.elements = values;
  }

  public Vector add (Vector b) {
    if (b.getLength() != this.length) {
      Error.incorrectVectorShape("Vector add");
      return null;
    }

    Vector temp = new Vector(this.length);
    for (int i = 0; i < this.length; i++) {
      double tempVal = b.getElement (i) + this.elements[i];
      temp.setElement (i, tempVal);
    }
    return temp;
  }

  // returns a new product vector
  public Vector scalarProduct (double scalar) {
    Vector temp = new Vector (length);
    for (int i = 0; i < length; i++) {
      double tempVal = scalar * elements[i];
      temp.setElement (i, tempVal);
    }
    return temp;
  }


  public double getL2Norm () {
    double norm = 0;
    double radicand = 0;

    for (int i = 0; i < this.length; i++) {
      radicand += Math.pow (elements[i], 2);
    }

    norm = Math.sqrt (radicand);
    return norm; 
  }

  public double getL1Norm () {
    double norm = 0;
    for (int i = 0; i < this.length; i++)  {
      norm += Math.abs (this.elements[i]);
    }
    return norm;
  }


  public void print () {
    System.out.println("Vector: ");
    for (int i = 0; i < elements.length; i++) {
      System.out.print(elements[i] + " ");
    }
  }

  public Vector applyFunction (Function <Double, Double> function) {
    Vector temp = new Vector (elements.length);
    
    for (int i = 0; i < elements.length; i++) {
      double tempVal = function.apply (elements[i]);
      temp.setElement (i, tempVal);
    }

    return temp;
  }

  // returns new vector with random elements
  public static Vector randomVector (int size, int min, int max) {
    Vector temp = new Vector (size);
    Random random = new Random ();

    for (int i = 0; i < size; i++) {
      temp.setElement (i, min + (max - min) * random.nextDouble ());
    }
    return temp;
  }


  //public double angleBetweenVectors (Vector b) {} 

  // returns a new vector of the linear combination between current vector and vector b 
  public static Vector linearCombo (double aCoeff, Vector a, double bCoeff, Vector b) {
    Vector temp1 = a.scalarProduct (aCoeff);
    Vector temp2 = b.scalarProduct (bCoeff);
    
    temp1 = temp1.add (temp2);
    return temp1;
  }

  public void pushBack (int index, double weight) {
    elements[index] = weight;
  }

  public Vector subtract (Vector b) {
    if (b.getLength() != this.length) {
      Error.incorrectVectorShape("Vector add");
      return null;
    }

    Vector temp = new Vector(this.length);
    for (int i = 0; i < this.length; i++) {
      double tempVal = this.getElement (i) - b.elements[i];
      temp.setElement (i, tempVal);
    }
    return temp;
  }



}
