package solution.leetcode.jieGu;

public class binarySearchProblems {
	
	public class SearchA2DMatrix {
	    //binary search, convert [mid] between matrix indices
	    public boolean searchMatrix(int[][] matrix, int target) {
	        int row = matrix.length;
	        int col = matrix[0].length;
	        int start = 0;
	        int end = row * col - 1;
	        
	        while (start <= end){
	            int mid = start + (end - start)/2; //always use end-start to avoid overflow
	            int i = mid / col;
	            int j = mid % col;
	            if (target == matrix[i][j]){
	                return true;
	            }else if(matrix[i][j] > target){
	                end = mid - 1;
	            }else{
	                start = mid + 1;
	            }
	        }
	        return false;
	    }
	}
	
	public class SearchInsersionPosition {
	    public int searchInsert(int[] A, int target) {
	        int start = 0;
	        int end = A.length - 1;
	        int mid = 0;
	        while(start <= end){
	            mid = start + (end-start)/2;
	            if (A[mid] == target){
	                return mid;
	            }
	            if (A[mid] > target){
	                end = mid - 1;
	            }else{
	                start = mid + 1;
	            }
	        }
	        return start;
	    }
	}
	
	public class SearchRange{
	    public int[] searchRange(int[] A, int target) {
	        int[] result = new int[2];
	        result[0] = searchHelper(A, target);
	        result[1] = searchHelper(A, target + 1);
	        
	        //{1,5,6,7,8,8}  search for 7
	        result[1] -= 1;
	        
	        if (result[0] > result[1]){
	        	result[0] = -1;
	        	result[1] = -1;
	        	return result;
	        }else{
	        	return result;
	        }
	    }
	    
	    private int searchHelper(int[] A, int target){
	    	int start = 0;
	    	int end = A.length - 1;
	    	while (start <= end){
	    		int mid = start + (end - start)/2;
	    		if (A[mid] == target){
	    			while (mid > 0 && A[mid-1] == A[mid]){
	    				mid--;
	    			}
	    			return mid;
	    		}else if (A[mid] > target){
	    			end = mid - 1;
	    		}else{
	    			start = mid + 1;
	    		}
	    	}
	    	return start;
	    }
	}
	
	public class searchInRotatedArray{
	    public int search(int[] A, int target) {
	        int start = 0;
	        int end = A.length - 1;
	        while (start <= end){
	        	int mid = start + (end - start)/2;
	        	if (A[mid] == target){
	        		return mid;
	        	}
	        	if (A[mid] >= A[start]){
	        		if (target >= A[start] && target <= A[mid]){
	        			end = mid - 1;
	        		}else{
	        			start = mid + 1;
	        		}
	        	}else{ //A[mid] < A[end]
	        		if (target >= A[mid] && target <= A[end]){
	        			start = mid + 1;
	        		}else{
	        			end = mid - 1;
	        		}
	        	}
	        }
	        //not found
	        return -1;
	    }
	}
	
	public class searchInRotatedArrayII{
	    public boolean search(int[] A, int target) {
	        int start = 0;
	        int end = A.length - 1;
	        while (start <= end){
	        	int mid = start + (end - start)/2;
	        	if (A[mid] == target){
	        		return true;
	        	}
	        	if (A[mid] > A[start]){
	        		if (target >= A[start] && target <= A[mid]){
	        			end = mid - 1;
	        		}else{
	        			start = mid + 1;
	        		}
	        	}else if (A[mid] < A[start]){ //A[mid] < A[end]
	        		if (target >= A[mid] && target <= A[end]){
	        			start = mid + 1;
	        		}else{
	        			end = mid - 1;
	        		}
	        	}else{
	        		start++;
	        	}
	        }
	        //not found
	        return false;
	    }
	}
}
