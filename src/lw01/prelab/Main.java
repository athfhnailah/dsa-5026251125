package lw01.prelab;
public class Main {
    public static void main(String[] args) {
        list<PrintJob> Jobs = new ArrayList<>();

        Scanner scanner = new Scanner
        (Main.class.getResourceAsStream("jobs.txt"));

        while (scanner.hasNext()){
            Strint type = scanner.next();
            String id = scanner.next();
            int pages = scanner.nextInt();

            PrintJob job;
            if (type.equals("mono")){
                job = new MonoPrint(id, pages);
            } else {
                job = new ColourPrint(id, pages);
            } 

            jobs.add(job);
        }

        for (PrintJob job : jobs){
            System.out.println(job.summary());
        }
    }
}   