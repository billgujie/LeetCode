package solution.leetcode.jieGu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n<=0){
        	return res;
        }
        dfs(res,"",n,n);
        return res;
    }
    /**
     * 1. �������������û�����꣬��ô�����ܼ�������������
     * 2. ����Ѿ����õ��������������Ѿ����õ�������������ô���ǿ��Է��������� ��������õ������������ڷ��õ���������������ֲ��Ϸ���ϣ�
     */
    private void dfs(List<String> res, String tmp, int left, int right){
    	
    	if (left == 0 && right == 0){
    		res.add(tmp);
    		return;
    	}
    	if (left > 0){
    		tmp = tmp+"(";
    		dfs(res,tmp,left-1,right);
    		tmp = tmp.substring(0, tmp.length()-1);//back track
    	}
    	if (right > left){
    		tmp = tmp + ")";
    		dfs(res,tmp,left,right-1);
    		tmp = tmp.substring(0, tmp.length()-1);//back track
    	}
    }
}
