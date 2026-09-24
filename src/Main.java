import javax.swing.*;

public class Main {
    private static Empresa nuevaEmpresa;

    static void main() {

        nuevaEmpresa = new Empresa("DevPlus", "1102021","Universidad del quindio","305423444","DevPlus.com");

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Menu "+nuevaEmpresa.getNombre()+": " +
                    "\n Seleccione una opcion:" +
                    "\n 1. Menu cliente." +
                    "\n 2. Menu proyecto. " +
                    "\n 3. Menu desarrolladores" +
                    "\n 4. Menu servicios adicionales" +
                    "\n 5. Menu procesos internos" +
                    "\n 0. Salir del sistema"));

            switch (option) {

                case 1:
                    mostrarMenuClientes();
                    break;

                case 2:
                    mostrarMenuProyectos();
                    break;

                case 3:
                    mostrarMenuDesarrolladores();
                    break;

                case 4:
                    mostrarMenuSericiosAdicionales();
                    break;

                case 5:
                    mostrarMenuProcesosInternos();
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "El programa finalizo");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    break;
            }

        } while (option != 0);

    }
    public static void mostrarMenuClientes(){

        int option = 0;
            do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Menu clientes: " +
                    "\n Seleccione una opcion:" +
                    "\n 1. Crear cliente." +
                    "\n 2. Buscar cliente. " +
                    "\n 3. Actualizar clientes" +
                    "\n 4. Mostrar lista de clientes." +
                    "\n 5. Eliminar cliente." +
                    "\n 0. Volver al menu principal"));

            switch (option) {

                case 1:
                    solicitarInformacionCliente();
                    break;
                case 2:
                    solicitarCedulaCliente();
                    break;
                case 3:
                    solicitarInformacionActualizarCliente();
                    break;
                case 4:
                    mostrarListClientes();
                    break;
                case 5:
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Volver al menu principal");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    break;
            }

        } while (option != 0);
    }
    //Ingresar informacion cliente
    public static void solicitarInformacionCliente(){
        String cedula = JOptionPane.showInputDialog("Ingrese cedula cliente: ");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del cliente: "));
        String correo=JOptionPane.showInputDialog("Ingrese corrreo electronico del cliente:");
        String pais = JOptionPane.showInputDialog("Ingrese pais cliete: ");
        boolean resultado = nuevaEmpresa.registrarCliente(nombre,cedula, telefono,correo, pais);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "No se hizo el registro");
        }
    }
    //Mostrar la informacion del cliente
    private static void solicitarCedulaCliente() {
        String cedulaClienteMostrar = JOptionPane.showInputDialog("Ingrese la cedula del cliente que quiere ver: ");

        String resultado = nuevaEmpresa.mostrarCliente(cedulaClienteMostrar);

        JOptionPane.showMessageDialog(null, resultado);

    }
    //Actualizar la informacion de los clientes
    private static void solicitarInformacionActualizarCliente() {
        String cedulaClienteActualizar = JOptionPane.showInputDialog("Ingrese la cedula de cliente que quiere actualizar: ");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente:");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono del cliente: "));
        String correo = JOptionPane.showInputDialog("Ingrese correo electronico del cliente: ");
        String pais = JOptionPane.showInputDialog("Ingrese el pais de procedencia del cliente: ");

        boolean resultadoActualizacion = nuevaEmpresa.actualizarCliente(cedulaClienteActualizar,nombre, telefono,correo,pais);

        if(resultadoActualizacion){
            JOptionPane.showMessageDialog(null, "Se modifico el cliente.");
        }else{
            JOptionPane.showMessageDialog(null, "NO se pudo modificar el cliente.");
        }
    }
    //Mostrar lista de clientes
    public static void mostrarListClientes(){
        String mensaje= nuevaEmpresa.mostrarListClientes();
        JOptionPane.showMessageDialog(null,mensaje);

    }

    public static void mostrarMenuProyectos(){

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Menu proyectos: " +
                    "\n Seleccione una opcion:" +
                    "\n 1. Crear proyecto." +
                    "\n 2. Buscar proyecto. " +
                    "\n 3. Actualizar proyecto" +
                    "\n 4. Mostrar lista de proyecto." +
                    "\n 5. Eliminar proyecto." +
                    "\n 0. Volver al menu principal"));

            switch (option) {

                case 1:
                case 0:
                    JOptionPane.showMessageDialog(null, "Volver al menu principal");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    break;
            }

        } while (option != 0);

    }
    public static void mostrarMenuDesarrolladores(){

        int option = 0;
        do {
            option= Integer.parseInt(JOptionPane.showInputDialog("Menu clientes: " +
                    "\n Seleccione una opcion:" +
                    "\n 1. Crear cliente." +
                    "\n 2. Buscar cliente. " +
                    "\n 3. Actualizar clientes" +
                    "\n 4. Mostrar lista de clientes." +
                    "\n 5. Eliminar cliente." +
                    "\n 0. Volver al menu principal"));

            switch (option) {

                case 1:
                case 0:
                    JOptionPane.showMessageDialog(null, "Volver al menu principal");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    break;
            }

        } while (option!= 0);

    }
    public static void mostrarMenuSericiosAdicionales(){

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Menu clientes: " +
                    "\n Seleccione una opcion:" +
                    "\n 1. Crear cliente." +
                    "\n 2. Buscar cliente. " +
                    "\n 3. Actualizar clientes" +
                    "\n 4. Mostrar lista de clientes." +
                    "\n 5. Eliminar cliente." +
                    "\n 0. Volver al menu principal"));

            switch (option) {

                case 1:

                case 0:
                    JOptionPane.showMessageDialog(null, "Volver al menu principal");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    break;
            }

        } while (option != 0);

    }
    public static void mostrarMenuProcesosInternos(){

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Menu clientes: " +
                    "\n Seleccione una opcion:" +
                    "\n 1. Crear cliente." +
                    "\n 2. Buscar cliente. " +
                    "\n 3. Actualizar clientes" +
                    "\n 4. Mostrar lista de clientes." +
                    "\n 5. Eliminar cliente." +
                    "\n 0. Volver al menu principal"));

            switch (option) {

                case 1:
                case 0:
                    JOptionPane.showMessageDialog(null, "Volver al menu principal");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    break;
            }

        } while (option != 0);

    }
}
