package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danie
 * @Projeto: aeroporto_de_mosquito
 */
@Entity
@Table(name="tbl_passagem")
public class Passagem implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_passagem", sequenceName = "seq_passagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_passagem", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message=" data compra nao pode ser nulo")
    private Calendar dataCompra;
    
    @Column
    private Integer bagagem;
    
    // RELACIONAMENTOS ---------------------------------------------------
    public Passagem() {
    }
    
    @NotNull(message=" pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_pessoa_passagem"))
    private Pessoa pessoa;
    
    
    @NotNull(message=" pessoa não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_pessoa_passagem"))
    private Classe classe;
    
    
    @ManyToOne
    @NotNull(message="não pode ser VooAgendado nulo")
    @JoinColumn(name="vooAgendado",referencedColumnName = "id",nullable=false)
    private VooAgendado vooAgendado;

    public VooAgendado getVooAgendado() {
        return vooAgendado;
    }

    public void setVooAgendado(VooAgendado vooAgendado) {
        this.vooAgendado = vooAgendado;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Calendar dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getBagagem() {
        return bagagem;
    }

    public void setBagagem(Integer bagagem) {
        this.bagagem = bagagem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    
}
