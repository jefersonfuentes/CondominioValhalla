package condominiovalhalla;

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

    public Quickpass(String filial, String codigo, String placa, Estado estado) {
        this.filial = filial;
        this.codigo = codigo;
        this.placa = placa;
        this.estado = estado;
    }

    // Getters y Setters
    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Quickpass{" +
                "filial='" + filial + '\'' +
                ", codigo='" + codigo + '\'' +
                ", placa='" + placa + '\'' +
                ", estado=" + estado +
                '}';
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
