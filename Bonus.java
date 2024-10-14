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
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bonus {
    public static int aplicarBonus(List<Funcionario> funcionarios, List<Departamento> departamentos) throws BonusException {
        if (funcionarios.isEmpty() || departamentos.isEmpty()) {
            throw new BonusException("Preencha todas as tabelas.");
        }
        Map<Integer, BigDecimal> vendasPorDepartamento = new HashMap<>();
        BigDecimal maiorValorVendas = BigDecimal.ZERO;

        for (Departamento departamento : departamentos) {
            vendasPorDepartamento.put(departamento.getId(), departamento.getValorVendas());
            if (departamento.getValorVendas().compareTo(maiorValorVendas) > 0) {
                maiorValorVendas = departamento.getValorVendas();
            }
        }

        List<Funcionario> funcionariosElegiveis = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (vendasPorDepartamento.containsKey(funcionario.getCodigoDepartamento())
                    && vendasPorDepartamento.get(funcionario.getCodigoDepartamento()).compareTo(maiorValorVendas) == 0) {
                funcionariosElegiveis.add(funcionario);
            }
        }

        if (funcionariosElegiveis.isEmpty()) {
            throw new BonusException("nenhum funcionário elegível.");
        }

        BigDecimal bonusPadrão = new BigDecimal("2000");
        BigDecimal bonusGerente = new BigDecimal("1000");

        for (Funcionario funcionario : funcionariosElegiveis) {
            BigDecimal novoSalario;

            if (funcionario.getCargo().equalsIgnoreCase("gerente")) {
                novoSalario = funcionario.getSalario().add(bonusGerente);
            } else if (funcionario.getSalario().compareTo(new BigDecimal("150000")) >= 0) {
                novoSalario = funcionario.getSalario().add(new BigDecimal("1000"));
            } else {
                novoSalario = funcionario.getSalario().add(bonusPadrão);
            }

            funcionario.setSalario(novoSalario.setScale(2, RoundingMode.HALF_UP));
        }

        return 0;
    }

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Departamento> departamentos = new ArrayList<>();

        departamentos.add(new Departamento(1, new BigDecimal("500000")));
        departamentos.add(new Departamento(2, new BigDecimal("300000")));

        funcionarios.add(new Funcionario(1, new BigDecimal("100000"), "desenvolvedor", 1));
        funcionarios.add(new Gerente(2, new BigDecimal("160000"), 1));
        funcionarios.add(new Funcionario(3, new BigDecimal("80000"), "desenvolvedor", 2));

        try {
            int resultado = aplicarBonus(funcionarios, departamentos);
            System.out.println("Bônus aplicado com sucesso.");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Novo Salário: " + funcionario.getSalario());
            }
        } catch (BonusException e) {
            System.err.println(e.getMessage());
        }
    }
}

