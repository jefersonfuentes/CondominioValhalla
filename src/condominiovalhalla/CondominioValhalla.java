package condominiovalhalla;

import javax.swing.JOptionPane;

/**
 * @author Andrew
 * @author Kendall
 * @author Janaikel
 */
public class CondominioValhalla {
    public static void main(String[] args) {
        // Crear las listas de Quickpass
        ListQuickpass activos = new ListQuickpass(10); // Lista de Quickpass activos
        ListQuickpass eliminados = new ListQuickpass(10); // Lista de Quickpass eliminados

    int opcion;
    do {
        opcion = Integer.parseInt(JOptionPane.showInputDialog("********** MENU **********\n"
                + "1. Agregar QuickPass\n"
                + "2. Leer información de un QuickPass\n"
                + "3. Actualizar un QuickPass\n"
                + "4. Eliminar un QuickPass\n"
                + "5. Mostrar todos los QuickPass activos\n"
                + "6. Mostrar QuickPass eliminados\n"
                + "0. Salir\n"
                + "Seleccione una opción:"));

        switch (opcion) {
            case 1: // Agregar QuickPass
                activos.agregarQuickpass();
                break;
            case 2: // Leer información de un QuickPass
                String codigo = JOptionPane.showInputDialog("Ingrese el código del QuickPass a buscar:");
                Quickpass quickpassEncontrado = activos.buscarQuickpass(codigo);
                if (quickpassEncontrado != null) {
                    JOptionPane.showMessageDialog(null, "Información del QuickPass:\n" + quickpassEncontrado);
                }
                break;
            case 3: // Actualizar un QuickPass
                String codigoActualizar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a actualizar:");
                Quickpass quickpassActualizar = activos.buscarQuickpass(codigoActualizar);
                if (quickpassActualizar != null) {
                    String nuevaPlaca = JOptionPane.showInputDialog("Ingrese la nueva placa:");
                    quickpassActualizar.setPlaca(nuevaPlaca);
                    JOptionPane.showMessageDialog(null, "Placa actualizada con éxito.");
                }
                break;
            case 4: // Eliminar un QuickPass
                JOptionPane.showMessageDialog(null, "En desarrollo.");
                break;
            case 5: // Mostrar todos los QuickPass activos
                activos.mostrarQuickpass();
                break;
            case 6: // Mostrar todos los QuickPass eliminados
                JOptionPane.showMessageDialog(null, "En desarrollo.");
                break;
            case 0: // Salir
                JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Hasta pronto!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
        }
        
        } while (opcion != 0);
    }
}
