import javax.swing.*;
import java.net.ProxySelector;
import java.time.LocalDate;

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
        listServiciosAdicionales[0]=new ServicioAdicional("SP1","Soporte tecnico","Dar soporte tecnico",200000,false);
        listServiciosAdicionales[1]=new ServicioAdicional("SP2","Capacitacion de usuarios","Dar capacitaciones",200000,false);
        listServiciosAdicionales[2]=new ServicioAdicional("SP3","Despliegue en la nube","Dar despliege de los recusos a la nube",200000,false);
        listServiciosAdicionales[3]=new ServicioAdicional("SP4","Migracion de datos","Dar migracion migracion de datos",200000,false);
    }

    //Metodos logicos
    //CRUD Cliente
    //Create Cliente
    public boolean registrarCliente(String nombre, String cedula, int telefono, String correoElectronico, String pais){
        Cliente nuevoCliente = new Cliente(nombre,cedula,telefono,correoElectronico,pais);
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
    //CRUD Proyecto
    //Create Proyecto
    public boolean registrarProyecto(String documentoClienteProyecto,LocalDate fechaInicio, LocalDate fechaEntrega, int metodoPago){
        LocalDate fechaSolicitud=LocalDate.now();

        int index=encontrarIndexCliente(documentoClienteProyecto);
        if(index != -1){
            Cliente theCliente= listCliente[index];
            Proyecto nuevoProyecto= new Proyecto(null,fechaSolicitud,fechaInicio,fechaEntrega,1,metodoPago,0);

            for(int i=0;i<listProyectos.length;i++){
                if (listProyectos[i]==null){
                    nuevoProyecto.setCodigo("P"+i+1);
                    nuevoProyecto.setTheCliente(theCliente);
                    listProyectos[i]=nuevoProyecto;
                    return true;
                }
            }
        }
        return false;
    }


    //Read Proyecto
    public String mostrarProyecto(String cedulaCliente){

        String mensaje="";
        int index=-1;
        for(int i=0; i<listProyectos.length;i++){
            if (listProyectos[i]!=null && listProyectos[i].getTheCliente().getCedula().equals(cedulaCliente)){
                Proyecto proyectoEncontrado= listProyectos[i];
                mensaje+= "Proyecto encontrado" +
                        "\nCliente: "+proyectoEncontrado.getTheCliente().getNombre()+
                        "\nCodigo: "+proyectoEncontrado.getCodigo()+
                        "\nFecha solicitud: "+proyectoEncontrado.getFechaSolicitud()+
                        "\nFecha inicio: "+proyectoEncontrado.getFechaInicio()+
                        "\nFecha entrega: "+proyectoEncontrado.getFechaEntrega()+
                        "\nEstado "+proyectoEncontrado.getEstado()+
                        "\nMetodo de pago: "+proyectoEncontrado.getMetodoPago()+
                        "\nValor total: "+proyectoEncontrado.getPagoTotal()+
                        "\nDesarolladores: "+proyectoEncontrado.getListDesarrolladores();
                index=i;
            }
        }
        if (index ==-1){
            mensaje+="Proyecto no encontrado";
        }
        return mensaje;
    }
    //Read listProyectos
    public String mostrarListProyectos(){
        String mensaje="Lista de proyectos";
        for(int i=0; i<listProyectos.length;i++){
            if(listProyectos[i]!=null){
                mensaje+="\nCodigo: "+listProyectos[i].getCodigo()+
                        " \nFecha solicitud: "+listProyectos[i].getFechaSolicitud()+
                        " \nFecha inicio: "+listProyectos[i].getFechaInicio()+
                        " \nFecha entrega: "+listProyectos[i].getFechaEntrega()+
                        " \nEstado: "+listProyectos[i].getEstado()+
                        " \nMetodo de pago: "+listProyectos[i].getMetodoPago()+
                        " \nValor total: "+listProyectos[i].getPagoTotal();
            }
        }
        return mensaje;
    }
    //Undate Proyecto
    public boolean actualizarEstadoProyecto(String codigoProyectoActualizar, int estado){
        int index= encontrarIndexProyecto(codigoProyectoActualizar);
        boolean respuesta=false;
        if(index != -1){
            listProyectos[index].setEstado(estado);
            respuesta=true;
        }
        return respuesta;
    }
    public  boolean actualizarFechasProyecto(String codigo, LocalDate fechaInicio, LocalDate fechaEntrega){
        int index= encontrarIndexProyecto(codigo);
        boolean respuesta=false;
        if(index != -1){
            if(fechaInicio!=null){
                listProyectos[index].setFechaInicio(fechaInicio);
            }
            if(fechaEntrega!=null){
                listProyectos[index].setFechaEntrega(fechaEntrega);
            }
            respuesta=true;
        }
        return respuesta;
    }
    public boolean actualizarMetodoPago(String codigo, int metodoPago){
        int index= encontrarIndexProyecto(codigo);
        boolean respuesta=false;
        if(index != -1){
            listProyectos[index].setMetodoPago(metodoPago);
            respuesta=true;
        }
        return respuesta;
    }
    //Deleate Proyecto
    public boolean eliminarProyecto(String codigo){
        int index= encontrarIndexProyecto(codigo);
        boolean respuesta=false;
        if(index != -1){
            listProyectos[index]=null;
            respuesta=true;
        }
        return respuesta;
    }
    // index Proyecto
    public int encontrarIndexProyecto(String codigoProyecto){
        for(int i=0; i<listProyectos.length;i++){
            if (listProyectos[i]!=null && listProyectos[i].getCodigo().equals(codigoProyecto)){
                return i;
            }
        }
        return -1;
    }
    //CRUD Desarrollador
    //Create Desarrollador
    public boolean registrarDesarrollador(String nombreDesarrollador,String codigoDesarrollador, int nivel ){
        Desarrollador nuevoDesarrollador = new Desarrollador(nombreDesarrollador,codigoDesarrollador,nivel,0,0, 0,null);
        nuevoDesarrollador=actulizarNivelDesarrollador(nuevoDesarrollador);
        if (encontrarIndexDesarrollador(nuevoDesarrollador.getCodigoDesarrollador())==-1){
            for(int i=0;i<listCliente.length;i++){
                if (listCliente[i]==null){
                    listDesarrollarores[i]=nuevoDesarrollador;
                    return true;
                }
            }
        }
        return false;
    }

    public Desarrollador actulizarNivelDesarrollador(Desarrollador nuevoDesarrollador){
        double TARIFADIAESTADAR =70000;
        if (nuevoDesarrollador.getNivel()==1){
            nuevoDesarrollador.setTarifaDia(TARIFADIAESTADAR);
            nuevoDesarrollador.setCantidadProyectosSimultaneos(1);
        }if (nuevoDesarrollador.getNivel()==2){
            nuevoDesarrollador.setTarifaDia(2*TARIFADIAESTADAR);
            nuevoDesarrollador.setCantidadProyectosSimultaneos(2);
        }if (nuevoDesarrollador.getNivel()==3){
            nuevoDesarrollador.setTarifaDia(3*TARIFADIAESTADAR);
            nuevoDesarrollador.setCantidadProyectosSimultaneos(3);
        }
        return nuevoDesarrollador;
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
    public boolean asiganarDesarrolladoresProyecto(int cantidad,String codigoProyecto){
        Desarrollador []nuevoDesarradorProyecto= new Desarrollador[cantidad];

        for (int i=0; i< cantidad;i++){
            int respuesta=1;
            do{
                String codigoDesarrollador= JOptionPane.showInputDialog("Ingrese codigo desarrollador "+i+1);
                int index=encontrarIndexDesarrollador(codigoDesarrollador);
                if(index!=-1){
                    if(listDesarrollarores[index].getEstado()!=2 ||listDesarrollarores[index].getEstado()!=3){
                        nuevoDesarradorProyecto[i]=listDesarrollarores[index];

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"El desarrollador esta ocupado o en capacitacion");
                    }
                    respuesta=3;
                }else {
                    JOptionPane.showMessageDialog(null,"Error en el codido del desarrollador");
                    respuesta++;
                }
            }while (respuesta!=3);
        }int index=encontrarIndexProyecto(codigoProyecto);
        if (index!=-1){
                listProyectos[index].setListDesarrolladores(nuevoDesarradorProyecto);
                return true;
        }
        return false;
    }

    //CRUD Servicios adiciones
    //Create servicios adicionales

    public boolean ingresarServiciosAdicionaleso(String codigoServicio,String nombre, String descripcion,double precio, boolean disponibilidad){
        int index=encontrarIndexServiciosAdicionales(codigoServicio);
        if(index != -1){
            ServicioAdicional nuevoServicioadicional= new ServicioAdicional(codigoServicio,nombre,descripcion,precio,disponibilidad);
            for(int i=0;i<listProyectos.length;i++){
                if (listProyectos[i]==null){
                    nuevoServicioadicional.setCodigoServicio(codigoServicio);
                    nuevoServicioadicional.setNombre(nombre);
                    nuevoServicioadicional.setDescripcion(descripcion);
                    nuevoServicioadicional.setPrecio(precio);
                    nuevoServicioadicional.setDisponibilidad(disponibilidad);

                    return true;
                }
            }
        }
        return false;
    }
    //Read Proyecto
    public String mostrarServicioAdicional(String codigo){
        String mensaje="";
        int index=-1;
        for(int i=0; i<listServiciosAdicionales.length;i++){
            if (listServiciosAdicionales[i]!=null && listServiciosAdicionales[i].getCodigoServicio().equals(codigo)){
                ServicioAdicional servicioAdicionalEncontrado= listServiciosAdicionales[i];
                mensaje+= "Servicio" +
                        "\nCodigo: "+servicioAdicionalEncontrado.getCodigoServicio()+
                        "\nNombre: "+servicioAdicionalEncontrado.getNombre()+
                        "\nDescripcion: "+servicioAdicionalEncontrado.getDescripcion()+
                        "\nPrecio: "+servicioAdicionalEncontrado.getPrecio()+
                        "\nDeisponibilidad: "+servicioAdicionalEncontrado.getDisponibilidad();
                index=i;
            }
        }
        if (index ==-1){
            mensaje+="Proyecto no encontrado";
        }
        return mensaje;
    }
    //Read listProyectos
    public String mostrarListServicios(){
        String mensaje="Lista de Servicios";
        for(int i=0; i<listServiciosAdicionales.length;i++){
            if(listServiciosAdicionales[i]!=null){
                mensaje+= "Servicio" +
                        "\nCodigo: "+listServiciosAdicionales[i].getCodigoServicio()+
                        "\nNombre: "+listServiciosAdicionales[i].getNombre()+
                        "\nDescripcion: "+listServiciosAdicionales[i].getDescripcion()+
                        "\nPrecio: "+listServiciosAdicionales[i].getPrecio()+
                        "\nDeisponibilidad: "+listServiciosAdicionales[i].getDisponibilidad();
            }
        }
        return mensaje;
    }
    //Undate Servicio
    public boolean actualizarServicio(String codigo,String nombre, String descripccion, double precio, boolean disponibilidad){
           int index= encontrarIndexServiciosAdicionales(codigo);
            boolean respuesta=false;
            if(index != -1){
                listServiciosAdicionales[index].setNombre(nombre);
                listServiciosAdicionales[index].setDescripcion(descripccion);
                listServiciosAdicionales[index].setPrecio(precio);
                listServiciosAdicionales[index].setDescripcion(descripccion);
              respuesta=true;
            }
            return respuesta;
        }
        //Delete Desarrollador
        public boolean eliminarServicio(String codigo){
            boolean respuesta= false;
            int index=encontrarIndexServiciosAdicionales(codigo);
            if (index != -1){
                listServiciosAdicionales[index]=null;
                respuesta=true;
            }
            return respuesta;
        }

    //index Servicio adicional
    public int encontrarIndexServiciosAdicionales(String codigoServiciosAdicionales){
        for(int i=0; i<listServiciosAdicionales.length;i++){
            if (listServiciosAdicionales[i]!=null && listServiciosAdicionales[i].getCodigoServicio().equals(codigoServiciosAdicionales)){
                return i;
            }
        }
        return -1;
    }
    //valor total por fechas
    public double calcularValorTotalProyectoFecha(LocalDate fecha){
        double valorTotalProyectoFecha=0;
        for(int i=0; i<listProyectos.length;i++){
            if (listServiciosAdicionales[i]!=null && listProyectos[i].getFechaSolicitud().isEqual(fecha)){
                valorTotalProyectoFecha+=listProyectos[i].getPagoTotal();
            }
        }
        return valorTotalProyectoFecha;

    }
    public boolean mostrarNumeroTelefonicoPerfecto (String cedula) {
        int acumulador = 0;
        int index= encontrarIndexCliente(cedula);

        int numeroClienteMostrar =listCliente[index].getTelefono() ;
        for (int i = 1; i < numeroClienteMostrar; i++) {
            if (numeroClienteMostrar%i == 0) {
                acumulador+=i;
            }
        }
        if (acumulador == numeroClienteMostrar) {
            return true;
        }
        return false;
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
