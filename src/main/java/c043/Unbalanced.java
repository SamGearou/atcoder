package c043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// Unbalanced
public class Unbalanced {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        String str = scanner.next();
        HashMap<Character, Integer> prevInd = new HashMap<>();
        boolean foundAns = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (prevInd.containsKey(c) && (prevInd.get(c) == i - 1 || prevInd.get(c) == i - 2)) {
                PrintWriter printWriter = new PrintWriter(System.out);
                printWriter.println((prevInd.get(c) + 1) + " " + (i + 1));
                printWriter.close();
                foundAns = true;
                break;
            }
            prevInd.put(c, i);
        }
        if (!foundAns) {
            PrintWriter printWriter = new PrintWriter(System.out);
            printWriter.println("-1 -1");
            printWriter.close();
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
