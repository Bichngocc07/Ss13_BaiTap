import java.util.LinkedList;

public class BT_Ss4 {

    static class EmergencyRoom {
        private LinkedList<String> queue = new LinkedList<>();

        public void patientCheckIn(String name) {
            queue.addLast(name);
            System.out.println(name + " đã vào hàng chờ.");
        }

        public void emergencyCheckIn(String name) {
            queue.addFirst(name);
            System.out.println("CẤP CỨU: " + name + " được ưu tiên");
        }

        public void treatPatient() {
            if (queue.isEmpty()) {
                System.out.println("Không còn bệnh nhân.");
                return;
            }

            String patient = queue.removeFirst();
            System.out.println("Đang cấp cứu/khám: " + patient);
        }
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();

        er.patientCheckIn("A");
        er.patientCheckIn("B");

        er.emergencyCheckIn("C");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}