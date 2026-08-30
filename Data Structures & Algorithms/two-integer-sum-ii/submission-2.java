class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int pair = target- numbers[i];
            int j = binarySearch(numbers, pair, i + 1, numbers.length - 1);
            if (j == -1) {
                continue;
            } else {
                return new int[] {i+1, j+1};
            }
        }
        return new int[] {};
    }

    int binarySearch(int[] numbers, int pair, int l, int r) {
        if(l>r) return -1;
        int mid = (l + r) / 2;
        if (numbers[mid] == pair)
            return mid;
        if (numbers[mid] < pair) {
            l = mid + 1;
        }
        if (numbers[mid] > pair) {
            r = mid - 1;
        }
        return binarySearch(numbers, pair, l, r);
    }
}
