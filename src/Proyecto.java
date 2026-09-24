public class Cliente {
    //Atributos
    private String nombre;
    private String cedula;
    private int telefono;
    private String correo;
    private String pais;
    private Proyecto listProyecto;
    //Contructor
    public Cliente(String nombre, String cedula, int telefono, String correo, String pais, Proyecto listProyecto){
        this.nombre=nombre;
        this.cedula=cedula;
        this.telefono=telefono;
        this.correo=correo;
        this.pais=pais;
        this.listProyecto=listProyecto;
    }
    //gets and sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
