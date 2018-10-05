/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0 || intervals.size() == 1) {
      return intervals;
    }
        
      intervals.sort(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    int prev = 0;
    int start = 0;
    int k = 0;
    int i = 1;

    while (i < intervals.size()) {
      if (isOverLapping(start, prev, i, intervals)) {
        Interval prevNode = intervals.get(prev);
        Interval currNode = intervals.get(i);
        if(prevNode.end>currNode.end) currNode.end=prevNode.end;
        
        prev = i;
        i++;
      } else {
        intervals.set(k++, new Interval(intervals.get(start).start, intervals.get(prev).end));
        prev = start = i++;
      }
    }
    intervals.set(k++,new Interval(intervals.get(start).start,intervals.get(prev).end));
    return intervals.subList(0, k);

  }

  private boolean isOverLapping(int start, int prev, int i,
      List<Interval> intervals) {
    Interval prevNode = intervals.get(prev);
    Interval currNode = intervals.get(i);
    return prevNode.end >= currNode.start;
  }
}
