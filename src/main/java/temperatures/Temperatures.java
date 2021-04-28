package temperatures;

public class Temperatures {

    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double avgPerYear = 0.0;
        for (byte actualData : data) {
           avgPerYear += actualData;
        }
        avgPerYear /= 365;
        return avgPerYear;
    }

    public double getMonthAverage() {
        double avgLast30Days = 0.0;
        for (int i = data.length - 30; i < data.length; i++) {
            avgLast30Days += data[i];
        }
        avgLast30Days /= 30;
        return avgLast30Days;
    }
}
