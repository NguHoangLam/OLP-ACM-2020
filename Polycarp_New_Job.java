import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Polycarp_New_Job {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        StringBuilder storeResult = new StringBuilder();
        int maxX = 0;
        int maxY = 0;
        int store[] = new int[2];
        for (int i = 0; i < n; i++) {
            String query = reader.next();
            store[0] = reader.nextInt();
            store[1] = reader.nextInt();
            if (query.charAt(0) == '+') {
                Arrays.sort(store);
                maxX = store[0] > maxX ? store[0] : maxX;
                maxY = store[1] > maxY ? store[1] : maxY;
                continue;
            }
            if ((maxX <= store[0] && maxY <= store[1]) || (maxX <= store[1] && maxY <= store[0])) {
                storeResult.append("YES\n");
            } else {
                storeResult.append("NO\n");
            }
        }
        System.out.println(storeResult);


    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            String str;
            try {
                str = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
