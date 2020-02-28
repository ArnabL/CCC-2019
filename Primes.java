import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primes { // Prime Attempt 2

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        int loop = sc.nextInt();
        List<Integer> answer = new ArrayList<Integer>();

        for (int count = 0; count < loop; count++) {

            double num = sc.nextInt();
            double a, b;

            if (isPrime(num)) {
                answer.add((int) num);
                answer.add((int) num);
            } else {
                for (double i = 2; i < 2 * num; i++) {
                    a = i;
                    b = 2 * num - i;

                    if (isPrime(a) && isPrime(b) && (a + b) == (2 * num)) {
                        answer.add((int) a);
                        answer.add((int) b);
                        break;
                    }
                }

            }

        }// Count Loop
        for(int l = 0; l<answer.size();l +=2)
            System.out.println(answer.get(l)+" "+answer.get(l+1));


} // Main method

    public static boolean isPrime(double x) {
        for (int a = 2; a <= Math.sqrt(x); a++) {
            if (x % a == 0)
                return false;
        }

        return true;
    }
} // Class