/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominiovalhalla;
import javax.swing.JOptionPane;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Strxky
 */

public class HistorialAccesos {

    private static final String ARCHIVO = "Historial.txt";

    // Consulta por filial
    public void consultarPorFilial(String filial) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            StringBuilder resultado = new StringBuilder("Accesos para la filial: " + filial + "\n\n");
            String linea;
            boolean encontrado = false;

            while ((linea = reader.readLine()) != null) {
                if (linea.contains("Filial: " + filial)) {
                    resultado.append(linea).append("\n");
                    encontrado = true;
                }
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null, resultado.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para la filial especificada.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el historial: " + e.getMessage());
        }
    }

    // Consulta por rango de fechas
    public void consultarPorRangoFechas(String fechaInicio, String fechaFin) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);

            StringBuilder resultado = new StringBuilder("Accesos entre " + fechaInicio + " y " + fechaFin + ":\n\n");
            String linea;
            boolean encontrado = false;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("; ");
                for (String parte : partes) {
                    if (parte.startsWith("Fecha: ")) {
                        String fecha = parte.substring(7, 17); // Extrae la fecha del formato "Fecha: 2/11/2024 14:40"
                        LocalDate fechaLinea = LocalDate.parse(fecha, formatter);

                        if (!fechaLinea.isBefore(inicio) && !fechaLinea.isAfter(fin)) {
                            resultado.append(linea).append("\n");
                            encontrado = true;
                        }
                    }
                }
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null, resultado.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos en el rango de fechas especificado.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el historial: " + e.getMessage());
        }
    }

    // Consulta por código o placa
    public void consultarPorCodigoOPlaca(String identificador) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            StringBuilder resultado = new StringBuilder("Accesos para el identificador: " + identificador + "\n\n");
            String linea;
            boolean encontrado = false;

            while ((linea = reader.readLine()) != null) {
                if (linea.contains("Código: " + identificador) || linea.contains("Placa: " + identificador)) {
                    resultado.append(linea).append("\n");
                    encontrado = true;
                }
            }

            if (encontrado) {
                JOptionPane.showMessageDialog(null, resultado.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron accesos para el identificador especificado.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el historial: " + e.getMessage());
        }
    }
}