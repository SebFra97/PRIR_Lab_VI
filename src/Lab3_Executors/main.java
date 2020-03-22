package Lab3_Executors;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;
import static java.util.List.*;

public class main {

    public static void generateFiles(List<String> files){
        for(String s : files){
            try(PrintStream ps = new PrintStream(s);) {
                Random r = new Random();
                for (int i = 0; i < 1000000; i++) {
                    double val = r.nextDouble() * 100;
                    ps.println(val);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        List<String> srcFiles =  List.of("plikA.txt","plikB.txt","plikC.txt","plikD.txt","plikE.txt","plikF.txt","plikG.txt");
        List<String> dstFiles = List.of("plikADst.txt","plikBDst.txt","plikCDst.txt","plikDDst.txt","plikEDst.txt","plikFDst.txt","plikGDst.txt");

        generateFiles(srcFiles);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(7);

        for(int i = 0; i < srcFiles.size(); i++) {

            MyTaskCopy copyTask = new MyTaskCopy(srcFiles.get(i), dstFiles.get(i));
            System.out.println("Kopiowanie plików - # "+ i +" # -");
            executor.execute(copyTask);
        }
        System.out.println("Zakończono kopiowanie plików");
        executor.shutdown();

        try{

            executor.awaitTermination(Long.MAX_VALUE,TimeUnit.MILLISECONDS);

            long finish = System.currentTimeMillis();
            long czasTrwania = finish - start;
            System.out.println("Czas kopiowania : " + czasTrwania + " ms.");
        } catch(InterruptedException e) {
        }
    }
}
