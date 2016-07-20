package net.squadleader.meetups;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MeetupsDAO {

	private static SessionFactory factory;

	private static void setupFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			;
		}
		Configuration configuration = new Configuration();
		// modify these to match your XML files
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("Meetups.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static int addMeetup(Meetup m) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();

		// save this specific record
		int i = (Integer) hibernateSession.save(m);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return i;
	}

	public static List<Meetup> getAllMeetups() {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		List<Meetup> meetups = hibernateSession.createQuery("FROM meetups").list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return meetups;
	}
}