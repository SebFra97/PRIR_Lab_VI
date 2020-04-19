package Lab5_ForkJoinPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyParallelTask extends RecursiveAction {

        private int array[];
        int start;
        int koniec;

        public MyParallelTask(int[] array, int start, int koniec) {
            this.array = array;
            this.start = start;
            this.koniec = koniec;
        }

        // OPARTE O LISTĘ TASKÓW + invokeAll

        /*
        @Override
        protected void compute() {
            int j = split(array, start, koniec);

            List<MyParallelTask> list = new ArrayList<>();

            if (start < j)
                list.add(new MyParallelTask(array, start, j - 1));
            if (j + 1 < koniec)
                list.add(new MyParallelTask(array, j + 1, koniec));

            this.invokeAll(list);
        }*/

    @Override
    protected void compute() {
        int j = split(array, start, koniec);
        MyParallelTask t1 = null, t2 = null;
        if (start < j) {
            t1 = new MyParallelTask(array, start, j - 1);
            t1.fork();
        }
        if (j + 1 < koniec) {
            t2 = new MyParallelTask(array, j + 1, koniec);
            t2.fork();
        }
        if (t2 != null)
            t2.join();
        if (t1 != null)
            t1.join();
    }



        private int split(int[] tab, int start, int koniec) {
            int i = (start + koniec) / 2;
            int pivot = tab[i];
            swap(tab, i, koniec);
            int j = start;
            for (i = start; i < koniec; i++) {
                if (tab[i] < pivot) {
                    swap(tab, i, j);
                    j++;
                }
            }
            tab[koniec] = tab[j];
            tab[j] = pivot;
            return j;
        }
        private void swap(int[] tab, int i, int j) {
            int tmp = tab[i];
            tab[i] = tab[j];
            tab[j] = tmp;
        }
}

