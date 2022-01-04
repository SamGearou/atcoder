package c043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Children and Candies
public class ChildrenAndCandies {

    private static void solution() throws IOException {
        MyScanner scanner = new MyScanner();
        int numCandies = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println((numCandies * (numCandies + 1)) / 2);
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
