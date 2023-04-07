class Solution {
    public boolean isValid(String s) {
        Stack<Character>parens = new Stack();
        Map<Character, Character> pairs = new HashMap();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for(char c: s.toCharArray()) {
            if (pairs.containsValue(c)) {
                parens.push(c);
            }
            else {
                if (parens.empty()) {
                    return false;
                }
                char top = parens.pop();
                if (pairs.get(c) != top) {
                    return false;
                }
            }
        }
        return parens.empty();
    }
}
