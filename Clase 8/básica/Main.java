package básica;

public class Main {
    public static void main(String[] args) {
        int edades [] = {15, 12, 23, 30};
        try{
            System.out.println("la edad de la posicion 4 es:" + edades[4]);
        }
        catch(Exception e){
            System.out.println("Intentaste acceder a un indice que no existe");
        }
    }
}

