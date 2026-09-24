public class Desarrollador {
    //Atributos
    private String nombreDesarrollador;
    private String codigoDesarrollador;
    private String nivel;
    private int cantidadProyectosSimultaneos;
    private double tarifaDia;
    private String estado;
    private String equipoTrabajo;
    private Proyecto [] listProyectos;
    //Constructor
    public Desarrollador(String nombreDesarrollador, String codigoDesarrollador, String nivel, int cantidadProyectosSimultaneos,double tarifaDia, String estado, String equipoTrabajo){
        this.nombreDesarrollador=nombreDesarrollador;
        this.codigoDesarrollador=codigoDesarrollador;
        this.nivel=nivel;
        this.cantidadProyectosSimultaneos=cantidadProyectosSimultaneos;
        this.tarifaDia=tarifaDia;
        this.estado=estado;
        this.equipoTrabajo=equipoTrabajo;
        listProyectos= new Proyecto[10];
    }
    //Gets and sets
    public String getNombreDesarrollador() {
        return nombreDesarrollador;
    }

    public void setNombreDesarrollador(String nombreDesarrollador) {
        this.nombreDesarrollador = nombreDesarrollador;
    }

    public String getCodigoDesarrollador() {
        return codigoDesarrollador;
    }

    public void setCodigoDesarrollador(String codigoDesarrollador) {
        this.codigoDesarrollador = codigoDesarrollador;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getCantidadProyectosSimultaneos() {
        return cantidadProyectosSimultaneos;
    }

    public void setCantidadProyectosSimultaneos(int cantidadProyectosSimultaneos) {
        this.cantidadProyectosSimultaneos = cantidadProyectosSimultaneos;
    }

    public double getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public Proyecto[] getListProyectos() {
        return listProyectos;
    }

    public void setListProyectos(Proyecto[] listProyectos) {
        this.listProyectos = listProyectos;
    }
}
