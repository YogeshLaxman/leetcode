class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=lowLimit; i<=highLimit; i++) {
            String s = String.valueOf(i);
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - '0';               
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        // System.out.println(map);
        return max;
    }
}