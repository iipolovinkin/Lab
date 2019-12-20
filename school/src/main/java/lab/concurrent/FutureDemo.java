package lab.concurrent;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future f = executorService.submit(() -> {
            try {
                System.out.println("Перед засыпанием = ");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("args = ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        });

        try {
            System.out.println("f.isDone() = " + f.isDone());
            System.out.println("f.isCancelled() = " + f.isCancelled());
//            System.out.println("f.cancel() = " + f.cancel(true));
            System.out.println("f.get() = " + f.get());
            System.out.println("2 f.isDone() = " + f.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }
}
