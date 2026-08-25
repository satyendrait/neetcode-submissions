class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null) return false;
        Set<Integer> numbers = new HashSet();
        for(int i=0; i< nums.length;i++){
           if(!numbers.add(nums[i])) return true;
        }
        return false;
    }
}