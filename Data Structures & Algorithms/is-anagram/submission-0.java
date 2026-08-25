class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t== null) return true;
        if(s == null || t== null) return false;
        if (s.length() != t.length()) return false;
        int chars[] = new int[26];
        for(int i=0; i < s.length() ; i++){
           int idx =  s.charAt(i) - 'a';
           chars[idx] =1+chars[idx];
        }

        for(int i=0; i < t.length() ; i++){
            int idx =  t.charAt(i) - 'a';
           chars[idx] =chars[idx]-1;
        }

        for(int i=0; i < 26 ; i++){
            if(chars[i] != 0) return false;
        }
        return true;
    }
}
