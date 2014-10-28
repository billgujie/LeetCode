package solution.leetcode.jieGu;

public class JumpGames {
    public boolean canJump(int[] A) {
        if(A==null || A.length==0)
            return false;
        int maxreach = 0;
        for(int i = 0; i<=maxreach && i < A.length; i++)
        {
            maxreach = Math.max(A[i]+i,maxreach);
        }
        if(maxreach<A.length-1)
            return false;
        return true;
    }
}
