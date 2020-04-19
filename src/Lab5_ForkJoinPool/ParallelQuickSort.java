package Lab5_ForkJoinPool;

import java.util.concurrent.ForkJoinPool;

public class ParallelQuickSort implements Sort {

    int[] tab;

    @Override
    public void sort(int[] tab) {
        ForkJoinPool forkJoin = new ForkJoinPool();
        MyParallelTask task = new MyParallelTask(tab, 0, tab.length -1);
        forkJoin.invoke(task);
    }
}
