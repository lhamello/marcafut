package com.marcafut.infra;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Classe abstrata respons�vel por injetar a unidade de persit�ncia nas classes
 * <i>DAO</i> que a estendem. Tamb�m fornece os padr�es de acesso ao banco de
 * dados.
 * 
 * @author Luiz Mello
 * 
 * @param <E>
 *            entidade gerenciada pela classe <i>DAO</i>.
 * @param <K>
 *            tipo da chave prim�ria da entidade.
 */
public class AbstractBD<E extends AbstractED<K>, K> {

    private Class<E> entidade;
    @PersistenceContext
    protected EntityManager entityManager;
    
    /**
     * Construtor padr�o.
     */
    @SuppressWarnings("unchecked")
    public AbstractBD() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entidade = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }
    
    /**
     * Realiza consulta no banco de dados a partir da chave prim�ria da
     * entidade.<br>
     * C�digo {@code SQL} gerado: <i>SELECT * FROM entidade e WHERE e.id =
     * chavePrimaria</i>.
     * 
     * @param chavePrimaria
     *            chave prim�ria do registro pesquisado.
     * 
     * @return o cont�udo da entidade {@code E} pesquisada.
     * 
     * @throws NoResultException
     *             se o registro pesquisado n�o for encontrado.
     */
    @SuppressWarnings("unchecked")
    public E consultarPorId(final K chavePrimaria) {
        final String namedQuery = entidade.getSimpleName() + ".consultaPorId";
        
        Query query = entityManager.createNamedQuery(namedQuery);
        query.setParameter("id", chavePrimaria);
        
        return (E) query.getSingleResult();
    }
    
}
