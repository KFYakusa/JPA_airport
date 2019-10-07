package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author danie  
 * @Projeto: aeroporto_de_mosquito
 */
@Entity
@Table(name="tbl_pessoa")
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "NAME HAS TO BE INFORMED")
    @Length(max = 50, message = "HAS to be at max 50 char")
    @Column(nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "cpf HAS TO BE INFORMED")
    @Length(max = 11, message = "HAS to be at max 50 char")
    @Column(nullable = false, length = 11)
    private String cpf;
    
    @NotBlank(message = "email HAS TO BE INFORMED")
    @Length(max = 50, message = "HAS to be at max 50 char")
    @Column(nullable = false, length = 50)
    private String email;
    
    @NotBlank(message = "telefone HAS TO BE INFORMED")
    @Length(max = 12, message = "HAS to be at max 50 char")
    @Column(length = 12)
    private String telefone;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
