package complex;

public class MyComplex {
    double real=0.0;
    double imag=0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real,double imag){
        this.real=real;
        this.imag=imag;
    }

    @Override
    public String toString() {
        return "(" +
                real +
                (imag<0.0?"":"+") + imag +
                "i)";
    }

    public boolean isReal(){
        if(this.real!=0) return true;
        return false;
    }

    public boolean isImaginary(){
        if(this.imag!=0) return true;
        return false;
    }


    public boolean equals(double real, double imag){
        if(this.real==real&this.imag==imag) return true;
        return false;
    }

    public boolean equals(MyComplex another){
        if(this.imag==another.imag&this.real==another.real) return true;
        return false;
    }

    public double magnitude(){
        return Math.sqrt(real*real+imag*imag);
    }

    public double argument(){
        return Math.atan2(real,imag);
    }

    public MyComplex add(MyComplex right){
        real+=right.real;
        imag+=right.imag;
        return this;
    }
    public MyComplex addNew(MyComplex right){
        MyComplex myComplex = new MyComplex(real+=right.real,imag+=right.imag);
        return myComplex;
    }
    public MyComplex subtract(MyComplex right){
        real-=right.real;
        imag-=right.imag;
        return this;
    }
    public MyComplex subtractNew(MyComplex right){
        MyComplex myComplex = new MyComplex(real-=right.real,imag-=right.imag);
        return myComplex;
    }
    public MyComplex multiply(MyComplex right){
        real=real*right.real-imag*right.imag;
        imag=real*right.imag+imag*right.real;
        return this;
    }
    public MyComplex divide(MyComplex right){
        double m = right.real*right.real+right.imag*right.imag;
        real=(real*right.real+imag*right.imag)/m;
        imag=(right.real*imag-real*right.imag)/m;
        return this;
    }

    public MyComplex conjugate(){
        MyComplex myComplex = new MyComplex(this.real,-this.imag);
        return myComplex;
    }
    public static void main(String[] args) {
        MyComplex myComplex1 = new MyComplex(1.5,0);
        MyComplex myComplex2 = new MyComplex(3.6,-2.2);
        MyComplex myComplex3 = new MyComplex(3.6,-2.2);
        System.out.println("myComplex1 "+myComplex1);
        System.out.println("myComplex2 "+myComplex2);
        System.out.println("myComplex3 "+myComplex3);
        System.out.println("myComplex1 has the real path? "+myComplex1.isReal());
        System.out.println("myComplex1 has the imaginary path? "+myComplex1.isImaginary());
        System.out.println("myComplex2 equals myComplex3? "+myComplex2.equals(myComplex3));
        System.out.println("Magnitude of myComplex2 "+myComplex2.magnitude());
        System.out.println("Argument of myComplex2 "+myComplex2.argument());
        System.out.println("myComplex1 + myComplex2");
        myComplex1.add(myComplex2);
        System.out.println("myComplex1 "+myComplex1);
        System.out.println("myComplex1 - myComplex2 = "+myComplex1.addNew(myComplex2));
        System.out.println("Number conjugate with myComplex2 "+myComplex2.conjugate());
    }
}
