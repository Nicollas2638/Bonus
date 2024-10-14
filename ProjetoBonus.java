package Principal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProjetoBonus {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Departamento> departamentos = new ArrayList<>();
        departamentos.add(new Departamento(1, new BigDecimal("500000")));
        departamentos.add(new Departamento(2, new BigDecimal("300000")));
        funcionarios.add(new Funcionario(1, new BigDecimal("100000"), "desenvolvedor", 1));
        funcionarios.add(new Gerente(2, new BigDecimal("160000"), 1));
        funcionarios.add(new Funcionario(3, new BigDecimal("80000"), "desenvolvedor", 2));
        try {
            int resultado = Bonus.aplicarBonus(funcionarios, departamentos);
            System.out.println("Bônus aplicado com sucesso. Resultado: " + resultado);
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Novo Salário: " + funcionario.getSalario());
            }
        } catch (BonusException e) {
            System.err.println(e.getMessage());
        }
    }
}
