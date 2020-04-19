package Lab5_ForkJoinPool;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] tab = {5, 7, 3, 2, 8, 0, 1, 6, 10};
        {
            System.out.println("Quick Sort ");
            System.out.println("------------------------------------");
            int[] tmpTab = Arrays.copyOf(tab, tab.length);
            System.out.println(Arrays.toString(tmpTab));
            Sort sort = new QuickSort();
            sort.sort(tmpTab);
            System.out.println(Arrays.toString(tmpTab));
            System.out.println("------------------------------------");
            System.out.println("Koniec Quick Sort");
        }
        {
            System.out.println("ParallelQuickSort with ForkPoolJoin");
            System.out.println("------------------------------------");
            int[] tmpTab = Arrays.copyOf(tab, tab.length);
            System.out.println(Arrays.toString(tmpTab));
            Sort sort = new ParallelQuickSort();
            sort.sort(tmpTab);
            System.out.println(Arrays.toString(tmpTab));
            System.out.println("------------------------------------");
            System.out.println("Koniec ParallelQuickSort with ForkPoolJoin");
        }
    }
}

