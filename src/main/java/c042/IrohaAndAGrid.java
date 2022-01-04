package c042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Iroha and a Grid
public class IrohaAndAGrid {
    private static final long prime = 1_000_000_007;
    private static long[] fact;
    private static long[] inv;

    private static void solution() throws IOException {
        fact = new long[300_000];
        inv = new long[300_000];
        init();
        MyScanner scanner = new MyScanner();
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        long result = 0;
        for (int i = 0; i < H - A; i++) {
            int j = B - 1;
            result = (result + ((nChooseR(i + j, i) * nChooseR(H + W - i - j - 3, H - i - 1)) % prime)) % prime;
        }
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(result);
        printWriter.close();
    }

    public static long nChooseR(int a, int b) {
        return ((fact[a] * inv[b]) % prime * (inv[a - b] % prime)) % prime;
    }

    public static void init() {
        fact[0] = 1;
        inv[0] = expMod(fact[0], prime - 2);
        for (int i = 1; i < fact.length; i++) {
            fact[i] = (fact[i - 1] * i) % prime;
            inv[i] = expMod(fact[i], prime - 2);
        }
    }

    private static long expMod(long base, long exp) {
        long result = 1;
        base = base % prime;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % prime;
            }
            base = (base * base) % prime;
            exp >>= 1;
        }
        return result;
    }

    public static class MyScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer st;

        public MyScanner() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bufferedReader.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
