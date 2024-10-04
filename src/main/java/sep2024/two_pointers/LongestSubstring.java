package sep2024.two_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int lo = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            while (seen.contains(s.charAt(i))) {
                seen.remove(s.charAt(lo++));
            }
            seen.add(s.charAt(i));
            ans = Math.max(ans, i - lo + 1);
        }
        return ans;
    }

}
