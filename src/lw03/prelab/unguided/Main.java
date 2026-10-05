package lw03.prelab.unguided;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        System.out.println("===== Enrollment Checks =====");

        Map<String, Integer> enrollment = new LinkedHashMap<>();
        List<String> check = new ArrayList<>();
        int rejected = 0;

        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String operation = parts[0];
            String course = parts[1];

            if (operation.equals("REGISTER")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0) {
                    rejected++;
                } else {
                    enrollment.put(course, enrollment.getOrDefault(course, 0) + count);
                }

            } else if (operation.equals("WITHDRAW")) {
                int count = Integer.parseInt(parts[2]);
                if (count <= 0 || !enrollment.containsKey(course) || enrollment.get(course) < count) {
                    rejected++;
                } else {
                    enrollment.put(course, enrollment.get(course) - count);
                }

            } else if (operation.equals("CHECK")) {
                if (enrollment.containsKey(course)) {
                    check.add(course + ": " + enrollment.get(course) + " students");
                } else {
                    check.add(course + ": Not found");
                }
            }
        }
        sc.close();

        for (String result : check) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (String course : enrollment.keySet()) {
            System.out.println(course + ": " + enrollment.get(course) + " students");
        }
        System.out.println("Rejected operations: " + rejected);
    }
}
