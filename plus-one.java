public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length-1;
        for (int i=length;i>=0;i--){
            if (digits[i]!=9){
                digits[i]++;
                return digits;
            }else{
                //equals 9, then next digits will increments what ever
                digits[i]=0;
            }
        }
        //all digits are 9;
        int[] retval = new int[digits.length+1];
        System.arraycopy(digits,0,retval,1,length);
        retval[0]=1;
        return retval;
    }
}