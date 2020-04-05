package Lab4_Executors_2;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

class TaskProvider implements Runnable {


    @Override
    public void run() {
        String[] srcFiles = {"plikA4.txt", "plikB4.txt", "plikC4.txt", "plikD4.txt", "plikE4.txt", "plikF4.txt", "plikG4.txt", "plikH4.txt"};

        for (String file : srcFiles) {

            SingletonService.getInstance().getService().submit(() -> {

                Map<Integer, Integer> values = new HashMap<Integer, Integer>();

                for (int i = 0; i < 100; i++) values.put(i, 0);

                Scanner result = new Scanner(new File(file));

                while (result.hasNext()) {
                    String val = result.next();

                    Integer ival = Integer.parseInt(val);

                    int temp = values.get(ival).intValue();

                    temp++;

                    values.replace(ival, temp);
                }
                AtomicReference<Integer> count = new AtomicReference<>(-1);
                AtomicReference<Integer> value = new AtomicReference<>(0);

                values.forEach((k, v) -> {
                    if (v > count.get()) {
                        value.set(k);
                        count.set(v);
                    }
                });
                return new HashMap<Integer, Integer>(value.get(), count.get());
            });
        }
    }
}

