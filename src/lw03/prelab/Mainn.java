package lw03.prelab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Mainn {
    public static void main(String[] args) {
        System.out.println("===== Enrollment Checks =====");

        List<String> playlist = new ArrayList<>();

        Scanner sc1 = new Scanner(Mainn.class.getResourceAsStream("playlist.txt"));
        while (sc1.hasNextLine()) {
            String line = sc1.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+", 3);
            String operation = parts[0];

            if (operation.equals("ADD")) {
                playlist.add(parts[1]);
            } else if (operation.equals("INSERT")) {
                int index = Integer.parseInt(parts[1]);
                String songName = parts[2];
                playlist.add(index, songName);
            } else if (operation.equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }
        sc1.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        System.out.println();
        System.out.println("===== Problem 2 =====");

        Set<String> participants = new LinkedHashSet<>();
        int duplicateRegistration = 0;

        Scanner sc2 = new Scanner(Mainn.class.getResourceAsStream("participants.txt"));
        while (sc2.hasNextLine()) {
            String name = sc2.nextLine().trim();
            if (!name.isEmpty() && !participants.add(name)) {
                duplicateRegistration++;
            }
        }
        sc2.close();

        System.out.println("Duplicate registrations: " + duplicateRegistration);

        System.out.println();
        System.out.println("===== Problem 3 =====");

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        Scanner sc3 = new Scanner(Mainn.class.getResourceAsStream("inventory.txt"));
        while (sc3.hasNextLine()) {
            String line = sc3.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                int currentStock = inventory.getOrDefault(product, 0);
                inventory.put(product, currentStock + quantity);
            } else if (type.equals("SELL")) {
                int currentStock = inventory.getOrDefault(product, 0);
                if (currentStock >= quantity) {
                    inventory.put(product, currentStock - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        sc3.close();

        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }

        System.out.println("Failed sales: " + failedSales);
    }
}


