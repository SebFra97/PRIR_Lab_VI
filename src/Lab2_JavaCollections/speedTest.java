package Lab2_JavaCollections;

import java.util.List;

import static java.lang.System.currentTimeMillis;


public class speedTest {

    static void testing(List<Integer> testLista){

        for(int i=0; i < 100_000; i++){
            testLista.add(i);
        }

        System.out.println("Czas dodania miliona elementów : " + currentTimeMillis());

        for(int j = 0; j < 100_000; j++)
            testLista.get(j);

        System.out.println("Czas odczytu z get() : " + currentTimeMillis());

        for(int item:testLista)
            System.out.println(item);

        System.out.println("Czas odczytu foreach : " + currentTimeMillis());

    }
}
