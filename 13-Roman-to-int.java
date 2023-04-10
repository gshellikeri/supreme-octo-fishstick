class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> two = new LinkedHashMap<>();
        two.put("IV", 4);
        two.put("IX", 9);
        two.put("XL", 40);
        two.put("XC", 90);
        two.put("CD", 400);
        two.put("CM", 900);

        Map<String, Integer> one = new LinkedHashMap<>();
        one.put("I", 1);
        one.put("V", 5);
        one.put("X", 10);
        one.put("L", 50);
        one.put("C", 100);
        one.put("D", 500);
        one.put("M", 1000);

        int index = 0;
        int val = 0;
        while(index < s.length()) {
            if (index + 2 <= s.length() && two.containsKey(s.substring(index, index + 2))) {
                val += two.get(s.substring(index, index + 2));
                index += 2;
            }
            else if (one.containsKey(s.substring(index, index + 1))) {
                val += one.get(s.substring(index, index + 1));
                index += 1;
            }
        }
        return val;
    }
}
