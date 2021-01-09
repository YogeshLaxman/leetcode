class Solution {
    public int reverse(int x) {
        if( x < 0 ) 
            return  ((long)x <=Integer.MIN_VALUE)? 0: (-1 * reverse( -1 * x));
        long result = 0;
        
        while(x>0){
            int rem= x%10;
            result *= 10;
            result += rem;
            x = x/10;
        }
        if(result > Integer.MAX_VALUE)
            return 0;
        else
            return (int)result;
        
    }
}
