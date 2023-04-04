package ejemploHashSet;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> nombres = new HashSet<>();

        nombres.add("Lucas");
        nombres.add("Lucia");
        nombres.add("Juli");
        nombres.add("Fernando");
        nombres.add("Sofia");

        System.out.println(nombres);

        nombres.add("Lucas");
        System.out.println(nombres);

        nombres.remove("Juli");
        System.out.println(nombres);
        //No podemos eliminarlo por su posición
        nombres.remove(0);
        System.out.println(nombres);
        //System.out.println(nombres);
        System.out.println(nombres.size());

        System.out.println(nombres.contains("Gustavo"));

        System.out.println(nombres.isEmpty());




    }
}
