public class ServicioAdicional {
    //Atributos
    private String codigoServicio;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean disponibilidad;
    private Proyecto theProyecto;
    //Constructor
    public ServicioAdicional(String codigoServicio, String nombre, String descripcion, double precio, boolean disponibilidad){
        this.codigoServicio=codigoServicio;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.disponibilidad=disponibilidad;
    }
    //gets and sets
    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Proyecto getTheProyecto() {
        return theProyecto;
    }

    public void setTheProyecto(Proyecto theProyecto) {
        this.theProyecto = theProyecto;
    }
}
