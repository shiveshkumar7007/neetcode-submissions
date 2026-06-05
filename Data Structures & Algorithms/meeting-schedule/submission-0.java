class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // Sort by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i = 1; i < intervals.size(); i++) {

            Interval prev = intervals.get(i - 1);
            Interval curr = intervals.get(i);

            // Conflict exists
            if(curr.start < prev.end) {
                return false;
            }
        }

        return true;
    }
}