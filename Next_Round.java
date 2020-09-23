import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Next_Round {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        int count = 0;
        int tempScore = 0;
        int scoreAtKplace = 1;
        for (int i = 0; i < n; i++) {
            tempScore = reader.nextInt();
            if (i + 1 == k) {
                scoreAtKplace = tempScore;
            }
            if (tempScore >= scoreAtKplace && tempScore > 0) {
                count++;
                continue;
            }
            if (tempScore<scoreAtKplace){
                break;
            }
        }
        System.out.println(count);

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
