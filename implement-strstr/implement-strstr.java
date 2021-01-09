class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0 ) return 0;
        for(int i=0 ; i<haystack.length() ; i++){
            //System.out.println("i: "+ i);
            if(haystack.charAt(i) == needle.charAt(0) && i+needle.length() <= haystack.length()){
                String haystackSubstring = haystack.substring(i,i+needle.length());
              //  System.out.println("haystackSubstring: " + haystackSubstring);
                if(haystackSubstring.equals(needle)) return i;
            }
        }
        return -1;
    }
}
