import java.time.LocalDate;

public class Proyecto{
    //Atributos
    private String codigo;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private String estado;
    private String metodoPago;
    private double pagoTotal;
    private Cliente theCliente;
    private Desarrollador [] listDesarrolladores;
    private ServicioAdicional [] listServiciosAdicionales;
    //Constructor
    public Proyecto(String codigo, LocalDate fechaInicio,LocalDate fechaEntrega,String estado, String metodoPago, double pagoTotal){
        this.codigo=codigo;
        this.fechaInicio=fechaInicio;
        this.fechaEntrega=fechaEntrega;
        this.estado=estado;
        this.metodoPago=metodoPago;
        this.pagoTotal=pagoTotal;
        listDesarrolladores= new Desarrollador[10];
        listServiciosAdicionales= new ServicioAdicional[10];
    }
    //gets and sets
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public Cliente getTheCliente() {
        return theCliente;
    }

    public void setTheCliente(Cliente theCliente) {
        this.theCliente = theCliente;
    }

    public Desarrollador[] getListDesarrolladores() {
        return listDesarrolladores;
    }

    public void setListDesarrolladores(Desarrollador[] listDesarrolladores) {
        this.listDesarrolladores = listDesarrolladores;
    }

    public ServicioAdicional[] getListServiciosAdicionales() {
        return listServiciosAdicionales;
    }

    public void setListServiciosAdicionales(ServicioAdicional[] listServiciosAdicionales) {
        this.listServiciosAdicionales = listServiciosAdicionales;
    }
}
    }

    public String getEstado() {
        return estado;
    }
