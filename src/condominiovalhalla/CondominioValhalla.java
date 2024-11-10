/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package condominiovalhalla;
import javax.swing.JOptionPane;
/**
 *
 * @author Andrew
 * @author Kendall
 * @author Janaikel
 */

public class CondominioValhalla {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        String filial;
        do {
            filial = JOptionPane.showInputDialog("Ingrese la filial (numero de propiedad)");
            if(!Quickpass.validacionFilial(filial)) {
                JOptionPane.showMessageDialog(null, "ERROR: La filial no puede estar vacia");
            }
        } while (!Quickpass.validacionFilial(filial));


        String codigo;
        do {
            codigo = JOptionPane.showInputDialog("Ingrese el código de 10 dígitos que comience con '101':");
            if (!Quickpass.validarCodigo(codigo)) {
                JOptionPane.showMessageDialog(null, "ERROR: El código debe tener exactamente 10 dígitos y comenzar con '101'.");
            }
        } while (!Quickpass.validarCodigo(codigo));


        String placa;
        do {
            placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
            if (!Quickpass.validarPlaca(placa)) {
                JOptionPane.showMessageDialog(null, "ERROR: La placa no puede estar vacía.");
            }
        } while (!Quickpass.validarPlaca(placa));


        Quickpass quickpass = new Quickpass(filial, codigo, placa);

        quickpass.mostrarInfo();
        quickpass.cambiarEstado();
        quickpass.mostrarInfo();
        
    }
    
}
