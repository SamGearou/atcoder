import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Iroha Loves Strings (ABC Edition)
public class IrohaLovesStrings {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        String[] sorted = new String[n];
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            sorted[i] = scanner.next();
        }
        Arrays.sort(sorted);
        StringBuilder ans = new StringBuilder();
        for (String str : sorted) {
            ans.append(str);
        }
        printWriter.println(ans);
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
