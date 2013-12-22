public class Solution {
    public int reverse(int x) {
        long result=0;
        int minus=1;
        if (x<0){//get rid of minus sign, deal later
            x=x*-1;
            minus=-1;
        }
        for (;x>9;x=x/10){
            result=result*10+x%10;
            }
            result=minus*(result*10+x);
            if (result>Integer.MAX_VALUE){
                System.exit(-1);
             }
             return (int)result;
             
    }
}