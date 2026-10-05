package lw03.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> playlist = new ArrayList<>();
        Scanner scanner1 = new Scanner(
            Main.class.getResourceAsStream("playlist.txt")
        );

        while (scanner1.hasNext()) {

            String type = scanner1.next();

            if (type.equals("ADD")) {

                String song = scanner1.next();
                playlist.add(song);

            } else if (type.equals("INSERT")) {

                int index = scanner1.nextInt();
                String song = scanner1.next();

                playlist.add(index, song);

            } else if (type.equals("REMOVE")) {

                String song = scanner1.next();

                if (playlist.contains(song)) {
                    playlist.remove(song);
                }
            }
        }

        scanner1.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        Set<String> participants = new LinkedHashSet<>();
        Scanner scanner2 = new Scanner(
            Main.class.getResourceAsStream("participants.txt")
        );
        int duplicate = 0;
        while (scanner2.hasNext()) {
            String name = scanner2.next();
            if (participants.contains(name)) {
                duplicate++;
            } else {
                participants.add(name);
            }
        }

        scanner2.close();

        System.out.println();
        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: " + duplicate);

        Map<String, Integer> inventory = new LinkedHashMap<>();
        Scanner scanner3 = new Scanner(
            Main.class.getResourceAsStream("inventory.txt")
        );

        int failedSales = 0;

        while (scanner3.hasNext()) {

            String type = scanner3.next();
            String product = scanner3.next();
            int quantity = scanner3.nextInt();

            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);
                    inventory.put(product, stock + quantity);

                } else {

                    inventory.put(product, quantity);
                }

            } else if (type.equals("SELL")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);

                    if (stock >= quantity) {

                        inventory.put(product, stock - quantity);

                    } else {

                        failedSales++;
                    }

                } else {

                    failedSales++;
                }
            }
        }

        scanner3.close();

        System.out.println();
        System.out.println("===== Problem 3 =====");

        for (String product : inventory.keySet()) {
            System.out.println(
                product + ": " + inventory.get(product)
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}