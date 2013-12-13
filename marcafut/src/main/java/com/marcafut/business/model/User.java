package com.marcafut.business.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.marcafut.infra.AbstractModel;

/**
 * Representa o usuário que utiliza o sistema.
 * 
 * @author Luiz Mello
 * 
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(name = "User.findByEmailPassword", query = "SELECT u FROM UsuarioED u WHERE u.email = :email AND u.password = :password"),
    @NamedQuery(name = "User.findById",            query = "SELECT u FROM UsuarioED u WHERE u.id = :id")})
public class User extends AbstractModel<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioED_SEQ")
    @SequenceGenerator(name = "UsuarioED_SEQ", sequenceName = "USUARIO_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "FIRST_NAME", length = 100, nullable = false)
    @NotNull
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String firstName;

    @Column(name = "LAST_NAME", length = 100, nullable = false)
    @NotNull
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String lastName;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Calendar birthDate;

    @Column(name = "EMAIL", length = 30, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "PASSWORD", length = 128)
    @NotBlank
    @Size(min = 6, max = 16)
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
        User other = (User) obj;
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
