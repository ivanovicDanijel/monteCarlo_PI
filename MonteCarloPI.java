package zadaciRazno;

import java.util.Random;

/**
   This program computes an estimate of pi by simulating dart throws onto a square.
   Ovaj program izra�unava procenu PI simuliraju�i bacanje strelica(pikado) u kvadrat.
*/

public class MonteCarloPI {
	
   public static void main(String[] args) {
	   
      final int TRIES = 10000;
      Random generator = new Random();

      int hits = 0;
      
      	for (int i = 1; i <= TRIES; i++) {
    	  
      		// Generate two random numbers between -1 and 1

      		double r = generator.nextDouble();
      		double x = -1 + 2 * r; 
      		r = generator.nextDouble();
      		double y = -1 + 2 * r;         

      		// Check whether the point lies in the unit circle

      		if (x * x + y * y <= 1) {
        	 
      			hits++;
      		}
         
      	}

      /*
         The ratio hits / tries is approximately the same
         as the ratio circle area / square area = pi / 4
         
         	Odnos Pogodaka / Poku�aja je pribli�no jednak
         	odnosu (povr�ine 1/4) Kruga / (povr�ine) Kvadrata = pi / 4
      */        

      double piEstimate = 4.0 * hits / TRIES;
      System.out.println("Estimate for pi: " + piEstimate);
      
   }
   
}

	// Estimate for pi: 3.152
