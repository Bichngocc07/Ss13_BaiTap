import java.util.ArrayList;
import java.util.Scanner;

public class BTTH_Ss13 {

    // ================= MODEL =================
    static class Patient {
        private String id;
        private String name;
        private int age;
        private String gender;
        private String disease;

        public Patient(String id, String name, int age, String gender, String disease) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.disease = disease;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getGender() { return gender; }
        public String getDisease() { return disease; }

        public void setName(String name) { this.name = name; }
        public void setAge(int age) { this.age = age; }
        public void setGender(String gender) { this.gender = gender; }
        public void setDisease(String disease) { this.disease = disease; }

        public void display() {
            System.out.println("ID: " + id +
                    " | Name: " + name +
                    " | Age: " + age +
                    " | Gender: " + gender +
                    " | Disease: " + disease);
        }
    }

    // ================= MANAGER =================
    static class PatientManager {
        private ArrayList<Patient> list = new ArrayList<>();

        public void addPatient(Patient p) {
            for (Patient pt : list) {
                if (pt.getId().equals(p.getId())) {
                    System.out.println("ID đã tồn tại!");
                    return;
                }
            }
            list.add(p);
            System.out.println("Thêm bệnh nhân thành công.");
        }

        public void removePatient(String id) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    list.remove(i);
                    System.out.println("Đã xóa bệnh nhân.");
                    return;
                }
            }
            System.out.println("Không tìm thấy bệnh nhân.");
        }

        public void updatePatient(String id, String name, int age, String gender, String disease) {
            for (Patient p : list) {
                if (p.getId().equals(id)) {
                    p.setName(name);
                    p.setAge(age);
                    p.setGender(gender);
                    p.setDisease(disease);
                    System.out.println("Cập nhật thành công.");
                    return;
                }
            }
            System.out.println("Không tìm thấy bệnh nhân.");
        }

        public void searchPatientByName(String keyword) {
            boolean found = false;
            for (Patient p : list) {
                if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    p.display();
                    found = true;
                }
            }
            if (!found)
                System.out.println("Không có bệnh nhân phù hợp.");
        }

        public void displayPatients() {
            if (list.isEmpty()) {
                System.out.println("Danh sách trống.");
                return;
            }
            for (Patient p : list)
                p.display();
        }
    }

    // ================= MAIN MENU =================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager manager = new PatientManager();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Xóa bệnh nhân");
            System.out.println("3. Cập nhật bệnh nhân");
            System.out.println("4. Tìm theo tên");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Giới tính: ");
                    String gender = sc.nextLine();
                    System.out.print("Bệnh lý: ");
                    String disease = sc.nextLine();
                    manager.addPatient(new Patient(id, name, age, gender, disease));
                    break;

                case 2:
                    System.out.print("Nhập ID cần xóa: ");
                    manager.removePatient(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhập ID cần sửa: ");
                    id = sc.nextLine();
                    System.out.print("Tên mới: ");
                    name = sc.nextLine();
                    System.out.print("Tuổi mới: ");
                    age = sc.nextInt(); sc.nextLine();
                    System.out.print("Giới tính mới: ");
                    gender = sc.nextLine();
                    System.out.print("Bệnh lý mới: ");
                    disease = sc.nextLine();
                    manager.updatePatient(id, name, age, gender, disease);
                    break;

                case 4:
                    System.out.print("Nhập tên cần tìm: ");
                    manager.searchPatientByName(sc.nextLine());
                    break;

                case 5:
                    manager.displayPatients();
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    return;
            }
        }
    }
}