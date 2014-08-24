/**
	 * 
	 * 1
	 * 23
	 * 124
	 * 2345
	 * 12543
	 * 
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		
		if (triangle==null || triangle.size()==0){
			return 0;
		}
		int depth = triangle.size();
		
		//get the bottom row first, initial condition its bottom row itself
		ArrayList<Integer> level = new ArrayList<Integer>(triangle.get(depth-1));
		
		//bottom up
		for (int i=depth-2; i>=0;i--){
			for (int j=0;j<=i;j++){
				int newval = Math.min(level.get(j), level.get(j+1))+triangle.get(i).get(j);
				level.set(j, newval);
			}
		}
		return level.get(0);
		
	}