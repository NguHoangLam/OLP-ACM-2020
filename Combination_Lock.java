
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Combination_Lock {
	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder storeRes = new StringBuilder();
		int[] storeNumber = new int[4];
		int sum;
		while (true) {
			sum = 0;
			for (int i = 0; i < 4; i++) {
				storeNumber[i] = reader.nextInt();
				sum += storeNumber[i];
			}
			if (sum == 0) {
				break;
			}
			sum = 1080;
			for (int i = 1; i < 4; i++) {
				if (i % 2 != 0) {
					
						sum += (storeNumber[i - 1] + 40 - storeNumber[i])%40*9;
					
				} else {
					
						sum += (storeNumber[i] + 40 - storeNumber[i - 1])%40*9;
					
				}
			}
			storeRes.append(sum + "\n");
		}
		System.out.println(storeRes);

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
