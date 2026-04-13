package Model;

public class Tarefa {

    private int id;
    private String nome;
    private String descricao;
    private String status;
    private String prazo;
    private Colaborador responsavel;

    public Tarefa(int id, String nome, String descricao, String prazo, Colaborador responsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = "Pendente";
        this.prazo = prazo;
        this.responsavel = responsavel;
    }

    public void atualizarStatus(String status) {
        if (status != null && !status.isBlank()) {
            this.status = status;
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getPrazo() {
        return prazo;
    }

    public Colaborador getResponsavel() {
        return responsavel;
    }

    @Override
    public String toString() {
        return nome + " | " + status + " | prazo: " + prazo + " | responsavel: " + responsavel.getNome();
    }
}

