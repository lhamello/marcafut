package com.marcafut.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.marcafut.infra.AbstractModel;

/**
 * Represents the sports games can be scheduled.<br>
 * List of fields:<br>
 * <ul>
 * <li><i>id</i> - table identifier (primary key).</li>
 * <li><i>name</i> - sport name.</li>
 * </ul>
 * 
 * @author Luiz Mello
 * 
 */
@Entity
@Table(name = "SPORTS")
@NamedQueries({
    @NamedQuery(name = "User.findById", query = "SELECT s FROM Sports s WHERE s.id = :id")})
public class Sport extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Unique user identifier (primary key).
     */
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioED_SEQ")
    @SequenceGenerator(name = "UsuarioED_SEQ", sequenceName = "USUARIO_ID_SEQ", allocationSize = 1)
    private Long id;
    
    @Column(name = "NAME", length = 30, nullable = false)
    private String name;
    
    @Override
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        Sport other = (Sport) obj;
        
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        
        return true;
    }

}
