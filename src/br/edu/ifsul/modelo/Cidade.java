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
@Table(name="tbl_cidade")
public class Cidade implements Serializable{    

    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "Informe o nome da cidade! POR FAVOR, ERA O MINIMO, nE U_U")
    @Length(max = 50, message = "QUE PORRA DE CIDADE É ESSA?! NAO TEM COMO ter mais de {max} Caracteres")
    @Column(nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "Informe o nome do País! POR FAVOR, ERA O MINIMO, nE U_U")
    @Length(max = 50, message = " NAO TEM COMO ter mais de {max} Caracteres")
    @Column(nullable = false, length = 50)
    private String pais;

    public Cidade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
}
