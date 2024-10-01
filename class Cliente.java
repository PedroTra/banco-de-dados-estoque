package modelo.dominio;

public class Cliente {

    private long id;
    private String nome;
    private String telefone;
    private String morada;

    public Cliente() {
    }

    public Cliente(long id, String nome, String telefone, String morada) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.morada = morada;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
}
