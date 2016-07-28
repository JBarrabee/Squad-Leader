package net.squadleader.people;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class PeopleDAO {

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
		configuration.addResource("People.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static int addPerson(Person p) throws NoSuchAlgorithmException {
//		String pass = MD5Encoder(p.getPASS().toString());
//	    p.setPASS(pass);
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();

		// save this specific record
		int i = (Integer) hibernateSession.save(p);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return i;
	}

	public static List<Person> getAllPeople() {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		List<Person> People = hibernateSession.createQuery("FROM Person").list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return People;
	}

	public static boolean checkLogin(Person person) {
		if (factory == null)
			setupFactory();
		
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		
		String email = "'" + person.getEMAIL() + "'";
		String hql = "SELECT PASS FROM Person WHERE EMAIL = "+email;
		List query = hibernateSession.createQuery(hql).list();
		
		if(!query.isEmpty() && query.get(0).equals(person.getPASS()))
			return true;
		
		return false;
	}

	public static boolean containsPerson(Person person) {
		if (factory == null)
			setupFactory();
		
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		
		String email = "'" + person.getEMAIL() + "'";
		String hql = "FROM Person WHERE EMAIL = "+email;
		Query query = hibernateSession.createQuery(hql);
		List results = query.list();
		
		if(results.isEmpty())
			return false;
		
		return true;
	}
	
	private static String MD5Encoder( String password ) throws NoSuchAlgorithmException
	{
    	MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < byteData.length; i++) 
        {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 5).substring(1));
        }
        
        return sb.toString();
	}
}