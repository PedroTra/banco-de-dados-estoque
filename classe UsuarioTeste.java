import modelo.dado.UsuarioDado;
import modelo.dominio.Perfil;
import modelo.dominio.Usuario;

public class UsuarioTeste {

    public  static void  main(String[] args){

        Usuario usuario = new Usuario(0L, "Pedro", "1234", "Pedro", Perfil.ADMIN, null, null);
        UsuarioDado usuarioDado = new UsuarioDado();
        String mensagem = usuarioDado.salvar(usuario);
        System.out.println(mensagem);

        
        Usuario usuario = new Usuario(0L, "PedroPon", "1234", "Pedro02", Perfil.PADRAO, null, null);
        UsuarioDado usuarioDado = new UsuarioDado();
        String mensagem = usuarioDado.salvar(usuario);
        System.out.println(mensagem);



    }
}
