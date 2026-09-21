package lw01.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int r = sc.nextInt();

        Rental[] list = new Rental[r];
        for (int i = 0; i < r; i++) {
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            sc.nextInt();

            if (type.equals("laptop")) {
                list[i] = new LaptopRental(id, days);
            } else {
                list[i] = new ProjectorRental(id, days);
            }
            sc.close();
        }
        for (Rental rental : list) {
            System.out.println(rental.summary());
        }
    }
}   