/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author danie
 */

@Entity
@Table(name="tbl_vooAgendado")
public class VooAgendado implements Serializable{
    @Id
    @SequenceGenerator(name="seq_VooAgendado",sequenceName="seq_vooAgendado_id",allocationSize=1)
    @GeneratedValue(generator = "seq_VooAgendado",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="A aeronave não pode ser em branco")
    @Length(max=100,message="A aeronave não pode ter mais que {max} caracteres")
    @Column(length=100,nullable=false)
    private String aeronave;
    @Min(value=0,message="O total de passageiros não pode ser negativo")
    @NotNull(message="O total de passageiros  deve ser informado")
    @Column(nullable=false)
    private Integer totalPassageiros;
    
    @Column(nullable=false)
    private Calendar data;

    public VooAgendado() {
    }
    
    @ManyToOne
    @NotNull(message="não pode ser nulo")
    @JoinColumn(name="voo",referencedColumnName = "id",nullable=false)
    private Voo voo;
    
    
    @OneToMany(mappedBy = "vooAgendado",cascade = CascadeType.ALL,orphanRemoval=true, fetch = FetchType.LAZY)
    private List<Passagem> passagens = new ArrayList<>();

    public void adicionarPassagem(Passagem obj){
        obj.setVooAgendado(this);
        this.passagens.add(obj);
    }
    public void removePassagem(int index){
        this.passagens.remove(index);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Integer getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(Integer totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

}
