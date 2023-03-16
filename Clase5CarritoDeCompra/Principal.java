package Clase5CarritoDeCompra;

public class Principal {
	
	
	    public static void main(String[] args) {
	        // Creamos algunos productos
	        Producto producto1 = new Producto("Camisa", 29.99, 2);
	        Producto producto2 = new Producto("Pantalón", 39.99, 1);
	        Producto producto3 = new Producto("Zapatos", 59.99, 1);

	        // Creamos un carrito de compras
	        Carrito carrito = new Carrito();

	        // Agregamos algunos productos al carrito
	        carrito.agregarItem(producto1, 1);
	        carrito.agregarItem(producto2, 2);
	        carrito.agregarItem(producto3, 1);

	        // Mostramos los items del carrito y su precio total
	        System.out.println("Items del carrito:");
	        for (ItemCarrito item : carrito.getItems()) {
	            System.out.println(item.getProducto().getNombre() + " x " + item.getCantidad() + " = $" + item.getPrecioTotal());
	        }
	        System.out.println("Precio total: $" + carrito.getPrecioTotal());

	        // Creamos un descuento por cantidad
	        DescuentoPorCantidad descuentoPorCantidad = new DescuentoPorCantidad("Descuento por cantidad", 10, 2);

	        // Verificamos si aplica el descuento por cantidad
	        int cantidadTotal = 0;
	        for (ItemCarrito item : carrito.getItems()) {
	            cantidadTotal += item.getCantidad();
	        }
	        if (descuentoPorCantidad.aplicaDescuento(cantidadTotal)) {
	            double precioConDescuento = descuentoPorCantidad.aplicarDescuento(carrito.getPrecioTotal());
	            System.out.println("Descuento aplicado: " + descuentoPorCantidad.getNombre() + " (cantidad mínima: " + descuentoPorCantidad.getCantidadMinima() + ")");
	            System.out.println("Precio con descuento: $" + precioConDescuento);
	        }

	        // Creamos un descuento por monto
	        DescuentoPorMonto descuentoPorMonto = new DescuentoPorMonto("Descuento por monto", 15, 100);

	        // Verificamos si aplica el descuento por monto
	        if (descuentoPorMonto.aplicaDescuento(carrito.getPrecioTotal())) {
	            double precioConDescuento = descuentoPorMonto.aplicarDescuento(carrito.getPrecioTotal());
	            System.out.println("Descuento aplicado: " + descuentoPorMonto.getNombre() + " (monto mínimo: $" + descuentoPorMonto.getMontoMinimo() + ")");
	            System.out.println("Precio con descuento: $" + precioConDescuento);
	        }
	    }
	}

/*

//Ejercicio 5b carga los datos por un txt y devuelve el precio total de esos productos cargados
Carrito carrito = new Carrito();
	    	try {
	            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Principal\\Desktop\\Curso Desarrollador de java\\Clase 5\\precios.txt"));
	            
	            
	               
	         
	            String line = reader.readLine();
	            
	           
	            while ((line = reader.readLine()) != null) {
	            	
  	           String[] parts = line.split(",");
	            
	           
	   	        int cant = Integer.parseInt(parts[0]);
	   	        double precio = Double.parseDouble(parts[1]);
	   	        String produ = parts[2];
	  
	   	        //   Creamos algunos productos que se van creando por linea a medida que va pasando el while
	   	      Producto producto = new Producto(produ, precio, cant);
	      			            
	   	   

	        // Agregamos los productos al carrito que se van creando a medida que pasa el while
	        carrito.agregarItem(producto, cant);
	   	      
	   	 		  
	            }
			 
	            System.out.println("Precio total: $" + carrito.getPrecioTotal());
	           
	            reader.close();
	           
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo");
	        }



*/
