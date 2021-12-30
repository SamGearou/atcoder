import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Iroha's Obsession
public class IrohasObsession {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        HashSet<Integer> forbidden = new HashSet<>();
        for (int i = 0; i < k; i++) {
            forbidden.add(scanner.nextInt());
        }
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(findMinNum(n, sb, 0, forbidden));
        printWriter.close();
    }

    private static String findMinNum(int n, StringBuilder sb, int i, Set<Integer> forbidden) {
        if (i >= sb.length()) {
            return sb.toString();
        }
        int digit = Integer.parseInt(sb.charAt(i) + "");
        StringBuilder temp = new StringBuilder();
        temp.append(sb);
        temp.setCharAt(i, '0');
        if (Integer.parseInt(temp.toString()) > n && i > 0) {
            digit = 0;
        }
        while (forbidden.contains(digit)) {
            digit++;
        }
        if (digit == 10) {
            i--;
            while (i >= 0 && sb.charAt(i) == '9') {
                i--;
            }
            if (i == -1) {
                sb.append("0");
                i = 0;
                sb.setCharAt(i, '1');
            } else {
                sb.setCharAt(i, (char) (sb.charAt(i) + 1));
            }
            return findMinNum(n, sb, i, forbidden);
        } else {
            sb.setCharAt(i, (digit + "").charAt(0));
            return findMinNum(n, sb, i + 1, forbidden);
        }
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

//Learnings: Think of edge cases very carefully here. Solution was correct eventually, but careful of stack overflows
