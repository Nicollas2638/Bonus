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

public class Gerente extends Funcionario {
    public Gerente(int id, BigDecimal salario, int codigoDepartamento) {
        super(id, salario, "gerente", codigoDepartamento);
    }
}
