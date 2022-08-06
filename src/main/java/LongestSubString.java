import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public void run() {
        String input = "abcedfabcaefga";
        System.out.println("longestSubstringLength : " + findLongestSubstring(input));
    }

    public int findLongestSubstring(String input) {
        // 2 pointer, sliding window
        int pointerA = 0;
        int pointerB = 0;
        int longestSubstringLength = 0;
        Map<Character, Integer> subStringMap = new HashMap<Character, Integer>();
        for (Character c : input.toCharArray()) {
            // check if map already has char
            if (subStringMap.containsKey(c)) {
                // when match repeated char
                // compare pointerA and value
                if (subStringMap.get(c) >= pointerA) {
                    // update pointerA & last seen char index
                    pointerA = subStringMap.get(c) + 1;
                    subStringMap.put(c, pointerB);
                    longestSubstringLength = Math.max((pointerB - pointerA + 1), longestSubstringLength);
                } else {
                    // update last seen char index only
                    subStringMap.put(c, pointerB);
                    longestSubstringLength = Math.max((pointerB - pointerA + 1), longestSubstringLength);
                }
            } else {
                subStringMap.put(c, pointerB);
            }

            // last char
            if (pointerB == input.toCharArray().length - 1) {
                longestSubstringLength = Math.max((pointerB - pointerA + 1), longestSubstringLength);
            }
            pointerB++;
        }
        return longestSubstringLength;
    }
}
