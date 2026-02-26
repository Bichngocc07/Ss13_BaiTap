import java.util.ArrayList;

class PatientManager {

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
        for (Patient p : list) {
            if (p.getId().equals(id)) {
                list.remove(p);
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