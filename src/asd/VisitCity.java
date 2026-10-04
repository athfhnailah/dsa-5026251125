package asd;
import java.util.*;
public class VisitCity { 
    static void visitedCities(String a, String b) {
        Set<Character> R1 = new TreeSet<>();
        Set<Character> R2 = new TreeSet<>();
        for (int i = 0; i < a.length(); i++) R1.add(a.charAt(i));
        for (int i = 0; i < b.length(); i++) R2.add(b.charAt(i));

        Set<Character> union = new TreeSet<>(R1);
        union.addAll(R2);

        Set<Character> intersection = new TreeSet<>(R1);
        intersection.retainAll(R2);

        union.removeAll(intersection);

        for (Character c : union) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        visitedCities("ABCBA", "DCAEF"); 
        visitedCities("KLACK", "ADAM");   
        visitedCities("ABC", "DEF");     
    }
}

