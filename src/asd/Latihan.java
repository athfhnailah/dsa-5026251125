package asd;
import java.util.LinkedList;

public class Latihan {
static LinkedList<Integer> change(int[] a, int i) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int v : a) {
        list.add(v);
    }
    for (int j = 0; j < i; j++) {
        if (list.get(j) >= list.get(i)) {
            list.set(j, (int) (Math.random() * list.get(i)));
        }
    }
    for (int v : list) {
        System.out.print(v + " ");
    }
    return list;
}
     public static void main(String[] args) {
        change(new int[]{2, 6, 4, 9, 10}, 3);
        System.out.println();

        change(new int[]{1, 5, 7, 1}, 3);
  
        change(new int[]{5, 4, 3}, 1);
        System.out.println();

        change(new int[]{3, 5, 7, 7, 9, 8}, 5);
        System.out.println();
}
}