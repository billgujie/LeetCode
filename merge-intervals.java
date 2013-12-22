/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        Stack<Interval> sk= new Stack<Interval>();
        
        ArrayList<Interval> result= new ArrayList<Interval>();
        
        int N=intervals.size();
        if(N==0) return result;
        sk.push(intervals.get(0));
        for(int i=1;i<N;i++){
            Interval peek=sk.peek();
            Interval cur = intervals.get(i);//current from list
            if ((cur.start-peek.end)<1){//overlap
                Interval out=sk.pop();
                int newend = out.end>=cur.end? out.end : cur.end; 
                Interval in = new Interval(out.start, newend);
                sk.push(in);
            }else{  //not overlap
                sk.push(cur);
            }
        }
        
        while(!sk.empty()){
            result.add(sk.pop());
        }
        Collections.sort(result, new IntervalComparator());
        return result;
    }
}