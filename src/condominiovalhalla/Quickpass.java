/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package condominiovalhalla;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrew
 * @author Kendall
 * @author Janaikel
 */

public class Quickpass {
    private String filial;
    private String codigo;
    private String placa;
    private Estado estado;

    
    public Quickpass(String filial, String codigo, String placa) {
        this.filial = filial;
        setCodigo(codigo);  // Validar y asignar código
        setPlaca(placa);     // Validar y asignar placa
        this.estado = Estado.Activo; 
    }

    // Getters y Setters
    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        if (!validacionFilial(filial)) {
            JOptionPane.showMessageDialog(null, "ERROR: La filial no puede estar vacía.");
        }
        this.filial = filial;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!validarCodigo(codigo)) {
            JOptionPane.showMessageDialog(null, "ERROR: El código debe tener exactamente 10 dígitos y comenzar con '101'.");
        }
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (!validarPlaca(placa)) {
            JOptionPane.showMessageDialog(null, "ERROR: La placa no puede estar vacía.");
        }
        this.placa = placa;
    }

    public void cambiarEstado() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cambiar el estado del Quickpass?");
        if (respuesta == JOptionPane.YES_OPTION) {
            if (estado == Estado.Activo) {
                estado = Estado.Inactivo;
            } else {
                estado = Estado.Activo;
            }
            JOptionPane.showMessageDialog(null, "Estado cambiado a: " + estado);
        }
    }
 
    public void mostrarInfo() {
        JOptionPane.showMessageDialog(null, "Información del Quickpass:\n" +
                                            "Filial: " + getFilial() + "\n" +
                                            "Código: " + getCodigo() + "\n" +
                                            "Placa: " + getPlaca() + "\n" +
                                            "Estado: " + estado);
    }

    // Validaciones

    public static boolean validarCodigo(String codigo) {
        return codigo != null && codigo.matches("^101\\d{7}$");
    }

    public static boolean validarPlaca(String placa) {
        return placa != null && !placa.trim().isEmpty();
    }
    
    public static boolean validacionFilial (String filial) {
        return filial != null && !filial.trim().isEmpty();
    }
}