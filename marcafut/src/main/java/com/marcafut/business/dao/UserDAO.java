package com.marcafut.business.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.marcafut.business.model.User;
import com.marcafut.infra.AbstractDAO;

/**
 * Classe que provê os acessos ao banco de dados para a tabela de usuários.
 * 
 * @author Luiz Mello
 * 
 */
public class UserDAO extends AbstractDAO<User, Long> {

    /**
     * Realiza a pesquisa de um usuário a partir de seu email.<br>
     * Código gerado: <i>SELECT * FROM usuarios u WHERE u.email = email</i>.
     * 
     * @param email
     *            email pesquisado.
     * 
     * @return um objeto do tipo {@code UsuarioED} com os dados do registro
     *         pesquisado.
     * 
     * @throws NoResultException
     *             se o registro não for encontrado.
     */
    public User consultarPorEmail(final String email) {
        Query query = entityManager.createNamedQuery("UsuarioED.consultaPorEmail");
        query.setParameter("email", email);

        return (User) query.getSingleResult();
    }

}
