import java.time.LocalDate;

public class Proyecto {
    //Atributos
        private String codigoProyecto;
        private LocalDate fechaInicio;
        private LocalDate fechaEntrega;
        private String estado;
        private String metodoPago;
        private double pagoTotal;
        private ServicioAdicional listServicioAdicional;
        private Cliente theCliente;
    //Constructor
    public Proyecto(String codigo, LocalDate fechaInicio,LocalDate fechaEntrega,String estado, String metodoPago, double pagoTotal){
        this.codigoProyecto=codigo;
        this.fechaInicio=fechaInicio;
        this.fechaEntrega=fechaEntrega;
        this.estado=estado;
        this.metodoPago=metodoPago;
        this.pagoTotal=pagoTotal;
        
    }
    //gets and sets
    public String getCodigo() {
        return codigoProyecto;
    }

    public void setCodigo(String codigo) {
        this.codigoProyecto = codigo;
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
