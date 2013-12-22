public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int count=m+n-1;
        
        while(i>=0&&j>=0){
            if(A[i]>B[j]){
                A[count]=A[i];
                count--;
                i--;
            }else{
                A[count]=B[j];
                count--;
                j--;
            }
        }
        while(j>=0){
            A[count]=B[j];
            count--;
            j--;
        }
    }
}