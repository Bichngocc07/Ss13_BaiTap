import java.util.*;

public class BT_Ss5 {

    static class Patient {
        private String id;
        private String fullName;
        private int age;
        private String diagnosis;

        public Patient(String id, String fullName, int age, String diagnosis) {
            this.id = id;
            this.fullName = fullName;
            this.age = age;
            this.diagnosis = diagnosis;
        }

        public String getId() { return id; }
        public String getFullName() { return fullName; }
        public int getAge() { return age; }
        public String getDiagnosis() { return diagnosis; }
        public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

        @Override
        public String toString() {
            return "ID: " + id + " | FullName: " + fullName +
                    " | Age: " + age + " | Diagnosis: " + diagnosis;
        }
    }

    static class PatientService {
        private ArrayList<Patient> list = new ArrayList<>();

        public Patient findById(String id) {
            for (Patient p : list)
                if (p.getId().equals(id))
                    return p;
            return null;
        }

        public void addPatient(Patient p) {
            if (findById(p.getId()) != null) {
                System.out.println("ID đã tồn tại!");
                return;
            }
            list.add(p);
            System.out.println("Thêm thành công.");
        }

        public void updateDiagnosis(String id, String newDiagnosis) {
            Patient p = findById(id);
            if (p == null) {
                System.out.println("Không tìm thấy bệnh nhân.");
                return;
            }
            p.setDiagnosis(newDiagnosis);
            System.out.println("Cập nhật thành công.");
        }

        public void removePatient(String id) {
            Patient p = findById(id);
            if (p == null) {
                System.out.println("Không tìm thấy bệnh nhân.");
                return;
            }
            list.remove(p);
            System.out.println("Đã xuất viện.");
        }

        public void sortPatients() {
            Collections.sort(list, new Comparator<Patient>() {
                @Override
                public int compare(Patient a, Patient b) {
                    if (a.getAge() != b.getAge())
                        return b.getAge() - a.getAge(); // tuổi giảm dần
                    return a.getFullName().compareToIgnoreCase(b.getFullName());
                }
            });
            System.out.println("Đã sắp xếp.");
        }

        public void display() {
            if (list.isEmpty()) {
                System.out.println("Danh sách trống.");
                return;
            }
            for (Patient p : list)
                System.out.println(p);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tiếp nhận bệnh nhân");
            System.out.println("2. Cập nhật chẩn đoán");
            System.out.println("3. Xuất viện");
            System.out.println("4. Sắp xếp danh sách");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Thoát");
            System.out.println("Chọn chức năng :");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Chẩn đoán: ");
                    String diag = sc.nextLine();

                    service.addPatient(new Patient(id, name, age, diag));
                    break;

                case 2:
                    System.out.print("Nhập ID: ");
                    id = sc.nextLine();
                    System.out.print("Chẩn đoán mới: ");
                    diag = sc.nextLine();
                    service.updateDiagnosis(id, diag);
                    break;

                case 3:
                    System.out.print("Nhập ID xuất viện: ");
                    id = sc.nextLine();
                    service.removePatient(id);
                    break;

                case 4:
                    service.sortPatients();
                    break;

                case 5:
                    service.display();
                    break;

                case 6:
                    return;
            }
        }
    }
}