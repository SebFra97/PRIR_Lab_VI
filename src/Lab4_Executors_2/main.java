package Lab4_Executors_2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;

public class main {

    private static void generateFiles() {
        List<String> files = List.of("plikA4.txt", "plikB4.txt", "plikC4.txt",
                "plikD4.txt", "plikE4.txt", "plikF4.txt", "plikG4.txt", "plikH4.txt");
        for (var s : files) {
            try (PrintStream ps = new PrintStream(s);) {
                Random r = new Random();
                int iter = r.nextInt(10000);
                for (int i = 0; i < iter; i++) {
                    int val = r.nextInt(100);
                    ps.println(val);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        //generateFiles();
        Thread taskProvider = new Thread(new TaskProvider());
        Thread resultsReceiver = new Thread(new ResultsReceiver());
        taskProvider.start();
        resultsReceiver.start();

    }
}
