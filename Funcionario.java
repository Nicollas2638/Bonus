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

public class Funcionario {
    private int id;
    private BigDecimal salario;
    private String cargo;
    private int codigoDepartamento;

    public Funcionario(int id, BigDecimal salario, String cargo, int codigoDepartamento) {
        this.id = id;
        this.salario = salario;
        this.cargo = cargo;
        this.codigoDepartamento = codigoDepartamento;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getCodigoDepartamento() {
        return codigoDepartamento;
    }
}

