public class Solution {
    public boolean isValid(String s) {
        Stack<Character> sk=new Stack<Character>();
		int N=s.length();
		if (N%2!=0){
			return false;
		}
		for(int i=0; i<N;i++){
			char cur=s.charAt(i);
			if(cur=='('||cur=='{'||cur=='['){
				sk.push(cur);
				continue;
			}
			if(cur==')'||cur=='}'||cur==']'){
				if (sk.empty()){ 
					return false;
				}
				char out=sk.pop();
				if ((cur=='}' && out=='{')||(cur==']' && out=='[')||(cur==')' && out=='(')){
					continue;
				}else{
					return false;
				}
			}
		}
		if (!sk.empty()){
			return false;
		}
		return true;
    }
}