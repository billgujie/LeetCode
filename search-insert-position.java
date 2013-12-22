public class Solution {
    public int searchInsert(int[] A, int target) {
        int st=0;
        int ed=A.length-1;
        int mid=0;
        while(st<=ed){
            mid=(st+ed)/2;
            if (A[mid]==target){
                return mid;
            }
            if (A[mid]>target){
                ed=mid-1;
            }else{
                st=mid+1;
            }
        }
        return st;
    }
}