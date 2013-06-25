/**
 * 
 */
package br.ufc.si.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author Virginia
 *
 */

@SuppressWarnings("deprecation")
@ApplicationScoped
@Component
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	private HibernateUtil() {
	}
	
	public static Session getSession() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory.openSession();
	}

}
