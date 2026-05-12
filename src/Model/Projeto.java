package Model;
import java.util.ArrayList;
import java.util.List;
public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private StatusProjeto status;
    private Usuario gerente;
    private List<Tarefa> tarefas;
    public Projeto(int id, String nome, String descricao, String dataInicio, String dataTermino, Usuario gerente) {
        this.id = id; this.nome = nome; this.descricao = descricao;
        this.dataInicio = dataInicio; this.dataTermino = dataTermino;
        this.status = StatusProjeto.PLANEJADO; this.gerente = gerente;
        this.tarefas = new ArrayList<>();
    }
    public void adicionarTarefa(Tarefa t) { tarefas.add(t); }
    public List<Tarefa> getTarefas() { return tarefas; }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getDataInicio() { return dataInicio; }
    public String getDataTermino() { return dataTermino; }
    public StatusProjeto getStatus() { return status; }
    public void setStatus(StatusProjeto status) { this.status = status; }
    public Usuario getGerente() { return gerente; }
    public int calcularConcluidas() {
        int concluidas = 0;
        for (Tarefa t : tarefas)
            if (t.getStatus().equalsIgnoreCase("Concluído")) concluidas++;
        return concluidas;
    }
    public void exibirProgresso() {
        int total = tarefas.size();
        int concluidas = calcularConcluidas();
        System.out.println(nome + " -> " + concluidas + "/" + total + " tarefas concluidas");
    }
    @Override
    public String toString() { return id + " - " + nome + " | status: " + status + " | gerente: " + gerente.getNome(); }
}
