package View;
import Controller.SistemaController;
import Model.Projeto;
import Model.Tarefa;
import Model.Usuario;
import java.util.List;
import java.util.Scanner;
public class ProjetoView {
    private final SistemaController controller;
    private final Scanner scanner;
    public ProjetoView(SistemaController controller, Scanner scanner) { this.controller = controller; this.scanner = scanner; }
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
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    private void criarProjeto() {
        List<Usuario> usuarios = controller.listarUsuarios();
        if (usuarios.isEmpty()) { System.out.println("\nCadastre um usuário gerente primeiro."); return; }
        System.out.println("\n--- Criar Projeto ---");
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Descrição: "); String descricao = scanner.nextLine().trim();
        System.out.print("Data de início (ex: 01/01/2025): "); String dataInicio = scanner.nextLine().trim();
        System.out.print("Data de término prevista (ex: 30/12/2025): "); String dataTermino = scanner.nextLine().trim();
        System.out.println("\n--- Selecione o gerente responsável ---");
        for (Usuario u : usuarios) System.out.printf("ID: %d | %s | %s%n", u.getId(), u.getNome(), u.getPerfil());
        System.out.print("ID do gerente: "); int gerenteId = lerInt();
        boolean sucesso = controller.criarProjeto(nome, descricao, dataInicio, dataTermino, gerenteId);
        if (sucesso) System.out.println("✔ Projeto criado com sucesso!");
        else System.out.println("✘ Erro: verifique os dados informados.");
    }
    private void listarProjetos() {
        List<Projeto> projetos = controller.listarProjetos();
        if (projetos.isEmpty()) { System.out.println("\nNenhum projeto cadastrado."); return; }
        System.out.println("\n--- Lista de Projetos ---");
        for (int i = 0; i < projetos.size(); i++) {
            Projeto p = projetos.get(i);
            System.out.printf("[%d] %s | %s até %s | Status: %s | Gerente: %s%n",
                i, p.getNome(), p.getDataInicio(), p.getDataTermino(), p.getStatus(), p.getGerente().getNome());
        }
    }
    private void verProgresso() {
        listarProjetos();
        List<Projeto> projetos = controller.listarProjetos();
        if (projetos.isEmpty()) return;
        System.out.print("\nDigite o índice do projeto: "); int index = lerInt();
        Projeto projeto = controller.buscarProjeto(index);
        if (projeto == null) { System.out.println("✘ Projeto não encontrado."); return; }
        System.out.println("\n--- Detalhes: " + projeto.getNome() + " ---");
        System.out.println("Descrição  : " + projeto.getDescricao());
        System.out.println("Início     : " + projeto.getDataInicio());
        System.out.println("Término    : " + projeto.getDataTermino());
        System.out.println("Status     : " + projeto.getStatus());
        System.out.println("Gerente    : " + projeto.getGerente().getNome());
        List<Tarefa> tarefas = projeto.getTarefas();
        if (tarefas.isEmpty()) { System.out.println("Nenhuma tarefa vinculada."); return; }
        for (Tarefa t : tarefas)
            System.out.printf("  [%d] %s | %s | Responsável: %s | Prazo: %s%n",
                t.getId(), t.getNome(), t.getStatus(), t.getResponsavel().getNome(), t.getPrazo());
        System.out.println();
        projeto.exibirProgresso();
    }
    private int lerInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); } catch (NumberFormatException e) { return -1; }
    }
}
