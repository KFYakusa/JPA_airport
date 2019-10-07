package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author danie
 */
@Entity
@Table(name="tbl_voo")
public class Voo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_voo", sequenceName = "seq_voo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_voo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(columnDefinition = "text",nullable=false)
    @NotBlank(message="desc nao pode ser nula")
    private String descricao;
    
    @Column(nullable=false)
    @NotNull(message="tempoEstimnado nao pode ser nulo")
    private Double tempoEstimado;
    
    @Column(nullable=false)
    @NotNull(message="ativo nao pode ser nulo")
    private Boolean ativo;
    
    @NotBlank(message="periodicidade nao pode ser nula")
    @Column(nullable=false)
    private String periodicidade;
    
    @OneToMany(mappedBy = "voo",cascade = CascadeType.ALL,orphanRemoval=true, fetch = FetchType.LAZY)
    private List<VooAgendado> agendados = new ArrayList<>();
    
        
    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(name= "tbl_escalas", 
                joinColumns = @JoinColumn(name="voo",referencedColumnName = "id",nullable=false),
            inverseJoinColumns = @JoinColumn(name="aeroporto",referencedColumnName="id",nullable=false))
    private Set<Aeroporto> escalas = new HashSet<>();

    public Set<Aeroporto> getEscalas() {
        return escalas;
    }

    public void setEscalas(Set<Aeroporto> escalas) {
        this.escalas = escalas;
    }
    
    public Voo() {
    }

    public void adicionarVooAgendado(VooAgendado obj){
        obj.setVoo(this);
        this.agendados.add(obj);
    }
    public void removeVooAgendado(int index){
        this.agendados.remove(index);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }

    public List<VooAgendado> getAgendados() {
        return agendados;
    }

    public void setAgendados(List<VooAgendado> agendados) {
        this.agendados = agendados;
    }
    
    
}
