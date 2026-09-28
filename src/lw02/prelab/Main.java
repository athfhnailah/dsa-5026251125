package lw02.prelab;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>(); //menyimpan data transaksi
        LinkedList<String[]> customers = new LinkedList<>(); //menyimpan data customer
        Queue<String[]> queue = new LinkedList<>();

        Stack<String[]> fails = new Stack<>(); //menyimpan data transaksi yang gagal
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (scanner.hasNext()) {
            String[] transaction = new String[3];
            transaction[0] = scanner.next();
            transaction[1] = scanner.next();
            transaction[2] = scanner.next();
            transactions.add(transaction);
            
        }
        scanner.close();
    
        queue.addAll(transactions); //proses transaksi satu per satu

        while(!queue.isEmpty()) {
            String[] transaction = queue.poll();
            String name = transaction[0]; //nama customer
            String type = transaction[1]; //jenis transaksi 
            int amount = Integer.parseInt(transaction[2]); //jumlah uang yang ditransaksikan

            String[] customer = null;
            for (String[] c : customers) {
                if (c[0].equals(name)) {
                    customer = c;
                    break;
                }
            }
            
            if (customer == null) {
                customer = new String[]{name, "0"};
                customers.add(customer); //menambahkan customer baru jika belum ada ke linkedlist
            }

            int balance = Integer.parseInt(customer[1]);
            if (type.equals("DEPOSIT")) {
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else {
                if (balance >= amount) {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                } else {
                    fails.push(transaction);
                }
            }
        }
        System.out.println("=== Final Balances ===");

        for (String[] oke : customers) {
            System.out.println (oke[0] + " " + oke[1]); //menampilkan nama customer dan saldo akhir
        } 
        System.out.println("=== Failed Transactions ===");
        while (!fails.isEmpty()) {
            String[] fail = fails.pop();
            System.out.println(fail[0] + " " + fail[1] + " " + fail[2]); //menampilkan transaksi yang gagal

