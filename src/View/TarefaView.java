package View;
import Controller.SistemaController;
import Model.Projeto;
import Model.Tarefa;
import Model.Usuario;
import java.util.List;
import java.util.Scanner;
public class TarefaView {
    private final SistemaController controller;
    private final Scanner scanner;
    public TarefaView(SistemaController controller, Scanner scanner) { this.controller = controller; this.scanner = scanner; }
    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== TAREFAS =====");
            System.out.println("1. Criar tarefa");
            System.out.println("2. Listar tarefas de um projeto");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            opcao = lerInt();
            switch (opcao) {
                case 1 -> criarTarefa();
                case 2 -> listarTarefas();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    private void criarTarefa() {
        List<Projeto> projetos = controller.listarProjetos();
        if (projetos.isEmpty()) { System.out.println("\nNenhum projeto cadastrado."); return; }
        System.out.println("\n--- Projetos disponíveis ---");
        for (int i = 0; i < projetos.size(); i++) System.out.printf("[%d] %s%n", i, projetos.get(i).getNome());
        System.out.print("Índice do projeto: "); int projetoIndex = lerInt();
        List<Usuario> usuarios = controller.listarUsuarios();
        if (usuarios.isEmpty()) { System.out.println("\nNenhum usuário cadastrado."); return; }
        System.out.println("\n--- Usuários disponíveis ---");
        for (Usuario u : usuarios) System.out.printf("ID: %d | %s | %s%n", u.getId(), u.getNome(), u.getPerfil());
        System.out.print("ID do responsável: "); int usuarioId = lerInt();
        System.out.println("\n--- Dados da Tarefa ---");
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Descrição: "); String descricao = scanner.nextLine().trim();
        System.out.print("Prazo (ex: 15/11/2025): "); String prazo = scanner.nextLine().trim();
        boolean sucesso = controller.criarTarefa(projetoIndex, nome, descricao, prazo, usuarioId);
        if (sucesso) System.out.println("✔ Tarefa criada com sucesso!");
        else System.out.println("✘ Erro: verifique os dados informados.");
    }
    private void listarTarefas() {
        List<Projeto> projetos = controller.listarProjetos();
        if (projetos.isEmpty()) { System.out.println("\nNenhum projeto cadastrado."); return; }
        System.out.println("\n--- Selecione um projeto ---");
        for (int i = 0; i < projetos.size(); i++) System.out.printf("[%d] %s%n", i, projetos.get(i).getNome());
        System.out.print("Índice do projeto: "); int index = lerInt();
        Projeto projeto = controller.buscarProjeto(index);
        if (projeto == null) { System.out.println("✘ Projeto não encontrado."); return; }
        List<Tarefa> tarefas = projeto.getTarefas();
        if (tarefas.isEmpty()) { System.out.println("\nNenhuma tarefa vinculada."); return; }
        System.out.println("\n--- Tarefas de \"" + projeto.getNome() + "\" ---");
        for (Tarefa t : tarefas)
            System.out.printf("ID: %d | %s | %s | Responsável: %s | Prazo: %s%n",
                t.getId(), t.getNome(), t.getStatus(), t.getResponsavel().getNome(), t.getPrazo());
    }
    private int lerInt() {
        try { return Integer.parseInt(scanner.nextLine().trim()); } catch (NumberFormatException e) { return -1; }
    }
}
