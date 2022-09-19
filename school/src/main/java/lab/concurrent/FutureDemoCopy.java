package lab.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemoCopy {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
//            executorService.submit(getRunnable(millis + i * add, i));
            Future<Integer> submit = executorService.submit(
                    () -> {
                        try {
                            System.out.println("Перед засыпанием = ");
                            Thread.sleep(100);
                            list1.add("1");
                            System.out.println("args = ");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        return 0;
                    });

            list.add(submit);
        }

        System.out.println("list1 = " + list1);

    }
}
