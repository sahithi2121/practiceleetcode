class Solution {
 public int[][] insert(int[][] intervals, int[] newInterval) {
     
     //if i.end <newInterval.start add i to result; meeting room sum
        //i.start>newInterval.end then add both to result and mark newInterval as null
        //overlap between i and new Interval we can merge i into new Interval and use to compare with latter.
    
    
      List<int[]> ans = new ArrayList<>();
        boolean done = false;
        for (int i = 0 ; i < intervals.length ; i++) {
            if (done || newInterval[0] > intervals[i][1]) {
                ans.add(intervals[i]);
            } else {
                if (newInterval[1] < intervals[i][0]){
                    ans.add(newInterval);
                    i--;
                    done = true;
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                }
            }
        }
        if (done == false) ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }}
