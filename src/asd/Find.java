package asd;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Find {
    public static void findNumber(int[] a) {
    Stack<Integer> stack = new Stack<>();
    for (int v : a) {
        while (!stack.empty() && stack.peek() >= v) {
            stack.pop();
        }
        stack.push(v);
    }
    while (!stack.empty()) {
        System.out.print(stack.pop() + " ");
    }
}
 public static void main(String[] args) {
        findNumber(new int[]{2, 6, 4, 9, 10});
        System.out.println();
}
}