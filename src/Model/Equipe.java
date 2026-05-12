package Model;
import java.util.ArrayList;
import java.util.List;
public class Equipe {
    private int id;
    private String nome;
    private String descricao;
    private List<Usuario> membros;
    public Equipe(int id, String nome, String descricao) {
        this.id = id; this.nome = nome; this.descricao = descricao;
        this.membros = new ArrayList<>();
    }
    public void adicionarMembro(Usuario u) { membros.add(u); }
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public List<Usuario> getMembros() { return membros; }
    @Override
    public String toString() { return id + " - " + nome + " | membros: " + membros.size(); }
}
