package com.unitins.dao;

import com.unitins.model.Usuario;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;

@Stateless
public class UsuarioDao extends GenericDao<Integer, Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }

    /**
     * Metodo que Verifica o Login e a Senha e retorna um Usuario caso este
     * seja, validado
     *
     * @param email
     * @param senha
     * @return Usuario
     */
    public Usuario login(String email, String senha) {
        List<Usuario> usuarios = getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.email"
                + " LIKE '" + email + "' AND BINARY (u.senha) LIKE '" + senha + "'").getResultList();

        if (usuarios.size() == 1) {
            Usuario usuario = usuarios.get(0);
            return usuario;
        }
        return null;
    }

    /**
     * Metodo que verifica se o Login está disponível para o Cadastro ou edição
     * do Login(Atributo Login é Único)
     * @param usuario
     * @return boolean
     */
    public boolean verificaEmail(Usuario usuario) {
        List<Usuario> usuarios = getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.email"
                + " LIKE '" + usuario.getEmail() + "'").getResultList();

        if (usuario.getId() == null) {
            if (usuarios.isEmpty()) {
                return true;
            }
        } else {
            for (Usuario user : usuarios) {
                if (Objects.equals(user.getId(), user.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

}
