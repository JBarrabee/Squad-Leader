package net.squadleader.links;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class LinksDAO {

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
		configuration.addResource("Links.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static int addLink(Links l) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();

		// save this specific record
		int i = (Integer) hibernateSession.save(l);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return i;
	}
	
	public static List<Links> listLinks() {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		List<Links> linkslist = hibernateSession.createQuery("FROM Links").list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return linkslist;
	}
	public static List<Links> listByCatLinks(String cat) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		//Query query = hibernateSession.createQuery("FROM Links");
		Criteria crit = hibernateSession.createCriteria(Links.class);
		List<Links> linkslist = crit.add(Restrictions.eq("Category", cat)).list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return linkslist;
	}
	
	
	
	
}
