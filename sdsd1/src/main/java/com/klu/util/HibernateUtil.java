package com.klu.util;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
	private static SessionFactory factory;
	static {
		factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	public static SessionFactory getSessionFactory()
	{
		return factory;
	}
	
	
	
	
	
	
	
	
	
	
	
//	
////	private static final SessionFactory sessionFactory=new buildSessionFactory();
//	private static final SessionFactory sessionFactory = buildSessionFactory();
//
//	private static SessionFactory buildSessionFactory()
//	{
//		try
//		{
//			return new Configuration().configure().buildSessionFactory();
//		}catch(Exception e)
//		{
//			throw new   ExceptionInInitializerError(e);
//		}
//	}
//	public static SessionFactory getSessionFactory()
//	{
//		return sessionFactory;
//	}
}
