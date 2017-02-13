package com.abyeti.Bookmanagement1;

import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.abyeti.persistence.HibernateUtil;

public class auth {
	public static Scanner scan = new Scanner(System.in);

	public static boolean login()
   {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
   		System.out.print("Enter Your ID: ");
			Integer userid=scan.nextInt();
		   User user = (User)session.get(User.class, userid);
			if(user==null)
		   {
		      System.out.println("User with UserID="+userid+" not found");
		      return false;
		   }
			if(user.isAdmin()==false)
		   {
		      System.out.println("Sorry You are not an admin");
		      return false;
		   }
         tx.commit();
			return true;
      }
      catch (HibernateException e)
      {
         if (tx!=null) tx.rollback();
         e.printStackTrace();
      }
      finally
      {
         session.close();
      }
      return false;
   }


}
