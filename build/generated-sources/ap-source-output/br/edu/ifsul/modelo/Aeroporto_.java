package br.edu.ifsul.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aeroporto.class)
public abstract class Aeroporto_ {

	public static volatile SingularAttribute<Aeroporto, Cidade> cidade;
	public static volatile SingularAttribute<Aeroporto, Boolean> operacaoNoturna;
	public static volatile SingularAttribute<Aeroporto, String> nome;
	public static volatile SingularAttribute<Aeroporto, Integer> id;

	public static final String CIDADE = "cidade";
	public static final String OPERACAO_NOTURNA = "operacaoNoturna";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

