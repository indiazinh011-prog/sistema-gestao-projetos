package View;
import Controller.SistemaController;
import Model.Projeto;
import Model.Tarefa;
import java.util.List;
import java.util.Scanner;
public class ProjetoView {
    private final SistemaController controller;
    private final Scanner scanner;
    public ProjetoView(SistemaController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }
    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== PROJETOS =====");
            System.out.println("1. Criar projeto");
            System.out.println("2. Listar projetos");
            System.out.println("3. Ver progresso de um projeto");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1 -> criarProjeto();
                case 2 -> listarProjetos();
                case 3 -> verProgresso();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    private void criarProjeto() {
        System.out.println("\n--- Criar Projeto ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine().trim();
        System.out.print("Prazo (ex: 30/12/2025): ");
        String prazo = scanner.nextLine().trim();
        boolean sucesso = controller.criarProjeto(nome, descricao, prazo);
        if (sucesso) System.out.println("✔ Projeto criado com sucesso!");
        else System.out.println("✘ Erro: todos os campos são obrigatórios.");
    }
    private void listarProjetos() {
        List<Projeto> projetos = controller.listarProjetos();
        if (projetos.isEmpty()) { System.out.println("\nNenhum projeto cadastrado."); return; }
        System.out.println("\n--- Lista de Projetos ---");
        for (int i = 0; i < projetos.size(); i++) {
            Projeto p = projetos.get(i);
            System.out.printf("[%d] %s | Prazo: %s | Tarefas: %d%n", i, p.getNome(), p.getPrazo(), p.getTarefas().size());
        }
    }
    private void verProgresso() {
        listarProjetos();
        List<Projeto> projetos = controller.listarProjetos();
        if (projetos.isEmpty()) return;
        System.out.print("\nDigite o índice do projeto: ");
        int index = lerInt();
        Projeto projeto = controller.buscarProjeto(index);
        if (projeto == null) { System.out.println("✘ Projeto não encontrado."); return; }
        System.out.println("\n--- Detalhes: " + projeto.getNome() + " ---");
        System.out.println("Descrição : " + projeto.getDescricao());
        System.out.println("Prazo     : " + projeto.getPrazo());
        List<Tarefa> tarefas = projeto.getTarefas();
        if (tarefas.isEmpty()) { System.out.println("Nenhuma tarefa vinculada a este projeto."); return; }
        for (Tarefa t : tarefas)
            System.out.printf("  [%d] %s | %s | Responsável: %s | Prazo: %s%n",
                t.getId(), t.getNome(), t.getStatus(), t.getResponsavel().getNome(), t.getPrazo());
        System.out.println();
        projeto.exibirProgresso();
    }
    private int lerInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }
}
