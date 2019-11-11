package polynomial;

public class MyPolynomial {
    private double[] coeffs;

    @Override
    public String toString() {
        String str="";
        for(int i = coeffs.length-1;i>=0;i--){
            str+=coeffs[i]+(i>0?"*x^"+i+"+":"");
        }
        return str;
    }

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }


    public int getDegree(){
        return this.coeffs.length-1;
    }
    private MyPolynomial add(MyPolynomial right) {
        int max = Math.max(this.getDegree(),right.getDegree());
        MyPolynomial Polynomial = new MyPolynomial();
        Polynomial.coeffs=new double[max+1];
        for(int i = 0;i<max+1;i++){
            Polynomial.coeffs[i]=(i>this.getDegree()?0:this.coeffs[i])+(i>right.getDegree()?0:right.coeffs[i]);
        }
        return Polynomial;
    }

    private MyPolynomial multiply(MyPolynomial right) {
        int max = Math.max(this.getDegree(),right.getDegree());
        MyPolynomial Polynomial = new MyPolynomial();
        Polynomial.coeffs=new double[max+1];
        for(int i=0;i<=this.getDegree();i++){
            for(int j=0;j<right.getDegree();j++){
                Polynomial.coeffs[i+j]=(i>this.getDegree()?0:this.coeffs[i])+(j>right.getDegree()?0:right.coeffs[j]);
            }
        }
        return Polynomial;
    }

    public static void main(String[] args) {
        MyPolynomial myPolynomial = new MyPolynomial(2.3,4.5,5.6);
        System.out.println("myPolynomial"+myPolynomial);
        MyPolynomial right = new MyPolynomial(3.5,6.8);
        System.out.println("right "+right);
        System.out.println("Degree of myPolynomial "+myPolynomial.getDegree());
        System.out.println("Degree of right "+right.getDegree());
        System.out.println(myPolynomial.add(right));
        System.out.println(myPolynomial.multiply(right));
    }


}
