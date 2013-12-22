public class Solution {
    public double pow(double x, int n) {
        long n1=(long) n;
        return power(x, n1);
    }
    
    private double power(double x, long n){
        if (x==1) return x;
        else if (n<0) return power(1/x,-n);
        else if (n==0) return 1;
        else if (n==1) return x;
        else if (n%2==0) return power(x*x,n/2);
        else return x*power(x*x,(n-1)/2);
    }
}