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
        ListQuickpass eliminados = new ListQuickpass(20); // Lista de Quickpass eliminados
        HistorialAccesos historial = new HistorialAccesos(); 

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("********** MENU **********\n"
                    + "1. Agregar QuickPass\n"
                    + "2. Leer información de un QuickPass\n"
                    + "3. Actualizar un QuickPass\n"
                    + "4. Eliminar un QuickPass\n"
                    + "5. Mostrar todos los QuickPass activos\n"
                    + "6. Mostrar QuickPass eliminados\n"
                    + "7. Inactivar un QuickPass\n"
                    + "8. Validar acceso por código\n"
                    + "9. Consultar historial por filial\n"
                    + "10. Consultar historial por rango de fechas\n"
                    + "11. Consultar historial por código o placa\n"
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
                        // Preguntar qué campo desea actualizar
                        String opcActualizar = JOptionPane.showInputDialog("¿Qué desea actualizar?\n1. Placa\n2. Filial\n3. Código");

                        switch (opcActualizar) {
                            case "1": // Actualizar placa
                                String nuevaPlaca = JOptionPane.showInputDialog("Ingrese la nueva placa:");
                                quickpassActualizar.setPlaca(nuevaPlaca);
                                JOptionPane.showMessageDialog(null, "Placa actualizada con éxito.");
                                break;

                            case "2": // Actualizar filial
                                String nuevaFilial = JOptionPane.showInputDialog("Ingrese la nueva filial:");
                                quickpassActualizar.setFilial(nuevaFilial);
                                JOptionPane.showMessageDialog(null, "Filial actualizada con éxito.");
                                break;

                            case "3": // Actualizar código
                                String nuevoCodigo = JOptionPane.showInputDialog("Ingrese el nuevo código:");
                                quickpassActualizar.setCodigo(nuevoCodigo);
                                JOptionPane.showMessageDialog(null, "Código actualizado con éxito.");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "QuickPass no encontrado.");
                    }
                    break;

                case 4: // Eliminar un QuickPass
                    String opcionEliminar = JOptionPane.showInputDialog("¿Desea eliminar por:\n1. Código\n2. Placa");
                    if (opcionEliminar.equals("1")) {
                        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a eliminar:");
                        activos.eliminarPorCodigo(codigoEliminar, eliminados);
                    } else if (opcionEliminar.equals("2")) {
                        String placaEliminar = JOptionPane.showInputDialog("Ingrese la placa del QuickPass a eliminar:");
                        activos.eliminarPorPlaca(placaEliminar, eliminados);
                    }
                    break;

                case 5: // Mostrar todos los QuickPass activos
                    activos.mostrarQuickpass();
                    break;

                case 6: // Mostrar todos los QuickPass eliminados
                    eliminados.mostrarQuickpass();
                    break;

                case 7: // Inactivar un QuickPass
                    String codigoInactivar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a inactivar:");
                    activos.inactivarQuickpass(codigoInactivar);
                    break;

                case 8: // Validar acceso por código
                    String codigoValidar = JOptionPane.showInputDialog("Ingrese el código del QuickPass para validar acceso:");
                    String resultado = activos.validarAcceso(codigoValidar);
                    JOptionPane.showMessageDialog(null, "Acceso: " + resultado);
                    break;

                case 9: // Consultar historial por filial
                    String filialConsulta = JOptionPane.showInputDialog("Ingrese la filial para consultar los accesos:");
                    historial.consultarPorFilial(filialConsulta);
                    break;

                case 10: // Consultar historial por rango de fechas
                    String fechaInicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/MM/yyyy):");
                    String fechaFin = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/MM/yyyy):");
                    historial.consultarPorRangoFechas(fechaInicio, fechaFin);
                    break;

                case 11: // Consultar historial por código o placa
                    String identificador = JOptionPane.showInputDialog("Ingrese el código o placa a consultar:");
                    historial.consultarPorCodigoOPlaca(identificador);
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
