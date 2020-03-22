package Lab3_Executors;

import java.io.*;
import java.util.Scanner;

public class MyTaskCopy implements Runnable {

    String zrodlowy;
    String docelowy;


    public MyTaskCopy(String in, String out) {
        this.zrodlowy = in;
        this.docelowy = out;
    }

    @Override
    public void run() {
        try {

            File f1 = new File(zrodlowy);
            File f2 = new File(docelowy);

            Scanner in = new Scanner(f1);
            OutputStream out = new FileOutputStream(f2);

            byte buf[] = new byte[1024];
            int i = 0;

            while (in.hasNextByte()) {

                if (in.hasNextByte() && i < buf.length) {
                    buf[i] = in.nextByte();
                    i++;
                }else{
                    out.write(buf, 0, i);
                    out.flush();
                }

            }
            in.close();
            out.close();
            System.out.println("Skopiowano plik! Wykonałem to ja - Wątek + " + Thread.currentThread().getId());

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
