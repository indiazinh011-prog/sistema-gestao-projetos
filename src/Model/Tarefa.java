package Model;

public class Tarefa {

    private int id;
    private String nome;
    private String descricao;
    private String status;
    private String prazo;
    private Colaborador responsavel;

    public Tarefa(int id, String nome, String descricao, String status, Colaborador responsavel) {
        this.id=id;
        this.nome=nome;
        this.descricao=descricao;
        this.status= "Pendente";
        this.prazo=prazo;
        this.responsavel=responsavel;
    }

    public void atualizarStatus(String status) {
        this.status =status;
    }

    public String getStatus () {return status;}

    @Override
    public String toString(){
        return nome + " | " + status + "|" + responsavel.getNome();
    }
}


