class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        
        int[] meetingsCount = new int[n];
        int maxCount = 0, maxRoomId = -1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        for (int i=0; i<n; i++) {
            pq.add(i);
        }
        
        PriorityQueue<int[]> ongoingMeetingsPQ = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int index = 0;
        
        while (index < meetings.length) {
            int[] meeting = meetings[index];
            
            int startTime = meeting[0];
            int endTime = meeting[1];
            
            while (!ongoingMeetingsPQ.isEmpty()) {
                if (ongoingMeetingsPQ.peek()[0] <= startTime) {
                    pq.add(ongoingMeetingsPQ.poll()[1]);
                } else {
                    break;
                }
            }
            
            if (pq.size() == 0) {
                int delay = ongoingMeetingsPQ.peek()[0] - startTime;
                startTime += delay;
                endTime += delay;
                pq.add(ongoingMeetingsPQ.poll()[1]);
            }
            
            int next = pq.poll();
            meetingsCount[next] += 1;
            if (meetingsCount[next] > maxCount || (meetingsCount[next] == maxCount && next < maxRoomId)) {
                maxCount = meetingsCount[next];
                maxRoomId = next;
            }

            ongoingMeetingsPQ.add(new int[] {endTime, next});
            index++;
        }
        
        return maxRoomId; 
    }
}