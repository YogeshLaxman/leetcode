class Row {
    int pass;
    int total;
    int index;
    
    Row(int pass, int total, int index) {
        this.pass = pass;
        this.total = total;
        this.index = index;
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Row> pq = new PriorityQueue<>((a, b) -> {
            int p1 = a.pass;
            int t1 = a.total;
            
            int p2 = b.pass;
            int t2 = b.total;
            
            double a1 = 1.0*p1/t1;
            double na1 = 1.0*(1+p1)/(t1+1);
            
            double a2 = 1.0*p2/t2;
            double na2 = 1.0*(1+p2)/(t2+1);
            
            return (na1 - a1) > (na2 - a2) ? -1 : 1;
        });
        
        for (int i=0; i<classes.length; i++) {
            Row row = new Row(classes[i][0], classes[i][1], i);
            pq.add(row);
        }
        
        for (int j=1; j <= extraStudents; j++) {
            Row row = pq.poll();
            row.pass++;
            row.total++;
            pq.add(row);
        }
        
        double average = 0.0;
        while (!pq.isEmpty()) {
            Row row = pq.poll();
            double pass = row.pass;
            double total = row.total;
            
            average += pass/total;
        }
    
        return average/classes.length;
    }
}