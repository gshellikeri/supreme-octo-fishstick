class Solution {
    public int lengthOfLongestSubstring(String s) {
        int back = 0;
        int front = 0;
        Set<Character> chars = new HashSet();
        int maxLen = 0;

        while (front < s.length()) {
            while (back < front && chars.contains(s.charAt(front))) {
                chars.remove(s.charAt(back));
                back += 1;
            }
            chars.add(s.charAt(front));
            front += 1;
            maxLen = Math.max(maxLen, front - back);

        }
        return maxLen;
    }
}
