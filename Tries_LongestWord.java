import java.util.*;

public class Tries_LongestWord {
    public static String longest_String(String[] str) {
        Arrays.sort(str);
        Set<String> build = new HashSet<>();
        String longestWord = "";
        build.add("");
        for (int i = 0; i < str.length; i++) {
            String word = str[i];
            if (build.contains(word.substring(0,word.length()-1) )) {
                build.add(word);
                if(word.length()>longestWord.length()){
                    longestWord=word;
                }

            }
        }
        return longestWord;
    }
    public static void main(String[] args) {
        String[] words = {"apple", "app", "appl", "banana", "ban", "bat", "bats"};
        System.out.println("Longest word: " + longest_String(words));
    }

}
