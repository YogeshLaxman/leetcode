class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        
        for (int m=0; m<26; m++) {
            char currentChar = (char) ('A' + m);
            List<Integer> list = buildList(s, currentChar);
            // System.out.println(list);
            int low = 0, high = 0;
            
            int current = 0;
            int rem = k;
            while (high < list.size()) {
                if (list.get(high) >= 0) {
                    current += list.get(high);
                    high++;
                } else if (list.get(high) < 0) {
                    if (rem < list.get(high) * -1) {
                        if (list.get(low) >= 0) {
                            if (low-1 >= 0 && list.get(low-1) < 0) {
                                if (rem < list.get(low-1)*-1) {
                                    max = Math.max(current + rem, max);
                                }
                            }
                            current -= list.get(low);
                        } else {
                            rem -= list.get(low);
                            current += list.get(low);
                        }
                        low++;
                    } else {
                        rem += list.get(high);
                        current -= list.get(high);
                        high++;
                    }
                }
                
                max = Math.max(current, max);
            }
            if (low-1 >= 0 && list.get(low-1) < 0) {
                    if (rem < list.get(low-1)*-1) {
                        max = Math.max(current + rem, max);
                    }
                }
        }
        
        return max;
    }
    
    private List<Integer> buildList(String s, char currentChar) {
        List<Integer> list = new ArrayList<>();
        boolean prev = false;
        int current = 0;
        for (int i=0; i<s.length(); i++) {
            if (currentChar == s.charAt(i)) {
                if (prev == false) {
                    list.add(-1 * current);
                    current = 0;
                }
                current++;
                prev = true;
            } else if (prev == true) {
                list.add(current);
                current = 1;
                prev = false;
            } else if (prev == false) {
                current++;
            }
        }
        if (prev == true) {
            list.add(current);
        } else if (prev == false) {
            list.add(-1 * current);
        }
        
        return list;
    }
}