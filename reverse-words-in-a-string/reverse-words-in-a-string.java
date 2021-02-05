class Solution {
    public String reverseWords(String s) {
        String[] split = s.split("\\s+");
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String item: split) {
            if (!item.equals(" ") && !item.equals("")) {
                list.add(item);
            }
        }
        // System.out.println(list);
        Collections.reverse(list);
        
        StringBuilder sb = new StringBuilder("");
        sb.append(list.get(0));
        for (int i=1; i<list.size(); i++) {
            sb.append(" ").append(list.get(i));
        }
        return sb.toString();
    }
}