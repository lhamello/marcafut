package com.marcafut.infra;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Classe abstrata responsável por injetar a unidade de persitência nas classes
 * <i>DAO</i> que a estendem. Também fornece os padrões de acesso ao banco de
 * dados.
 * 
 * @author Luiz Mello
 * 
 * @param <E>
 *            entidade gerenciada pela classe <i>DAO</i>.
 * @param <K>
 *            tipo da chave primária da entidade.
 */
public class AbstractBD<E extends AbstractED<K>, K> {

    private Class<E> entidade;
    @PersistenceContext
    protected EntityManager entityManager;
    
    /**
     * Construtor padrão.
     */
    @SuppressWarnings("unchecked")
    public AbstractBD() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entidade = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }
    
    /**
     * Realiza consulta no banco de dados a partir da chave primária da
     * entidade.<br>
     * Código {@code SQL} gerado: <i>SELECT * FROM entidade e WHERE e.id =
     * chavePrimaria</i>.
     * 
     * @param chavePrimaria
     *            chave primária do registro pesquisado.
     * 
     * @return o contéudo da entidade {@code E} pesquisada.
     * 
     * @throws NoResultException
     *             se o registro pesquisado não for encontrado.
     */
    @SuppressWarnings("unchecked")
    public E consultarPorId(final K chavePrimaria) {
        final String namedQuery = entidade.getSimpleName() + ".consultaPorId";
        
        Query query = entityManager.createNamedQuery(namedQuery);
        query.setParameter("id", chavePrimaria);
        
        return (E) query.getSingleResult();
    }
    
}
