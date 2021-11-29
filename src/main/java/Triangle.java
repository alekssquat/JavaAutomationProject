

public class Triangle {
    float a;
    float b;
    float c;



    public Triangle() {
      super();
    }

    public Triangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcArea(float a, float b, float c) throws NotPositiveNumberException, NotTriangleException {
        double s=0.0;
        if(a<0||b<0||c<0){
            throw new NotPositiveNumberException();
        }else if((a+b)<c||(b+c)<a||(c+a)<b){
            throw new NotTriangleException();
        }else{
            double p=(a+b+c)/2;
            s=Math.sqrt(p*(p-a)*(p-b)*(p-c));

        }
        return s;
    }

    public double calcArea() throws NotPositiveNumberException, NotTriangleException {
        a=this.a;
        b=this.b;
        c=this.c;
        double s=0.0;
        if(a<0||b<0||c<0){
            throw new NotPositiveNumberException();
        }else if((a+b)<c||(b+c)<a||(c+a)<b){
            throw new NotTriangleException();
        }else{
            double p=(a+b+c)/2;
            s=Math.sqrt(p*(p-a)*(p-b)*(p-c));

        }
        return s;
    }


}

class NotPositiveNumberException extends Exception{
    public NotPositiveNumberException() {
        //System.out.println("Values less than 0");
    }
}

class NotTriangleException extends Exception{
    public NotTriangleException() {
        //System.out.println("Sum of two values less then third value");
    }
}
