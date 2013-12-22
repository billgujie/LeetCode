public class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[4];
        arr[1]=1;
        arr[2]=2;
        if (n==1) return 1;
        if (n==2) return 2;
        for (int i=2;i<n;i++){
            
            int temp =arr[1]+arr[2];
            arr[1]=arr[2];
            arr[2]=temp;
        }
        return arr[2];
    }
}