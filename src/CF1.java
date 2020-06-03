import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF1 {

  public static int longNetworkProcess(int value) {
    System.out.println("Completable Thread Id = " + Thread.currentThread().getId());
    sleepALittle("Completable", 5000);
    return value * 10;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("Main Thread Id = " + Thread.currentThread().getId());
    System.out.println("Starting");

    // With CompletableFuture threads amount is 16
    // Without CompletableFuture threads amount is 15
    CompletableFuture.supplyAsync(() -> longNetworkProcess(5))
        .thenAccept(solution -> System.out.println("Completed " + solution))
        .thenRunAsync(() -> System.out.println("Then Run " + Thread.currentThread().getId()));

    System.out.println("Main Thread Id = " + Thread.currentThread().getId());
    System.out.println("CompletableFuture Called");

    System.out.println("Sleeping for a little bit");
    sleepALittle("Main", 10000);
    System.out.println("Sleeping done");
  }

  public static void sleepALittle(String where, int time) {
    try {
      System.out.println(where + " Thread Id = " + Thread.currentThread().getId());
      System.out.println("Sleeping");
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


}
