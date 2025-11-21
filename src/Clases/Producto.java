package Clases;

public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    private void setPrecio(double precio){
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }

    public Double getPrecio(){
        return precio;
    }

    public String mostrarInfo(){
        return "-------------------------\n" +
                "Nombre: " + nombre + "\n" +
                "Precio: " + precio + "$" + "\n"
                + "-------------------------\n";
    }


}
