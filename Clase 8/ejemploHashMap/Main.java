package ejemploHashMap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>();

        empIds.put("Lucas", 12345);
        empIds.put("Carlos", 54321);
        empIds.put("Jorge", 8675309);

        System.out.println(empIds);

        System.out.println(empIds.get("Lucas"));

        System.out.println(empIds.containsKey("Jorge"));

        System.out.println(empIds.containsValue(12345));

        empIds.put("Lucas", 98765);
        System.out.println(empIds);

        empIds.replace("Khalil", 777);
        System.out.println(empIds);

        empIds.putIfAbsent("Juan", 222);
        System.out.println(empIds);
    }
}
