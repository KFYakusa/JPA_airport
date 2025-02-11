package br.edu.ifsul.modelo;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Passagem.class)
public abstract class Passagem_ {

	public static volatile SingularAttribute<Passagem, Classe> classe;
	public static volatile SingularAttribute<Passagem, Pessoa> pessoa;
	public static volatile SingularAttribute<Passagem, Integer> bagagem;
	public static volatile SingularAttribute<Passagem, Integer> id;
	public static volatile SingularAttribute<Passagem, VooAgendado> vooAgendado;
	public static volatile SingularAttribute<Passagem, Calendar> dataCompra;

	public static final String CLASSE = "classe";
	public static final String PESSOA = "pessoa";
	public static final String BAGAGEM = "bagagem";
	public static final String ID = "id";
	public static final String VOO_AGENDADO = "vooAgendado";
	public static final String DATA_COMPRA = "dataCompra";

}

