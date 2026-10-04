package asd;
import java.util.*;

public class RemoveDuplicates {
    public static void removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                result.add(num);
            }
        }
        list.clear();
        list.addAll(result);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,0,2,9,4,7,2,6);
        List<Integer> list = new ArrayList<>(numbers);
        removeDuplicates(list);
        System.out.println(list); // Output: [4,0,2,9,7,6]
    }
}