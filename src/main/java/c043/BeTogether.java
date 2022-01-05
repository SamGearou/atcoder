package c043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Be Together
public class BeTogether {

    public static void main(String[] args) throws IOException {
        BeTogether.solution();
    }

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = -100; i <= 100; i++) {
            min = Math.min(min, findCost(i, arr));
        }
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(min);
        printWriter.close();
    }

    private static int findCost(int num, int[] arr) {
        int totalCost = 0;
        for (int x : arr) {
            totalCost += (Math.abs(x - num) * Math.abs(x - num));
        }
        return totalCost;
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
