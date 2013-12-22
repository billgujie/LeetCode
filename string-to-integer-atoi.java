public class Solution {
    public int atoi(String str) {
        
        long result=0;
        int overflow=0;
        int i=0;
        int sign=1;
        
        if (str.length()==0){
            return 0;
        }
        
        while(str.charAt(i)==' '||str.charAt(i)=='0'){
            i++;
        }
        if (str.charAt(i)=='+'){
            i++;
        }
        if (str.charAt(i)=='-'){
            sign=-1;
            i++;
        }
        if (str.charAt(i)<'0'||str.charAt(i)>'9'){
            return 0;
        }
        for (;i<str.length();i++){
            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                result=digit(str.charAt(i))+result*10;
                if (sign==1 && (result>Integer.MAX_VALUE)){
                    overflow=1;
                    break;
                }
                if (sign!=1 && (-result<Integer.MIN_VALUE)){
                    overflow=1;
                    break;
                }
            }else{
                break;
            }
        }
        if (overflow==1){
            return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            return sign*(int)result;
        }
    }
    
    private int digit(char c){
        return (c-'0');
    }
}