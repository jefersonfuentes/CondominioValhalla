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
                    + "2. Mostrar información QuickPass:\n"
                    + "3. Mostrar información QuickPass eliminados:\n"
                    + "4. Modificar un QuickPass\n"
                    + "5. Eliminar un QuickPass\n"
                    + "6. Inactivar un QuickPass\n"
                    + "7. Activar un QuickPass\n"
                    + "8. Registrar un acceso\n"
                    + "9. Consultar historial\n"
                    + "10. Consultar reportes\n"
                    + "0. Salir\n"
                    + "Seleccione una opción:"));

            switch (opcion) {
                case 1: // Agregar QuickPass
                    activos.agregarQuickpass();
                    break;

                case 2: // Mostrar información de QuickPass activos
                    int subopcionActivos = Integer.parseInt(JOptionPane.showInputDialog("2. Mostrar información QuickPass activos:\n"
                            + "   1. Mostrar Información de un QuickPass específico.\n"
                            + "   2. Mostrar todos los QuickPass activos.\n"
                            + "   3. Mostrar todos los QuickPass por filial.\n"
                            + "Seleccione una opción:"));
                    switch (subopcionActivos) {
                        case 1:
                            String codigoBuscar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a buscar:");
                            Quickpass encontrado = activos.buscarQuickpass(codigoBuscar);
                            if (encontrado != null) {
                                JOptionPane.showMessageDialog(null, "Información del QuickPass:\n" + encontrado);
                            }
                            break;
                        case 2:
                            activos.mostrarQuickpass();
                            break;
                        case 3:
                            String filialBuscarActivos = JOptionPane.showInputDialog("Ingrese la filial para listar QuickPass:");
                            activos.mostrarQuickpassPorFilial(filialBuscarActivos);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                    break;

                case 3: // Mostrar información de QuickPass eliminados
                    int subopcionEliminados = Integer.parseInt(JOptionPane.showInputDialog("3. Mostrar información QuickPass eliminados:\n"
                            + "   1. Mostrar Información de un QuickPass específico.\n"
                            + "   2. Mostrar todos los QuickPass eliminados.\n"
                            + "   3. Mostrar todos los QuickPass por filial.\n"
                            + "Seleccione una opción:"));
                    switch (subopcionEliminados) {
                        case 1:
                            String codigoBuscarEliminados = JOptionPane.showInputDialog("Ingrese el código del QuickPass a buscar:");
                            Quickpass encontradoEliminados = eliminados.buscarQuickpass(codigoBuscarEliminados);
                            if (encontradoEliminados != null) {
                                JOptionPane.showMessageDialog(null, "Información del QuickPass:\n" + encontradoEliminados);
                            }
                            break;
                        case 2:
                            eliminados.mostrarQuickpass();
                            break;
                        case 3:
                            String filialBuscarEliminados = JOptionPane.showInputDialog("Ingrese la filial para listar QuickPass:");
                            eliminados.mostrarQuickpassPorFilial(filialBuscarEliminados);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                    break;

                case 4: // Modificar un QuickPass
                    String codigoModificar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a modificar:");
                    Quickpass modificarQuickpass = activos.buscarQuickpass(codigoModificar);
                    if (modificarQuickpass != null) {
                        String campoModificar = JOptionPane.showInputDialog("¿Qué desea modificar?\n1. Placa\n2. Filial\n3. Código");
                        switch (campoModificar) {
                            case "1":
                                String nuevaPlaca = JOptionPane.showInputDialog("Ingrese la nueva placa:");
                                modificarQuickpass.setPlaca(nuevaPlaca);
                                JOptionPane.showMessageDialog(null, "Placa actualizada con éxito.");
                                break;
                            case "2":
                                String nuevaFilial = JOptionPane.showInputDialog("Ingrese la nueva filial:");
                                modificarQuickpass.setFilial(nuevaFilial);
                                JOptionPane.showMessageDialog(null, "Filial actualizada con éxito.");
                                break;
                            case "3":
                                String nuevoCodigo = JOptionPane.showInputDialog("Ingrese el nuevo código:");
                                modificarQuickpass.setCodigo(nuevoCodigo);
                                JOptionPane.showMessageDialog(null, "Código actualizado con éxito.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "QuickPass no encontrado.");
                    }
                    break;

                case 5: // Eliminar un QuickPass
                    String tipoEliminar = JOptionPane.showInputDialog("¿Desea eliminar por:\n1. Código\n2. Placa");
                    if (tipoEliminar.equals("1")) {
                        String codigoEliminar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a eliminar:");
                        activos.eliminarPorCodigo(codigoEliminar, eliminados);
                    } else if (tipoEliminar.equals("2")) {
                        String placaEliminar = JOptionPane.showInputDialog("Ingrese la placa del QuickPass a eliminar:");
                        activos.eliminarPorPlaca(placaEliminar, eliminados);
                    }
                    break;

                case 6: // Inactivar un QuickPass
                    String codigoInactivar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a inactivar:");
                    activos.inactivarQuickpass(codigoInactivar);
                    break;

                case 7: // Activar un QuickPass
                    String codigoActivar = JOptionPane.showInputDialog("Ingrese el código del QuickPass a activar:");
                    activos.activarQuickpass(codigoActivar);
                    break;

                case 8: // Registrar un acceso
                    String codigoRegistrar = JOptionPane.showInputDialog("Ingrese el código del QuickPass para registrar acceso:");
                    String resultado = activos.validarAcceso(codigoRegistrar);
                    JOptionPane.showMessageDialog(null, "Acceso: " + resultado);
                    break;

                case 9: // Consultar historial
                    int subopcionHistorial = Integer.parseInt(JOptionPane.showInputDialog("9. Consultar historial:\n"
                            + "   1. Consultar historial por filial.\n"
                            + "   2. Consultar historial por rango de fechas.\n"
                            + "   3. Consultar historial por código o placa.\n"
                            + "Seleccione una opción:"));
                    switch (subopcionHistorial) {
                        case 1:
                            String historialFilial = JOptionPane.showInputDialog("Ingrese la filial para consultar los accesos:");
                            historial.consultarPorFilial(historialFilial);
                            break;
                        case 2:
                            String fechaInicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/MM/yyyy):");
                            String fechaFin = JOptionPane.showInputDialog("Ingrese la fecha de fin (dd/MM/yyyy):");
                            historial.consultarPorRangoFechas(fechaInicio, fechaFin);
                            break;
                        case 3:
                            String identificador = JOptionPane.showInputDialog("Ingrese el código o placa a consultar:");
                            historial.consultarPorCodigoOPlaca(identificador);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                    break;
                    
                case 10: // Consultar Reporte
                    int subopcionReporte = Integer.parseInt(JOptionPane.showInputDialog("10. Consultar Reporte:\n"
                            + "   1. Total de accesos registrados.\n"
                            + "   2. Total de accesos por filial.\n"
                            + "   3. Total de QuickPass registrados.\n"
                            + "   4. Total de QuickPass activos e inactivos.\n"
                            + "   5. Total de QuickPass eliminados.\n"
                            + "Seleccione una opción:"));

                    switch (subopcionReporte) {
                        case 1: // Total de accesos registrados
                            int totalAccesos = activos.obtenerTotalAccesos();
                            JOptionPane.showMessageDialog(null, "Total de accesos registrados: " + totalAccesos);
                            break;

                        case 2: // Total de accesos por filial
                            String filialReporte = JOptionPane.showInputDialog("Ingrese la filial para contar accesos:");
                            int totalAccesosFilial = activos.obtenerTotalAccesosPorFilial(filialReporte);
                            JOptionPane.showMessageDialog(null, "Total de accesos registrados para la filial " + filialReporte + ": " + totalAccesosFilial);
                            break;

                        case 3: // Total de QuickPass registrados
                            int totalQuickpass = activos.obtenerTotalQuickpass();
                            JOptionPane.showMessageDialog(null, "Total de QuickPass registrados: " + totalQuickpass);
                            break;

                        case 4: // Total de QuickPass activos e inactivos
                            int[] estados = activos.obtenerQuickpassPorEstado();
                            JOptionPane.showMessageDialog(null, "Total de QuickPass Activos: " + estados[0] + "\nTotal de QuickPass Inactivos: " + estados[1]);
                            break;

                        case 5: // Total de QuickPass eliminados
                            int totalEliminados = activos.obtenerTotalQuickpassEliminados(eliminados);
                            JOptionPane.showMessageDialog(null, "Total de QuickPass eliminados: " + totalEliminados);
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida.");
                    }
                    break;


                case 0: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Hasta pronto!\nGrupo 06");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
