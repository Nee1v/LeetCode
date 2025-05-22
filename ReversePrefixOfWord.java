class Solution {
    public String reversePrefix(String word, char ch) {
        String str = new StringBuilder(word.substring(0, word.indexOf(ch) + 1)).reverse().toString();
        return str + word.substring(word.indexOf(ch) + 1);
    }
}
