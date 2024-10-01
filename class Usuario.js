package modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Usuario {

    private long id;
    private String nome;
    private String senha;
    private String usuario;
    private Perfil perfil;
    private boolean estado;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime ultimoLogin;

    public Usuario() {
        this.estado = true;
    }

    public Usuario(long id, String nome, String senha, String usuario, Perfil perfil, LocalDateTime dataHoraCriacao, LocalDateTime ultimoLogin) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.perfil = perfil;
        this.dataHoraCriacao = dataHoraCriacao;
        this.ultimoLogin = ultimoLogin;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return getId() == usuario.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void reset() {
        this.estado = true;
    }

    public void mudarEstado() {
        this.estado = !this.estado;
    }
}
