public class Empresa {
    // Atributos
    public String nombre;
    public String nit;
    public String direccion;
    public String telefono;
    public String paginaWeb;
    public Cliente [] listCliente;
    public Proyecto [] listProyectos;
    public Desarrollador [] listDesarrollarores;
    public ServicioAdicional [] listServiciosAdicionales;
    // Constructor
    public Empresa (String nombre, String nit, String direccion, String telefono, String paginaWeb){
        this.nombre=nombre;
        this.nit=nit;
        this.direccion=direccion;
        this.telefono=telefono;
        this.paginaWeb=paginaWeb;
        listCliente=new Cliente[10];
        listDesarrollarores=new Desarrollador[10];
        listProyectos=new Proyecto[10];
        listServiciosAdicionales=new ServicioAdicional[10];
    }
    //Metodos logicos
    //CRUD Cliente
    //Create Cliente
    public boolean registrarCliente(String nombre, String documento, int telefono, String correoElectronico, String pais){
        Cliente nuevoCliente = new Cliente(nombre,documento,telefono,correoElectronico,pais);
        if (encontrarIndexCliente(nuevoCliente.getCedula())==-1){
            for(int i=0;i<listCliente.length;i++){
                if (listCliente[i]==null){
                    listCliente[i]=nuevoCliente;
                    return true;
                }
            }
        }
        return false;
    }
    //Read Cliente
    public String mostrarCliente(String documentoCliente){
        String mensaje="";
        int index=encontrarIndexCliente(documentoCliente);
        if (index !=-1){
            Cliente clienteEncontrado= listCliente[index];
            mensaje+= "Cliente encontrado" +
                    "\nNombre: "+clienteEncontrado.getNombre()+
                    "\nCedula: "+clienteEncontrado.getCedula()+
                    "\nTelefono: "+clienteEncontrado.getTelefono()+
                    "\nCorreo electronico: "+clienteEncontrado.getCorreo()+
                    "\nPais: "+clienteEncontrado.getPais();
        }else {
            mensaje+="Cliente no encontrado";
        }
        return mensaje;
    }
    //Read listClientes
    public String mostrarListClientes(){
        String mensaje="Lista de clientes";
        for(int i=0; i<listCliente.length;i++){
            if(listCliente[i]!=null){
                mensaje+=
                        "\nNombre: "+listCliente[i].getNombre()+
                        "\nCedula: "+listCliente[i].getCedula()+
                        "\nTelefono: "+listCliente[i].getTelefono()+
                        "\nCorreo electronico: "+listCliente[i].getCorreo()+
                        "\nPais: "+listCliente[i].getPais();
            }
        }
        return mensaje;
    }
    //Unload Cliente
    public boolean actualizarCliente(String documentoClienteActualizar, String nombre, int telefono, String correo, String pais){
        int index= encontrarIndexCliente(documentoClienteActualizar);
        boolean respuesta=false;
        if(index != -1){
            listCliente[index].setNombre(nombre);
            listCliente[index].setTelefono(telefono);
            listCliente[index].setCorreo(correo);
            listCliente[index].setPais(pais);
            respuesta=true;
        }
        return respuesta;
    }
    //Deleate Cliente
    public boolean eliminarCliente(String documentoClienteEliminar){
        boolean respuesta= false;
        int index=encontrarIndexCliente(documentoClienteEliminar);
        if (index != -1){
            listCliente[index]=null;
            respuesta=true;
        }
        return respuesta;
    }
    // index Cliente
    public int encontrarIndexCliente(String documentoClienteBusca){
        for(int i=0; i<listCliente.length;i++){
            if (listCliente[i]!=null && listCliente[i].getCedula().equals(documentoClienteBusca)){
                return i;
            }
        }
        return -1;
    }
    // Gets and Sets

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Cliente[] getListCliente() {
        return listCliente;
    }

    public void setListCliente(Cliente[] listCliente) {
        this.listCliente = listCliente;
    }

    public Proyecto[] getListProyectos() {
        return listProyectos;
    }

    public void setListProyectos(Proyecto[] listProyectos) {
        this.listProyectos = listProyectos;
    }

    public Desarrollador[] getListDesarrollarores() {
        return listDesarrollarores;
    }

    public void setListDesarrollarores(Desarrollador[] listDesarrollarores) {
        this.listDesarrollarores = listDesarrollarores;
    }

    public ServicioAdicional[] getListServiciosAdicionales() {
        return listServiciosAdicionales;
    }

    public void setListServiciosAdicionales(ServicioAdicional[] listServiciosAdicionales) {
        this.listServiciosAdicionales = listServiciosAdicionales;
    }
}

