package com.everis.academia.java.projeto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-10-17T15:41:32.384+0100")
@StaticMetamodel(CervejaEntity.class)
public class CervejaEntity_ {
	public static volatile SingularAttribute<CervejaEntity, Long> id;
	public static volatile SingularAttribute<CervejaEntity, String> beerName;
	public static volatile SingularAttribute<CervejaEntity, String> category;
	public static volatile SingularAttribute<CervejaEntity, Integer> unit;
	public static volatile SingularAttribute<CervejaEntity, Integer> price;
	public static volatile SingularAttribute<CervejaEntity, String> country;
}
