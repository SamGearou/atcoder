package c043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Unhappy Hacking
public class UnhappyHacking {

    public static void main(String[] args) throws IOException {
        UnhappyHacking.solution();
    }

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        String str = scanner.next();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == 'B') {
                sb.deleteCharAt(i);
                if (i - 1 >= 0) {
                    sb.deleteCharAt(i - 1);
                    i = 0;
                }
            } else {
                i++;
            }
        }
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(sb);
        printWriter.close();
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
