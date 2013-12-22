public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int idx1=0;
        int idx2=0;
        int[] result=new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        //put array into hashmap
        for (int i=0; i<numbers.length; i++){
            hm.put(numbers[i],i);
        }
        for (int i=0; i<numbers.length;i++){
            int t=target-numbers[i];
            if (hm.containsKey(t)){
                idx2=hm.get(t);
                idx1=i;
                if (idx1!=idx2) break;
            }
        }
        if (idx1<idx2){
            result[0]=idx1+1;
            result[1]=idx2+1;
            return result;
        }
        else{
            result[1]=idx1+1;
            result[0]=idx2+1;
            return result;
        }
        
    }
}