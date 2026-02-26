import java.util.ArrayList;
import java.util.Iterator;

public class BT_Ss1 {

    public static void main(String[] args) {

        ArrayList<Double> temps = new ArrayList<>();
        temps.add(36.5);
        temps.add(40.2);
        temps.add(37.0);
        temps.add(12.5);
        temps.add(39.8);
        temps.add(99.9);
        temps.add(36.8);

        System.out.println("Danh sách ban đầu: " + temps);

        Iterator<Double> it = temps.iterator();

        while (it.hasNext()) {
            double t = it.next();

            if (t < 34.0 || t > 42.0) {
                it.remove();
            }
        }

        System.out.println("Danh sách sau khi lọc: " + temps);

        double sum = 0;
        for (int i = 0; i < temps.size(); i++) {
            sum += temps.get(i);
        }

        double avg = sum / temps.size();

        System.out.printf("Nhiệt độ trung bình: %.2f\n", avg);
    }
}