class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numIdx = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (numIdx.containsKey(diff))
                return new int[] {numIdx.get(diff) + 1, i + 1};
            numIdx.put(numbers[i], i);
        }
        return new int[] {};
    }
}
