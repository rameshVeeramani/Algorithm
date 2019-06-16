import java.util.Scanner;

public class Main {

    // driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declare the variables
        int a, b, i, j ;
        boolean isPrime;

        // Ask user to enter lower value of interval
        a = 10;
        b = 10000;

        // Print display message
        System.out.printf("\nPrime numbers between %d and %d are:%n ", a, b);

        // Traverse each number in the interval
        // with the help of for loop


        for (i = a; i <= b; ++i) {
            if (i <=1  ) continue;;
            isPrime = true;
            for (j = 2; j <= i / 2; j++) {
             //   System.out.printf(" %d - %d = %d \n", i, j, i % j);
                if (i % j == 0) {
                    isPrime =false;
                }
            }
            if (isPrime == true)
                System.out.println(i);
        }
    }
}
