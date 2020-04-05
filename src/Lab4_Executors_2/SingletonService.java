package Lab4_Executors_2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class SingletonService {

    private static volatile SingletonService instance;
    private static volatile CompletionService<HashMap<Integer,Integer>> service;

    public SingletonService() {
        service = new ExecutorCompletionService<>(Executors.newFixedThreadPool(10));
    }

    public static SingletonService getInstance() {

        synchronized (SingletonService.class){
            if (null == instance) instance = new SingletonService();
            return instance;
        }
    }

    public CompletionService<HashMap<Integer,Integer>> getService() {
        return service;
    }

}
