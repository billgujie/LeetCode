package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class greyCode {
	public List<Integer> grayCode(int n) {
		
//		0:		0
//		1:		0, 1
//		2:		00, 01, 11, 10
//		3:		000, 001, 011, 010, 110, 111, 101, 100
		
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(0);
        if (n==0){
        	return ret;
        }
        //couting loop
        for (int i=0;i<n;i++){
        	int one = 1<<i;
        	//picking from the last element 
        	for (int j=ret.size()-1;j>=0;j--){
        		ret.add(ret.get(j)^one);
        	}
        }
        
        return ret;
    }
}
