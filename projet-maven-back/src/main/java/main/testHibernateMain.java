package main;

import java.util.List;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.ClientEntity;

public class testHibernateMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
		try {
			persist(sessionFactory);
			load(sessionFactory);
		} catch (HibernateError error) {
			System.out.println(error);
		} finally {
			sessionFactory.close();
		}

	}
	
	private static void load(SessionFactory sessionFactory) {
	      System.out.println("-- loading persons --");
	      Session session = sessionFactory.openSession();
	      @SuppressWarnings("unchecked")
	      List<ClientEntity> persons = session.createQuery("FROM ClientEntity").list();
	      persons.forEach((x) -> System.out.printf("- %s%n", x));
	      session.close();
	  }

	  private static void persist(SessionFactory sessionFactory) {
	      ClientEntity p1 = new ClientEntity("John", "Doe");
	      ClientEntity p2 = new ClientEntity("Tina", "Turner");
	      System.out.println("-- persisting persons --");
	      System.out.printf("- %s%n- %s%n", p1, p2);

	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      session.save(p1);
	      session.save(p2);
	      session.getTransaction().commit();
	  }

}
