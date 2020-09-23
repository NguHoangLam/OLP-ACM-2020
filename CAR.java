import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CAR {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        ArrayList<Car> carList = new ArrayList<>();
        StringBuilder storeResult = new StringBuilder();
        for (int i = 0; i < n; i++) {
            carList.add(new Car(i + 1, reader.nextInt()));
        }
        for (int i = 0; i < n; i++) {
            carList.get(i).setRepairDay(reader.nextInt());
        }
        carList.sort((c1, c2) -> {
            int res = Double.compare(c1.divide, c2.divide);
            if (res == 0) {
                res = Long.compare(c2.paidMoney, c1.paidMoney);
                if (res == 0) {
                    res = Long.compare(c1.repairDay, c2.repairDay);
                }
            }
            return res;
        });
        long totalMoney = 0;
        long day = 0;
        Car tempCar;
        for (int i = 0; i < n; i++) {
            tempCar = carList.get(i);
            totalMoney += tempCar.paidMoney * (tempCar.repairDay + day);
            day += tempCar.repairDay;

            storeResult.append(tempCar.i_place + " ");
        }
        System.out.println(totalMoney);
        System.out.println(storeResult);


    }

    static class Car {
        public int i_place;
        public long paidMoney;
        public long repairDay;
        public double divide;

        public Car(int i_place, int paidMoney) {
            this.i_place = i_place;
            this.paidMoney = paidMoney;
        }

        public void setRepairDay(int repairDay) {
            this.repairDay = repairDay;
            this.divide = repairDay * 1.0 / paidMoney;
        }
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
