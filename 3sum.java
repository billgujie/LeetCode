public class Solution {
	//use a general version of twosum to solve 3sum problem
	//pick any number from list, and put the rest into a 2sum function
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//int[] num = { -1, 0, 1, 2, -1, -4, -3 };
		int N = num.length;
		if(N<3){
		    return result;
		}
		int[] sorted = new int[N];
		System.arraycopy(num, 0, sorted, 0, N);
		Arrays.sort(sorted);
		int previousTarget = Integer.MIN_VALUE;
		for (int iter = 0; iter < N - 2; iter++) {
			if (sorted[iter] == previousTarget) {
				continue;
			}
			int target = sorted[iter];// take negative later
			previousTarget = target;
			int[] copy = new int[N - iter-1];
			System.arraycopy(sorted, iter+1, copy, 0, N - iter-1);// create array
																// for 2sum
			ArrayList<ArrayList<Integer>> temp = twosum(copy, -target, target);
			result.addAll(temp);
		}
		return result;
	}

	private static ArrayList<ArrayList<Integer>> twosum(int[] sorted, int target, int lead) {
		int N = sorted.length;
		//int[] sorted = new int[N];
		//System.arraycopy(numbers, 0, sorted, 0, N);
		//Arrays.sort(sorted);
		int head = 0;
		int tail = N - 1;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int val1 = 0;
		int val2 = 0;
		while (head < tail) {
            if(head>0 && sorted[head-1]==sorted[head]){
				head++;
				continue;
			}
			if(tail<N-1 && sorted[tail]==sorted[tail+1]){
				tail--;
				continue;	
			}
			int sum = sorted[head] + sorted[tail];
			if (sum == target) {
				val1 = sorted[head];
				val2 = sorted[tail];

				Integer[] tmparr = new Integer[] { lead, val1, val2 };
				Arrays.sort(tmparr);
				ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(tmparr));
				result.add(temp);

				head++;
				tail--;
			}
			else if (sum < target) {
				head++;
			} else {
				tail--;
			}
		}
		return result;
	}
}