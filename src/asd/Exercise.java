package asd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercise {
        public static void mirror(Queue<String> q) {
        Stack<String> stack = new Stack<>();

        int size = q.size();
        for (int i = 0; i < size; i++) {
            String element = q.remove();
            q.add(element);    
            stack.push(element);  
        }
         while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
    }
       public static void main(String[] args) {
            Queue<String> q = new LinkedList<>(Arrays.asList("a", "b", "c"));
            mirror(q);
            System.out.println(q); 
        }
        public static void main(String[] args) {
        findNumber(new int[]{2, 6, 4, 9, 10});
        System.out.println();
    }
       

    