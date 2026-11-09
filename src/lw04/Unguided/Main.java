package lw04.Unguided;

import java.util.Scanner;
public class Main {
    static void selectionSort(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int N = sc.nextInt();
        int[] cards = new int[N];

        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] requests = new int[M];
        for (int i = 0; i < M; i++) {
            requests[i] = sc.nextInt();
        }
        sc.close();

        selectionSort(cards, 2);

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < M; i++) {
            int index = linearSearch(cards, requests[i]);

            if (index != -1) {
                System.out.println(requests[i] + ": FOUND at index " + index);
            } else {
                System.out.println(requests[i] + ": NOT FOUND");
            }
        }
    }
}