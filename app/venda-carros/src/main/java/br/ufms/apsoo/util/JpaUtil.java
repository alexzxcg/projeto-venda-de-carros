package br.ufms.apsoo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
  private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("crudVendeCarros");

  public static EntityManager geEntityManagerFactory() {
    return FACTORY.createEntityManager();
  }
}
