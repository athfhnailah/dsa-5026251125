package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> BorrowingRequests = new LinkedList<>();
        LinkedList<String[]> BookRecords = new LinkedList<>();
        LinkedList<String[]> MemberRecords = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        BookRecords.add(new String[]{"Kalkulus", "2"});
        BookRecords.add(new String[]{"Fisika", "1"});
        BookRecords.add(new String[]{"Statistika", "2"});

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("Borrowing.txt")));
        while (scanner.hasNext()) {
            String name = scanner.next();
            String booktitle = scanner.next();
            String[] borrowingRequest = new String[]{name, booktitle};
            BorrowingRequests.add(borrowingRequest);
            }
        }

        queue.addAll(BorrowingRequests);
        while (!queue.isEmpty()) {
            String[] borrowingRequest = queue.poll();
            String requestName = borrowingRequest[0];
            String booktitle = borrowingRequest[1];

            String[] memberRecord = null;
            for (String[] record : MemberRecords) {
                if (record[0].equals(requestName)) {
                    memberRecord = record;
                    break;
                }
            }

            String[] book = null;
            for (String[] b : BookRecords) {
                if (b[0].equals(booktitle)) {
                    book = b;
                    break;
                }
            }
        }
    }
}