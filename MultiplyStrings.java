package solution.leetcode.jieGu;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if (num1 == null || num2 == null) {
            return null;
        }
    	
    	int len1 = num1.length();
    	int len2 = num2.length();
    	int i,j;
        int[] res = new int[len1+len2];
        int prod, carry;
        for (i = len1 -1; i>=0 ;i--){
        	carry = 0;
        	for(j = len2 -1; j >=0; j--){
        		prod = carry+ res[i+j+1] + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
        		res[i+j+1] = prod % 10;
        		carry = prod / 10;
        	}
        	res[i+j+1] = carry;
        }
        
        StringBuilder sb = new StringBuilder();
        i=0;
        while (i < len1+len2 -1 && res[i]==0){
        	i++;
        }
        
        while (i<len1+len2){
        	sb.append(res[i++]);
        }
        
        return sb.toString();
    }
}
