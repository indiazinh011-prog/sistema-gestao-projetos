package Model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private int id;
    private String nome;
    private String descricao;
    private String prazo;
    private List<Tarefa> tarefas;

    public Projeto(int id, String nome, String descricao, String prazo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.prazo = prazo;
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa t) {
        tarefas.add(t);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public int calcularConcluidas() {
        int concluidas = 0;

        for (Tarefa t : tarefas) {
            if (t.getStatus().equalsIgnoreCase("Concluido")
                || t.getStatus().equalsIgnoreCase("Concluído")) {
                concluidas++;
            }
        }

        return concluidas;
    }

    public void exibirProgresso() {
        int total = tarefas.size();
        int concluidas = calcularConcluidas();

        System.out.println(nome + " -> " + concluidas + "/" + total + " tarefas concluidas");
    }

    @Override
    public String toString() {
        return id + " - " + nome + " | prazo: " + prazo + " | tarefas: " + tarefas.size();
    }
}
