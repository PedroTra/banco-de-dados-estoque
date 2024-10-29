package modelo.dado;

import modelo.conexao.Conexao;
import modelo.conexao.ConexaoMySql;
import modelo.dominio.Perfil;
import modelo.dominio.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDado {

    private final Conexao conexao;;

    public UsuarioDado(Conexao conexao) {
        this.conexao = new ConexaoMySql();
    }

    private String adicionar(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, usuario, senha, perfil, estado) VALUESn(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

            preencherValoresPreperedStatement(preparedStatement, usuario);

            int resultado = preparedStatement.executeUpdate();

            return resultado == 1 ? "Usuário adicionado com sucesso" : "Não foi possível adicionar usuário";
        } catch (SQLException e) {
            return  String.format("Erro: %s", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {
        String sql = "UPDATE categoria SET nome = ?, usuario = ?, senha = ?, perfil = ?, estado WHERE id = ?";
        try {
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);

        preencherValoresPreperedStatement(preparedStatement, usuario);

        int resultado = preparedStatement.executeUpdate();

        return resultado == 1 ? "Usuário editado com sucesso" : "Não foi possível editar usuário";
    } catch (SQLException e) {
        return  String.format("Erro: %s", e.getMessage());
    }}

    private void preencherValoresPreperedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsuario());
        preparedStatement.setString(3, usuario.getSenha());
        preparedStatement.setString(4, usuario.getPerfil().name());
        preparedStatement.setBoolean(5, usuario.isEstado());

        if (usuario.getId() != 0L){
            preparedStatement.setLong(6, usuario.getId());
        }
    }



    public String salvar(Usuario usuario) {
        return usuario.getId() == 0L ? adicionar(usuario) : editar(usuario);
    }

    public List<Usuario> buscarTodosUsuarios() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();

            while (result.next()){
                usuarios.add(getUsuario(result));
            }
        } catch (SQLException e){
            System.out.println(String.format("Error: ", e.getMessage()));
        }

        return usuarios;
    }

    private Usuario getUsuario(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getNString("senha"));
        usuario.setPerfil(result.getObject("perfil", Perfil.class));
        usuario.setEstado(result.getBoolean("estado"));
        usuario.setDataHoraCriacao(result.getObject("data hora criacao", LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultimo login", LocalDateTime.class));

        return  usuario;
    }

}
