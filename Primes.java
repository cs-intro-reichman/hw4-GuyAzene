public class Primes {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        int primes_count = 0;
        boolean[] primes = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            primes[i] = true;
        }

        int p = 2;

        while (p <= Math.sqrt(N)) {
            if (primes[p]) {
                for (int i = 2; i <= N; i++) {
                    if (i % p == 0 && i != p) {
                        primes[i] = false;
                    }
                }
            }
            p++;
        }

        System.out.println("Prime numbers up to " + N + ":");
        for (int i = 2; i <= N; i++) {
            if (primes[i]) {
                System.out.println(i);
                primes_count++;
            }
        }
        double primePercentage = (primes_count * 100.0) / N;
        System.out.println("There are " + primes_count + " primes between 2 and " + N + " (" + (int) primePercentage + "% are primes)");

    }
}