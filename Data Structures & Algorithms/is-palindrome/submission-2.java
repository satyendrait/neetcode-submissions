class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            System.out.println(l + " , " + r);
            while (l <= r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                System.out.println(l + ", ");
            }
            while (l <= r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                System.out.println(" , " + r);
            }

            if (l <= r
                && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }
}
