# Reverse Prefix Of Word
### The purpose of this solution is to point out how much more efficient using a StringBuilder is for String building
```java
class Solution {
    public String reversePrefix(String word, char ch) {
        String str = new StringBuilder(word.substring(0, word.indexOf(ch) + 1)).reverse().toString();
        return str + word.substring(word.indexOf(ch) + 1);
    }
}
```
### In this solution we simply reverse the string from index 0 to the first instance of the `char ch`, then append the remaining string from `String word` that was not reversed. This solution highlights how simple an efficient StringBuilder is.
# 
```java
class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index > 0) {
            String[] split = word.substring(0, index + 1).split("");
            int p1 = 0;
            while(p1 < index - p1) {
                String temp = split[p1];
                split[p1] = split[index - p1];
                split[index - p1] = temp;
                p1++;
            }
            String append = word.substring(index + 1);
            word = "";
            for(int i = 0; i < split.length; i++) {
                word = word + split[i];
            }

            return word + append;
        }
        return word;
    }
}
```
### Now on the other hand there is this much more complex solution in which we find the index of the first instance of `char ch`. If the index is -1 return `String word` as is, else we will split the substring of `String word` up until `int index`. Now we simply reverse the `String[] split` array and then using the reversed array which simulates the reversed substring we build the full string.
### Even after all that we still run substantially slower than the StringBuilder version, this just goes to show that you dont need complex code to optimize your performance.
