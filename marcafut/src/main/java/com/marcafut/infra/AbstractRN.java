package com.marcafut.infra;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;

/**
 * Classe abstrata que define o comportamento padrão das classes de regra de
 * negócio do sistema.
 * 
 * @author Luiz Mello
 * 
 * @param <E>
 *            entidade gerenciada por esta classe.
 * @param <K>
 *            tipo da chave primária da entidade gerenciada por esta classe.
 */
public abstract class AbstractRN<E extends AbstractED<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;
    private AbstractBD<E, K> bd;

    /**
     * Deve ser implementado pelas subclasses para informar à classe pai o
     * objeto {@code BaseBD} que será utilizado por esta classe.
     */
    @PostConstruct
    public abstract void initBD();

    /**
     * Chama a função {@code consultarPorId(Object)} da classe {@code AppBD},
     * que realiza a pesquisa de uma entidade no banco de dados a partir de sua
     * chave primária.
     * 
     * 
     * @param chavePrimaria
     * 
     *            valor da chave primária da entidade a ser pesquisada.
     * 
     * @return a entidade pesquisada com todos seus campos.
     * 
     * @throws NoResultException
     *             se a entidade pesquisada não for encontrada.
     *             
     * @see br.com.lham.ollem.business.FrameworkDAO#consultarPorId(Object)
     * 
     */
    public E consultarPorId(final K chavePrimaria) {
        return bd.consultarPorId(chavePrimaria);
    }

    /**
     * Seta o objeto {@code BaseBD} que será utilizado por esta classe.
     * 
     * @param bd
     *            objeto {@code BaseBD} que será utilizado por esta classe.
     */
    public void setBD(final AbstractBD<E, K> bd) {
        this.bd = bd;
    }
}
