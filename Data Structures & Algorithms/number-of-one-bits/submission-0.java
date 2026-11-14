class Solution {
    public int hammingWeight(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return n%2+ hammingWeight(n/2);
    }
}
