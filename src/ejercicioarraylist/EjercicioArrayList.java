package ejercicioarraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioArrayList {

    static Scanner scanner;
    static ArrayList<Contacto> contactos;
    
    public static void main(String[] args) {
        
        scanner = new Scanner(System.in);
        contactos = new ArrayList<>();
        int opcion;
        do{
            menu();
            opcion =  scanner.nextInt();
            
            switch(opcion){
                case 1:
                    mostrarContactos();
                    break;
                case 2:
                    anadirContacto();
                    break;
                case 3:
                    eliminarContacto();
                    break;
                case 4:
                    eliminarTodosContactos();
                    break;
                case 5:
                    buscarContacto();
                    break;
                default:
                    System.out.println("Ingresaste una opcion incorrecta, ingresa una opcion valida");
            }
            
            
            
        } while (opcion != 0);
        scanner.close();
        
    }
    
    public static void menu(){
        System.out.println("Agenda de Contactos");
        System.out.println("1. Mostrar todos los contactos");
        System.out.println("2. añadir un contacto");
        System.out.println("3. eliminar un contacto");
        System.out.println("4. eliminar todos los contactos");
        System.out.println("5. Buscar un contacto");
        System.out.println("0. Salir del programa");
        System.out.println();
        System.out.println("Ingrese una opcion");
    }

    static void mostrarContactos() {

        if(contactos.isEmpty()){
            System.out.println("La agenda no tiene contactos");
            System.out.println();
        }else{
            for (int i = 0; i < contactos.size(); i++) {
                Contacto contacto = contactos.get(i);
                System.out.printf("%d - nombre: %s, telefono: %s %n", 
                                    (i+1), contacto.getNombre(), contacto.getTelefono());
            }
  
        }
        System.out.println();
    }

    private static void anadirContacto() {
        System.out.println("Añadir contacto");
        System.out.println("Ingresa un nombre: ");
        String nombre =  scanner.next();
        System.out.println("Ingresa un telefono: ");
        String telefono =  scanner.next();
        // Forma 1
        // Contacto contacto = new Contacto(nombre, telefono);
        // contactos.add(contacto);
        // Forma 2
        contactos.add(new Contacto(nombre, telefono));
        System.out.println();
    }

    private static void eliminarContacto() {
        System.out.println("Eliminar contacto");
        System.out.println("Ingresa posicion: ");
        int posicion =  scanner.nextInt();
        posicion--;
        if(posicion < 0 || posicion >= contactos.size()){
            System.out.println("Posicion incorrecta");
        }else{
            System.out.println("Esta seguro de eliminar el contacto?, SI => S, NO => N");
            String confirmar = scanner.next();
            if(confirmar.equalsIgnoreCase("s")){
                contactos.remove(posicion);
            }
        }
        
    }

    private static void eliminarTodosContactos() {
        System.out.println("Eliminar tods los contactos");
        System.out.println("Esta seguro de eliminar todos los contactos?, SI => S, NO => N");
        String confirmar = scanner.next();
        if(confirmar.equalsIgnoreCase("s")){
            contactos.clear();
        }
    }

    private static void buscarContacto() {
        System.out.println("Buscar un contacto");
        System.out.println("Ingresa el nombre: ");
        String nombre =  scanner.next();
        /*
        Contacto contacto = null;
        for (Contacto c : contactos){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                contacto = c;
                break;
            }
        }
        */
        
        Contacto contacto = contactos
                                    .stream()
                                    .filter(contact -> contact.getNombre().equalsIgnoreCase(nombre))
                                    .findFirst()
                                    .orElse(null);
        
        System.out.println(contacto);
        System.out.println();
    }
    
}
