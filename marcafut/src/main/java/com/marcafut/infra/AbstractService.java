package com.marcafut.infra;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.marcafut.util.MessageBundleUtil;

/**
 * Classe abstrata que define o comportamento padr�o das classes de regra de
 * neg�cio do sistema.
 * 
 * @author Luiz Mello
 * 
 * @param <E>
 *            entidade gerenciada por esta classe.
 * @param <K>
 *            tipo da chave prim�ria da entidade gerenciada por esta classe.
 */
public abstract class AbstractService<E extends AbstractModel<K>, K> implements Serializable {

    private static final long serialVersionUID = 1L;
    private AbstractDAO<E, K> bd;
    @Inject
    protected MessageBundleUtil bundle;
    
    /**
     * Deve ser implementado pelas subclasses para informar � classe pai o
     * objeto {@code BaseBD} que ser� utilizado por esta classe.
     */
    @PostConstruct
    public abstract void initBD();

    /**
     * Chama a fun��o {@code consultarPorId(Object)} da classe {@code AppBD},
     * que realiza a pesquisa de uma entidade no banco de dados a partir de sua
     * chave prim�ria.
     * 
     * 
     * @param chavePrimaria
     * 
     *            valor da chave prim�ria da entidade a ser pesquisada.
     * 
     * @return a entidade pesquisada completa.
     * 
     * @throws NoResultException
     *             se a entidade pesquisada n�o for encontrada.
     *             
     * @see com.marcafut.infra.AbstractDAO#findById(Object)
     * 
     */
    public E findById(final K chavePrimaria) {
        return bd.findById(chavePrimaria);
    }

    /**
     * Seta o objeto {@code BaseBD} que ser� utilizado por esta classe.
     * 
     * @param bd
     *            objeto {@code BaseBD} que ser� utilizado por esta classe.
     */
    public void setBD(final AbstractDAO<E, K> bd) {
        this.bd = bd;
    }
}
