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

import com.marcafut.infra.AbstractED;

/**
 * Representa o usuário que utiliza o sistema.
 * 
 * @author Luiz Mello
 * 
 */
@Entity
@Table(name = "USUARIOS")
@NamedQueries({
        @NamedQuery(name = "UsuarioED.consultaPorId", query = "SELECT u FROM UsuarioED u WHERE u.id = :id"),
        @NamedQuery(name = "UsuarioED.consultaPorEmail", query = "SELECT u FROM UsuarioED u WHERE u.email = :email") })
public class UsuarioED extends AbstractED<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioED_SEQ")
    @SequenceGenerator(name = "UsuarioED_SEQ", sequenceName = "USUARIO_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOME", length = 100, nullable = false)
    @NotNull
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String nome;

    @Column(name = "SOBRENOME", length = 100, nullable = false)
    @NotNull
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String sobrenome;

    @Column(name = "APELIDO", length = 30)
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String apelido;

    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;

    @Column(name = "EMAIL", length = 30, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "SENHA", length = 128)
    @NotBlank
    @Size(min = 6, max = 16)
    private String senha;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(final String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(final Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
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
        UsuarioED other = (UsuarioED) obj;
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
