package solution.leetcode.jieGu;

import java.util.HashMap;

public class MaxPointsOnLine {
	public int maxPoints(Point[] points) {
		int size = points.length;
		if (size <= 2) {
			return size;
		}
		
		int max_occurence=0;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		for (int i = 0; i < size; i++) {
			map.clear();
			map.put((double) Integer.MIN_VALUE, 1);
			int duplicate = 0;
			for (int j = i + 1; j < size; j++) {
				// handle duplicates
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					duplicate++;
					continue;
				}

				double slop = (points[j].x - points[i].x == 0) ? Integer.MAX_VALUE : ((double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x))+0.0;
				
				if (map.containsKey(slop)){
					map.put(slop, map.get(slop)+1);
				}else{
					map.put(slop, 2);
				}
			}
			
			//get maximum from the map value
			for (int value: map.values()){
				if (value+duplicate>max_occurence)
					max_occurence=value+duplicate;
			}
		}
		return max_occurence;
	}
}
