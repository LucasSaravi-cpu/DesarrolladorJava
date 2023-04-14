import java.sql.*;

public class Main {
    //Constantes de la base de datos
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\projects\\clase13\\conexion\\" + DB_NAME;
    //Constantes de la tabla CONTACTS
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    //Constantes de la tabla ORDERS
    public static final String TABLE_ORDERS = "orders";
    public static final String COLUMN_ORDER_ID = "id";
    public static final String COLUMN_CONTACT_NAME = "contact_name";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_QUANTITY = "quantity";

    public static void main(String[] args) {
        try {
            //Conección a traves del driver JDBC
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            //Elimino si existe una tabla CONTACTS y creo una nueva (no hace falta eliminarla pero si no,
            // hay que borrar las consultas para que no se repitan las acciones)
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                " (" + COLUMN_NAME + " text, " +
                                       COLUMN_PHONE + " integer, " +
                                       COLUMN_EMAIL + " text" +
                                ")");
            //Inserto registros dentro de la tabla CONTACTS
            insertContact(statement, "Tomas", 45676, "tomas@gmail.com");
            insertContact(statement, "Maxi", 45346, "maxi@gmail.com");
            insertContact(statement, "Dania", 42376, "dania@gmail.com");
            insertContact(statement, "Luz", 11676, "luz@gmail.com");

            //Elimino si existe una tabla ORDERS y creo una nueva (no hace falta eliminarla pero si no,
            // hay que borrar las consultas para que no se repitan las acciones)
            statement.execute("DROP TABLE IF EXISTS " + TABLE_ORDERS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_ORDERS +
                    " (" + COLUMN_ORDER_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CONTACT_NAME + " text, " +
                    COLUMN_PRODUCT_NAME + " text, " +
                    COLUMN_QUANTITY + " integer, " +
                    " FOREIGN KEY (" + COLUMN_CONTACT_NAME + ") REFERENCES " + TABLE_CONTACTS + " (" + COLUMN_NAME + "))");
            //Inserto registros dentro de la tabla ORDERS
            insertOrder(statement, "Tomas","'Smartphone'", 5);
            insertOrder(statement, "Maxi","'Laptop'", 1);
            insertOrder(statement, "Dania","'Tablet'",3);



            //Solicito traer todas las columnas de CONTACTS y en el while las muestro de a una x consola
//            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
//            System.out.println("\n2da consulta\n");
//            while (results.next()){
//                System.out.println(results.getString(COLUMN_NAME) + " " +
//                                    results.getInt(COLUMN_PHONE) + " " +
//                                    results.getString(COLUMN_EMAIL));
//            }

            //Consulta que involucra a ambas tablas con un JOIN:
//            ResultSet resultss = statement.executeQuery("SELECT " +
//                    TABLE_CONTACTS + "." + COLUMN_NAME + ", " +
//                    TABLE_CONTACTS + "." + COLUMN_PHONE + ", " +
//                    TABLE_ORDERS + "." + COLUMN_QUANTITY +
//                    " FROM " + TABLE_CONTACTS +
//                    " INNER JOIN " + TABLE_ORDERS +
//                    " ON " + TABLE_CONTACTS + "." + COLUMN_NAME + " = " + TABLE_ORDERS + "." + COLUMN_CONTACT_NAME);
//            while (resultss.next()){
//                System.out.println(resultss.getString(COLUMN_NAME) + " " +
//                        resultss.getInt(COLUMN_PHONE) + " " +
//                        resultss.getInt(COLUMN_QUANTITY));
//            }

            // Consulta que une las tablas contacts y orders mediante JOIN
            String query = "SELECT " + TABLE_CONTACTS + "." + COLUMN_NAME + ", " + TABLE_ORDERS + "." + COLUMN_PRODUCT_NAME +
                    ", " + TABLE_ORDERS + "." + COLUMN_QUANTITY +
                    " FROM " + TABLE_CONTACTS +
                    " JOIN " + TABLE_ORDERS +
                    " ON " + TABLE_CONTACTS + "." + COLUMN_NAME + " = " + TABLE_ORDERS + "." + COLUMN_CONTACT_NAME;

            // Ejecutamos la consulta y guardamos los resultados en una variable
            ResultSet resultsss = statement.executeQuery(query);

            // Iteramos sobre los resultados y los guardamos en variables
            String contactName, product;
            int quantity;
            while (resultsss.next()) {
                contactName = resultsss.getString(COLUMN_NAME);
                product = resultsss.getString(COLUMN_PRODUCT_NAME);
                quantity = resultsss.getInt(COLUMN_QUANTITY);
                System.out.println(contactName + " compró " + quantity + " " + product);
            }


            //Cerrando conexiones
            resultsss.close();
            statement.close();
            conn.close();

            System.out.println("\nConexión establecida");
        } catch (SQLException e) {
            System.out.println("Algo va mal: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador no encontrado: " + e.getMessage());
        }
    }
    //Función para agregar registros a la tabla CONTACTS
    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
    //Fnción para agregar registros a la tabla ORDERS
    private static void insertOrder(Statement statement, String contactName, String productName, int quantity) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_ORDERS +
                " (" + COLUMN_CONTACT_NAME + ", " +
                COLUMN_PRODUCT_NAME + ", " +
                COLUMN_QUANTITY +
                " ) " +
                "VALUES('" + contactName + "', " + productName + ", '" + quantity + "')");
    }

}
