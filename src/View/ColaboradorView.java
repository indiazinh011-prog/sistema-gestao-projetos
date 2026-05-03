package View;
import Controller.SistemaController;
import Model.Colaborador;
import java.util.List;
import java.util.Scanner;
public class ColaboradorView {
    private final SistemaController controller;
    private final Scanner scanner;
    public ColaboradorView(SistemaController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }
    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== COLABORADORES =====");
            System.out.println("1. Cadastrar colaborador");
            System.out.println("2. Listar colaboradores");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1 -> cadastrarColaborador();
                case 2 -> listarColaboradores();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private void cadastrarColaborador() {
        System.out.println("\n--- Cadastrar Colaborador ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine().trim();
        boolean sucesso = controller.criarColaborador(nome, cargo);
        if (sucesso) System.out.println("✔ Colaborador cadastrado com sucesso!");
        else System.out.println("✘ Erro: nome e cargo não podem ser vazios.");
    }
    private void listarColaboradores() {
        List<Colaborador> colaboradores = controller.listarColaboradores();
        if (colaboradores.isEmpty()) { System.out.println("\nNenhum colaborador cadastrado."); return; }
        System.out.println("\n--- Lista de Colaboradores ---");
        for (Colaborador c : colaboradores)
            System.out.printf("ID: %d | Nome: %s | Cargo: %s%n", c.getId(), c.getNome(), c.getCargo());
    }
    private int lerInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
}
