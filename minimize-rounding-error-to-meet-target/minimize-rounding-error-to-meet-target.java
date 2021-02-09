class Solution {
    public String minimizeError(String[] prices, int target) {
        int[] decimals = new int[prices.length];
        
        int sum = 0;
        for (int i=0; i<prices.length; i++) {
            String[] split = prices[i].split("\\.");
            int intValue = Integer.parseInt(split[0]);
            sum += intValue;
            decimals[i] = Integer.parseInt(split[1]);
        }
        int diff = (target - sum) * 1000;
    
        Arrays.sort(decimals);
        // System.out.println(diff);
        // System.out.println(Arrays.toString(decimals));
        
        int low = 0, high = prices.length - 1;
        int error = 0;
        if (diff < 0) {
            return "-1";
        }
        while (high>=0 && diff > 0 && decimals[high] > 0) {
            error += (1000 - decimals[high--]);
            diff -= 1000;
        }
        if (diff > 0) {
            return "-1";
        }
        
        while(low <= high) {
            error += (decimals[low++] - 0);
        }
        if (error < 1000) {
            String str = String.valueOf(error);
            while (str.length() < 3) {
                str = str + "0";
            }
            return "0." + str;
        } else {
            String str = String.valueOf(error);
            return String.valueOf(error/1000) + "." + str.substring(str.length() - 3);
        }
    }
}