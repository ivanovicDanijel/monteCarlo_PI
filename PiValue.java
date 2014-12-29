import java.util.ArrayList;
import java.util.concurrent.*;
public class MonteCarlo {

    public static class PiValue implements Callable {

        double pi, x, y, inside = 0, total = 0;

        public Double call() {
            for (double i = 0; i < 1000000; i++) {
                x = Math.random();
                y = Math.random();
                if (x * x + y * y <= 1) {
                    inside++;
                }
                total++;
            }
            pi = inside / total * 4;
            return pi;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        int NTHREADS = 10;
        ArrayList<Future<Double>> values = new ArrayList<Future<Double>>();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < NTHREADS; i++) {
            Callable<Double> callable = new PiValue();
            Future<Double> future = exec.submit(callable);
            values.add(future);
        }

        Double sum = 0.0;
        for (Future<Double> f : values) {
            sum = sum + f.get();
        }
        System.out.println(sum / (double)NTHREADS);
        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime-startTime)/1000);
    }
}
