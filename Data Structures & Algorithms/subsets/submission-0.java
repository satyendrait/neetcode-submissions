class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList();
         res.add(new ArrayList<Integer>());
        for(int num: nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                List<Integer> newSubList = new ArrayList<>(res.get(i));
                newSubList.add(num);
                res.add(newSubList);
            }
        }
        return res;
    }
}
