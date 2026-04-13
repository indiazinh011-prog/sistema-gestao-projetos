package View;

import Controller.SistemaController;
import Model.*;
import java.util.Scanner;

public class Main{

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaController controller = new SistemaController();

        int opcao = 0;

        do {
            System.out.println("\n===MENU====");
            System.out.println("1-Cadastrar colaborador");
            System.out.println("2-Criar projeto");
            System.out.println("3-Criar tarefa");
            System.out.println("4-Listar projetos");
            System.out.println("5-Ver Progresso");
            System.out.println("6-Sair");
            System.out.print("Opcao: ");

            if (!sc.hasNextInt()) {
                System.out.println("Digite um numero valido.");
                sc.nextLine();
                continue;
            }
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Nome");
                    String nome = sc.nextLine();

                    System.out.println("Cargo");
                    String cargo = sc.nextLine();

                    if (controller.criarColaborador(nome, cargo)) {
                        System.out.println("Colaborador cadastrado com sucesso.");
                    } else {
                        System.out.println("Nao foi possivel cadastrar colaborador. Verifique os dados.");
                    }
                    break;

                case 2:
                    System.out.println("Nome do projeto");
                    String nomeProjeto = sc.nextLine();

                    System.out.println("Descricao: ");
                    String desc = sc.nextLine();

                    System.out.println("Prazo");
                    String prazo = sc.nextLine();

                    if (controller.criarProjeto(nomeProjeto, desc, prazo)) {
                        System.out.println("Projeto criado com sucesso.");
                    } else {
                        System.out.println("Nao foi possivel criar projeto. Verifique os dados.");
                    }
                    break;

                case 3:
                    if (controller.listarProjetos().isEmpty()) {
                        System.out.println("Cadastre um projeto antes de criar tarefas.");
                        break;
                    }

                    if (controller.listarColaboradores().isEmpty()) {
                        System.out.println("Cadastre um colaborador antes de criar tarefas.");
                        break;
                    }

                    System.out.println("Escolha o projeto (index): ");
                    for (int i = 0; i < controller.listarProjetos().size(); i++) {
                        System.out.println(i + " - " + controller.listarProjetos().get(i).getNome());
                    }
                    if (!sc.hasNextInt()) {
                        System.out.println("Indice de projeto invalido.");
                        sc.nextLine();
                        break;
                    }
                    int projetoIndex = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nome da tarefa:");
                    String nomeTarefa = sc.nextLine();

                    System.out.println("Descrição:");
                    String descTarefa = sc.nextLine();

                    System.out.println("Prazo:");
                    String prazoTarefa = sc.nextLine();

                    System.out.println("Escolha o colaborador (ID)");
                    for (Colaborador c : controller.listarColaboradores()) {
                        System.out.println(c);
                    }
                    if (!sc.hasNextInt()) {
                        System.out.println("ID de colaborador invalido.");
                        sc.nextLine();
                        break;
                    }
                    int colaboradorId = sc.nextInt();
                    sc.nextLine();

                    if (controller.criarTarefa(projetoIndex, nomeTarefa, descTarefa, prazoTarefa, colaboradorId)) {
                        System.out.println("Tarefa criada com sucesso.");
                    } else {
                        System.out.println("Nao foi possivel criar tarefa. Verifique projeto, colaborador e campos.");
                    }
                    break;

                case 4:
                    if (controller.listarProjetos().isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado.");
                        break;
                    }
                    for (Projeto p : controller.listarProjetos()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    if (controller.listarProjetos().isEmpty()) {
                        System.out.println("Nenhum projeto cadastrado.");
                        break;
                    }
                    for (Projeto p : controller.listarProjetos()) {
                        p.exibirProgresso();
                    }
                    break;

                case 6:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

        } while(opcao !=6);

        sc.close();
    }
}
