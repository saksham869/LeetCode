class Solution {
    static final int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        int primeCount = countPrimes(n);
        long result = (factorial(primeCount) * factorial(n - primeCount)) % MOD;
        return (int) result;
    }

    // Function to count number of primes <= n using Sieve of Eratosthenes
    private int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    // Function to compute factorial modulo MOD
    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
