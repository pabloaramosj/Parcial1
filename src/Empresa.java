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
    //Undate Cliente
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

    //CRUD Desarrollador
    //Create Desarrollador
    public boolean registrarDesarrollador(String nombreDesarrollador,String codigoDesarrollador, int nivel){
        Desarrollador nuevoDesarrollador = new Desarrollador(nombreDesarrollador,codigoDesarrollador,nivel);
        if (encontrarIndexDesarrollador(nuevoDesarrollador.getCodigoDesarrollador())==-1){
            for(int i=0;i<listDesarrollador.length;i++){
                if (listDesarrollador[i]==null){
                    listDesarrollarores[i]=nuevoDesarrollador;
                    return true;
                }
            }
        }
        return false;
    }
    //Read Desarrollador
    public String mostrarDesarrolladores(String codigoDesarrolladores){
        String mensaje="";
        int index=encontrarIndexDesarrollador(codigoDesarrolladores);
        if (index !=-1){
            Desarrollador desarrolladorEncontrado= listDesarrollarores[index];
            mensaje+= "Cliente encontrado" +
                    "\nNombre: "+desarrolladorEncontrado.getNombreDesarrollador()+
                    "\nCodigo del Desarrollador: "+desarrolladorEncontrado.getCodigoDesarrollador()+
                    "\nNivel: "+desarrolladorEncontrado.getNivel()+
                    "\nProyectos simultaneos: "+desarrolladorEncontrado.getCantidadProyectosSimultaneos()+
                    "\nTarifa por dia: "+desarrolladorEncontrado.getTarifaDia()+
                    "\nEstado: "+desarrolladorEncontrado.getEstado()+
                    "\nEquipo de trabajo: "+desarrolladorEncontrado.getEquipoTrabajo();
        }else {
            mensaje+="Desarrollador no encontrado";
        }
        return mensaje;
    }
    //Read listDesarrolladores
    public String mostrarListDesarrolladores(){
        String mensaje="Lista de Desarrolladores";
        for(int i=0; i<listDesarrollarores.length;i++){
            if(listDesarrollarores[i]!=null){
                mensaje+=
                        "\nNombre: "+listDesarrollarores[i].getNombreDesarrollador()+
                                "\nCodigo: "+listDesarrollarores[i].getCodigoDesarrollador()+
                                "\nNivel: "+listDesarrollarores[i].getNivel()+
                                "\nProyectos simultaneos: "+listDesarrollarores[i].getCantidadProyectosSimultaneos()+
                                "\nTarifa por dia: "+listDesarrollarores[i].getTarifaDia()+
                                "\nEstado: "+listDesarrollarores[i].getEstado()+
                                "\nEquipo de trabajo: "+listDesarrollarores[i].getEquipoTrabajo();
            }
        }
        return mensaje;
    }
    //Update Desarrollador
    public boolean actualizarDesarrollador(String nombreDesarrolladorActualizar,String codigoDesarrolladorActualizar, int nivelActualizar, int cantidadProyectosSimultaneosActualizar, double tarifaDiaActualizar,int estadoActualizar,String equipoTrabajoActualizar){
        int index= encontrarIndexDesarrollador(codigoDesarrolladorActualizar);
        boolean respuesta=false;
        if(index != -1){
            listDesarrollarores[index].setNombreDesarrollador(nombreDesarrolladorActualizar);
            listDesarrollarores[index].setCodigoDesarrollador(codigoDesarrolladorActualizar);
            listDesarrollarores[index].setNivel(nivelActualizar);
            listDesarrollarores[index].setCantidadProyectosSimultaneos(cantidadProyectosSimultaneosActualizar);
            listDesarrollarores[index].setTarifaDia(tarifaDiaActualizar);
            listDesarrollarores[index].setEstado(estadoActualizar);
            listDesarrollarores[index].setEquipoTrabajo(equipoTrabajoActualizar);
            respuesta=true;
        }
        return respuesta;
    }
    //Delete Desarrollador
    public boolean eliminarDesarrollador(String codigoDesarrolladorEliminar){
        boolean respuesta= false;
        int index=encontrarIndexDesarrollador(codigoDesarrolladorEliminar);
        if (index != -1){
            listDesarrollarores[index]=null;
            respuesta=true;
        }
        return respuesta;
    }
    // index Desarrollador
    public int encontrarIndexDesarrollador(String codigoDesarrollador){
        for(int i=0; i<listDesarrollarores.length;i++){
            if (listDesarrollarores[i]!=null && listDesarrollarores[i].getCodigoDesarrollador().equals(codigoDesarrollador)){
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

