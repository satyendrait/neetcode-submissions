class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] counts = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            counts[index]++;

            maxFrequency = Math.max(maxFrequency, counts[index]);

            int windowSize = right - left + 1;

            // Shrink the window if it needs more than k replacements.
            while (windowSize - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
                windowSize = right - left + 1;
            }

            result = Math.max(result, windowSize);
        }

        return result;
    }
}