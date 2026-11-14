class Solution {
    public int[] countBits(int n) {
        int[] nums = new int[n+1];
        for (int i = 0; i <= n; i++) {
            nums[i]= ones(i);
        }
        return nums;
    }

    int ones(int n){
        if(n<2) return n;
        return n%2 + ones(n/2);
    }
}
