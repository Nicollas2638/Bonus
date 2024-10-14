/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author nicol
 */
import java.math.BigDecimal;

public class Departamento {
    private int id;
    private BigDecimal valorVendas;

    public Departamento(int id, BigDecimal valorVendas) {
        this.id = id;
        this.valorVendas = valorVendas;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getValorVendas() {
        return valorVendas;
    }
}
