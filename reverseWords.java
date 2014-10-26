package solution.leetcode.jieGu;

import java.util.Stack;

public class reverseWords {

	//use first stack to store the reversed string
	//then use a second stack
    public String solve(String s) {
        StringBuilder sb = new StringBuilder();
        String ns= s.trim();
        Stack<Character> reverse = new Stack<Character>();
        boolean hadspace=false;
        for (int i=0; i< ns.length();i++){
        	char c = ns.charAt(i);
        	if (c==' '){
        		if (!hadspace){
        			reverse.push(c);
        			hadspace=true;
        		}
        	}else{
        		hadspace=false;
        		reverse.push(c);
        	}
        }
        Stack<Character> t = new Stack<Character>();
        while (!reverse.empty()){
        	char temp =reverse.pop();
            if(temp==' '){
            	//get the stack content out append to StringBuilder
                while (!t.empty()){
                    char c =t.pop();
                    sb.append(c);
                }
                sb.append(' ');
            }else{
            	//push to stack
                t.push(temp);
            }
        }
        while (!t.empty()){
            char c =t.pop();
            sb.append(c);
        }
        return sb.toString();
    }
}
