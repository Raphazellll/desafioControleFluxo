package candidato;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcecssoSeletivo {
    public static void main(String[] args) throws Exception {
        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Raphael", "Gabrielle", "Fabricio", "Lucas",
                "Douglas", "Laura" };
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }

    // =====================Ligando para os
    // funcionários=============================================================
    // método auxiliar para randomizar as ligações.
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do { // tentando ligar para o funcionário
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
        } while (continuarTentando && tentativasRealizadas < 3); // resposta se irão atender ou não.
        if (atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM O " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMOS DED TENTATIVAS "
                    + tentativasRealizadas + " REALIZADAS.");

    }

    // =====================Imprimir
    // Selecionados=============================================================
    static void imprimirSelecionados() {
        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Raphael" };

        System.out.println("Imprimindo a lista de candaidatos informando o indice do elemento");
        for (int indice = 0; indice < candidatos.length; indice++) {

            System.out.println("O candidato de Nº " + (indice + 1) + " é o " + candidatos[indice]);
        }
    }

    // =============================Seleção de
    // candidatos=====================================================
    static void selecaoCandidatos() {
        String[] candidatos = { "Felipe", "Marcia", "Julia", "Paulo", "Raphael", "Gabrielle", "Fabricio", "Lucas",
                "Douglas", "Laura" }; // candidatos a vaga, array de string.

        int candidatosSelecionados = 0; // candidatos selecionados
        int candidatosAtual = 0; // quantidade de selecionados atualmente
        double salarioBase = 2000.0; // salario

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O Candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

    }

    // ============================Valor
    // pretendido======================================================
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1900, 2100);
    }

    static void analisarCandidato(double salarioPrometido) { // não retorna absolutamente nada
        double salarioBase = 2000.0;
        if (salarioBase > salarioPrometido)
            System.out.println("LIGAR PARA O CANDIDATO");
        else if (salarioBase == salarioPrometido)
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA-PROPOSTA.");
        else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
    // ==================================================================================
}
