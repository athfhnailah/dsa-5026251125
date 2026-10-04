package asd;
import java.util.*;

public class CountVote {
    static void countVote(String V) {
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < V.length(); i++) {
            char c = V.charAt(i);
            if (c == ' ') continue;
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Set<Character> set = count.keySet();
        char winner = '\0';
        int maxVote = 0;

        for (Character c : set) {
            int votes = count.get(c);
            if (votes > maxVote) {
                maxVote = votes;
                winner = c;
            }
        }

        // Cetak hasil
        System.out.println(winner + " " + maxVote);
    }

    public static void main(String[] args) {
        countVote("AABCAADE");       // Output: A 4
        countVote("ABBCDKLMDDDD");   // Output: D 5
        countVote("XWZSXABCDE");     // Output: X 2
    }
}
