import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF2 {

  public static int longNetworkProcess(int value) {
    System.out.println("Completable Thread Id = " + Thread.currentThread().getId());
    sleepALittle("Completable", 50000);
    return value * 10;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("Main Thread Id = " + Thread.currentThread().getId());
    System.out.println("Starting");

    // With CompletableFuture threads amount is 16
    // Without CompletableFuture threads amount is 15
    CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

    Integer a = completableFuture.supplyAsync(() -> longNetworkProcess(5))
        .thenApply(res -> res)
        .get();


    System.out.println("AAA " + a);

    System.out.println("Main Thread Id = " + Thread.currentThread().getId());
    System.out.println("CompletableFuture Called");

    System.out.println("Sleeping for a little bit");
    sleepALittle("Main", 100000);
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
