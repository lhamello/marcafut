package com.marcafut.business.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.marcafut.business.model.UsuarioED;
import com.marcafut.infra.AbstractBD;

/**
 * Classe que prov� os acessos ao banco de dados para a tabela de usu�rios.
 * 
 * @author Luiz Mello
 * 
 */
public class UsuarioBD extends AbstractBD<UsuarioED, Long> {

    /**
     * Realiza a pesquisa de um usu�rio a partir de seu email.<br>
     * C�digo gerado: <i>SELECT * FROM usuarios u WHERE u.email = email</i>.
     * 
     * @param email
     *            email pesquisado.
     * 
     * @return um objeto do tipo {@code UsuarioED} com os dados do registro
     *         pesquisado.
     * 
     * @throws NoResultException
     *             se o registro n�o for encontrado.
     */
    public UsuarioED consultarPorEmail(final String email) {
        Query query = entityManager.createNamedQuery("UsuarioED.consultaPorEmail");
        query.setParameter("email", email);

        return (UsuarioED) query.getSingleResult();
    }

}
