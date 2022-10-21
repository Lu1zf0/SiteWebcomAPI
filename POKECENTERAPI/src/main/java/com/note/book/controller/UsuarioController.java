package com.note.book.controller;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RestController;
    import com.note.book.banco.UsuarioBanco;
    import com.note.book.entidade.Usuario;
    import java.util.List;
    import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioBanco acessoBanco;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
        return (List<Usuario>)acessoBanco.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> peguePorId(@PathVariable int id){
        return acessoBanco.findById(id);
    }

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Usuario NovoUsuario){
        acessoBanco.save(NovoUsuario);
    }

    @PutMapping("/alterar/{id}") 
    public void alterar(@PathVariable int id, @RequestBody Usuario usuario){ // PathVariable - Variável de caminho; ResquestBody - Corpo de Solicitação
        acessoBanco.findById(id).map(u ->{
            u.setNome(usuario.getNome());
            u.setUsuario(usuario.getUsuario());
            u.setEmail(usuario.getEmail());
            u.setEmail(usuario.getSenha());
            return acessoBanco.save(u);
        });
    }

    @PutMapping("/alterar")
    public void alterarUsuario(@PathVariable int id){
        acessoBanco.deleteById(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable int id){
        acessoBanco.deleteById(id);
    }
    
}
