import java.util.*;
import java.util.HashMap;

public class String_SubstringWith_K_Distinct_Character {
    public static int countSubstring(String s, int k) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() == k) {
                    count++;
                } else if (set.size() > k) {
                    break;
                }
            }
        }
        return count;
    }

    public static int atMostKDistincr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int start = 0, count = 0;
        for (int end = 0; end < n; end++) {
            char endChar = s.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);
            while (freqMap.size() > k) {
                char startChar = s.charAt(start);
                freqMap.put(startChar , freqMap.get(startChar) - 1);
                if (freqMap.get(startChar) == 0) {
                    freqMap.remove(startChar);

                }
                start++;

            }
            count += (end - start + 1);

        }
        return count;
    }

    public static int countSubstringOptimized(String s, int k) {
        return atMostKDistincr(s, k) - atMostKDistincr(s, k - 1);
    }

    public static void main(String[] args) {
        String s = "abcba";
        int k = 2;

        int result = countSubstring(s, k);
        System.out.println("Count of substrings with " + k + " distinct characters: " + result);
        int result1 = countSubstringOptimized(s, k);
        System.out.println("Count of substrings with " + k + " distinct characters: " + result1);

    }
}
