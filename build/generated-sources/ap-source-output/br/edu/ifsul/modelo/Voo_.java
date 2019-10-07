package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Voo.class)
public abstract class Voo_ {

	public static volatile SingularAttribute<Voo, Double> tempoEstimado;
	public static volatile SetAttribute<Voo, Aeroporto> escalas;
	public static volatile SingularAttribute<Voo, Boolean> ativo;
	public static volatile SingularAttribute<Voo, String> periodicidade;
	public static volatile SingularAttribute<Voo, Integer> id;
	public static volatile ListAttribute<Voo, VooAgendado> agendados;
	public static volatile SingularAttribute<Voo, String> descricao;

	public static final String TEMPO_ESTIMADO = "tempoEstimado";
	public static final String ESCALAS = "escalas";
	public static final String ATIVO = "ativo";
	public static final String PERIODICIDADE = "periodicidade";
	public static final String ID = "id";
	public static final String AGENDADOS = "agendados";
	public static final String DESCRICAO = "descricao";

}

