package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author danie
 * @Projeto: aeroporto_de_mosquito
 */

@Entity
@Table(name = "tbl_classe")
public class Classe implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_classe", sequenceName = "seq_classe_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_classe", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "NAME HAS TO BE INFORMED")
    @Length(max = 50, message = "HAS to be at max 50 char")
    @Column(nullable = false, length = 50)
    private String nome;

    @Min(value=0,message="O valor não pode ser negativo")
    @NotNull(message="O preco deve ser informado")
    @Column(nullable=false,columnDefinition="numeric(12,2)")
    private Double valor;

    public Classe() {
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
