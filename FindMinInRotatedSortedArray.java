package solution.leetcode.jieGu;

public class FindMinInRotatedSortedArray {
	public int findMin(int[] num) {

	    int start = 0;
	    int end = num.length - 1;

	    if (num[start]<num[end]) return num[0];

	    while(start < end - 1){
	        int mid = start+ (end - start)/2;
	        if (num[start]<num[mid]) {
	        	start = mid;
	        } else {
	        	end = mid;
	        }
	    }
	    return num[end];
	}
}
