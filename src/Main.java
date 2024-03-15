import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Automovil> automoviles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Comparator<String> placaComparator = new PlacaComparator();

        String input;
        do {
            System.out.println("Ingrese los datos del automóvil (Marca, Modelo, Línea, Precio, Placa), o escriba SALIR para salir:");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("SALIR")) {
                String[] datos = input.split(",");
                if (datos.length == 5) {
                    Automovil automovil = new Automovil(datos[0].trim(), datos[1].trim(), datos[2].trim(), Double.parseDouble(datos[3].trim()), datos[4].trim());
                    automoviles.add(automovil);
                } else {
                    System.out.println("Formato incorrecto. Deben ser 5 datos separados por comas.");
                }
            }
        } while (!input.equalsIgnoreCase("SALIR"));

        System.out.println("Ingrese la placa del automóvil a buscar:");
        String placaBusqueda = scanner.nextLine();

        boolean encontrado = false;
        for (Automovil automovil : automoviles) {
            if (placaComparator.compare(automovil.getPlaca(), placaBusqueda) == 0) {
                System.out.println("Automóvil encontrado:");
                System.out.println("Marca: " + automovil.getMarca());
                System.out.println("Modelo: " + automovil.getModelo());
                System.out.println("Línea: " + automovil.getLinea());
                System.out.println("Precio: " + automovil.getPrecio());
                System.out.println("Placa: " + automovil.getPlaca());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El automóvil no existe.");
        }
    }
}
