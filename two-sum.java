
    
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int N= numbers.length;
        int[] sorted = new int[N];
        System.arraycopy(numbers,0,sorted,0,N);
        Arrays.sort(sorted);
        int head=0;
        int tail=N-1;
        int val1=0;
        int val2=0;
        while(head<tail){
            int sum=sorted[head]+sorted[tail];
            if (sum==target){
                val1=sorted[head];
                val2=sorted[tail];
                break;
            }
            if (sum<target){
                head++;
            }else{
                tail--;
            }
        }
        //already found such pair, calculate their index
        for(int i=0;i<N;i++){
            if (numbers[i]==val1){
                val1=i;
                break;
            }
        }
        for(int i=0;i<N;i++){
            if (numbers[i]==val2 && i!=val1){
                val2=i;
                break;
            }
        }
        if (val1<val2){
            int[] temp=new int[2];
            temp[0]=val1+1;
            temp[1]=val2+1;
            return temp;
        }else{
            int[] temp=new int[2];
            temp[0]=val2+1;
            temp[1]=val1+1;
            return temp;
        }
    }
}