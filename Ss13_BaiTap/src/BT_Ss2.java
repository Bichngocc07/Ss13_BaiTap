import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BT_Ss2 {

    public static List<String> removeDuplicateAndSort(List<String> input) {

        List<String> uniqueList = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            String drug = input.get(i);

            if (!uniqueList.contains(drug)) {
                uniqueList.add(drug);
            }
        }

        Collections.sort(uniqueList);

        return uniqueList;
    }

    public static void main(String[] args) {

        List<String> drugs = new ArrayList<>();
        drugs.add("Paracetamol");
        drugs.add("Ibuprofen");
        drugs.add("Panadol");
        drugs.add("Paracetamol");
        drugs.add("Aspirin");
        drugs.add("Ibuprofen");

        System.out.println("Input: " + drugs);

        List<String> result = removeDuplicateAndSort(drugs);

        System.out.println("Output: " + result);
    }
}