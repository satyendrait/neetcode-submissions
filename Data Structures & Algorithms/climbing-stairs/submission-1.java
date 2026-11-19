class Solution {
    public int climbStairs(int n) {
        if(n<5) return n;
        int res =1;
        while(n>=1){
            n-=2;
            res++;
        }
        return res;
    }
}
