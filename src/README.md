# **java linear algebra**

## **Overview**

This is a lightweight yet capable linear algebra library written in Java. Designed for straightforward matrix and vector operations, it provides essential functionality for numerical computing, AI applications, and mathematical computations. While it may not be optimized for large-scale scientific computing, it serves as a solid foundation for working with fundamental linear algebra concepts in Java.

## **Features**

✅ Vector operations (addition, subtraction, scalar multiplication, norms)  
✅ Matrix operations (addition, subtraction, multiplication, transpose, determinant)  
✅ Gaussian elimination (Row Echelon and Reduced Row Echelon Form)  
✅ Functional programming support for element-wise transformations  
✅ Randomized matrix and vector generation  
✅ Error handling for shape mismatches and other basic errors 
✅ Specialized 2D and 3D matrices, with general `MatrixXd` support  

## **Installation**

Clone the repository using SSH:

```sh
git clone git@github.com:MaxwellIsaacs/linear-algebra.git
```

Then, include the `.java` files in your Java project or compile them into a `.jar` for reuse.

## **Usage Example**

### **Creating and Using Vectors**
```java
Vector v1 = new Vector(3);
v1.setElements(new double[]{1.0, 2.0, 3.0});

Vector v2 = Vector.randomVector(3, -1, 1);

Vector sum = v1.add(v2);
System.out.println("Vector Sum: ");
sum.print();
```

### **Matrix Operations**
```java
Matrix2d m1 = new Matrix();
m1.setElements(new double[][]{{1, 2}, {3, 4}});

Matrix2d m2 = new Matrix();
m2.setElements(new double[][]{{5, 6}, {7, 8}});

Matrix2d product = m1.multiply(m2);
System.out.println("Matrix Product:");
product.print();
```

## **License**

This project is licensed under the **MIT License**, meaning you are free to use, modify, and distribute it with attribution.

## **Contributions**

This project is a work in progress, and contributions are welcome! Feel free to fork, improve, and submit pull requests.

