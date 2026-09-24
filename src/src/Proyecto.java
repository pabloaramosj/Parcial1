import java.time.LocalDate;

public class Proyecto{
    //Atributos
    private String codigo;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private int estado;
    private int metodoPago;
    private double pagoTotal;
    private Cliente theCliente;
    private Desarrollador [] listDesarrolladores;
    private ServicioAdicional [] listServiciosAdicionales;
    //Constructor
    public Proyecto(String codigo,LocalDate fechaSolicitud, LocalDate fechaInicio,LocalDate fechaEntrega,int estado, int metodoPago, double pagoTotal){
        this.codigo=codigo;
        this.fechaSolicitud=fechaSolicitud;
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

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
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