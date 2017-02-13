package com.abyeti.Bookmanagement1;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.abyeti.persistence.HibernateUtil;

public class functionimpl implements function {
	public static Scanner scan = new Scanner(System.in);

	   
	 public  void listallBook( )
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	         List<Book> allbooks = session.createQuery("FROM Book").list();
	         for (Iterator iterator = allbooks.iterator(); iterator.hasNext();)
	         {
	            Book book = (Book) iterator.next();
	            System.out.println("Book : " + book.getbkname());
	            System.out.println("\tISBN: " + book.getisbn());
	            System.out.println("\tAuthor ID: " + book.getauthorid());
	            System.out.println("\tEdition: " + book.getedition());
	            System.out.println("\tPrice: " + book.getprice());
	            System.out.println("\tAvailable Units: " + book.getavailable_units());
	            System.out.print("\n");
	         }
	      tx.commit();
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
	   }

	   public  void addBook()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();

	         System.out.print("Enter Book ISBN: ");
	         long isbn=scan.nextLong();
	         Book bk1 = (Book)session.get(Book.class, isbn);
				if(bk1!=null)
			   {
					System.out.println("Book with ISBN="+isbn+" already exists");
					return;
				}
	         Book bk = new Book();
				bk.setisbn(isbn);
	         System.out.print("Enter Book name: ");
	         bk.setbkname(scan.next());
	         System.out.print("Enter Author (user id): ");
				Integer userid=scan.nextInt();
	         User user = (User)session.get(User.class, userid);
				if(user==null)
			   {
					System.out.println("User with UserID="+userid+" not found");
					return;
				}
	         bk.setauthorid(userid);
	         System.out.print("Enter Book Edition: ");
	         bk.setedition(scan.next());
	         System.out.print("Enter Book price: ");
	         bk.setprice(scan.nextInt());
	         System.out.print("Enter Available Units: ");
	         bk.setavailable_units(scan.nextInt());

	         session.save(bk);
				System.out.println("Book of ISBN = "+bk.getisbn()+" has been created successfully");
				tx.commit();
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
	   }

	   public  void updateBook()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter Book ISBN to be updated: ");
	   		long isbn= scan.nextLong();
	         Book bk = (Book)session.get(Book.class, isbn);
				if(bk==null)
			   {
				   System.out.println("Book with ISBN="+isbn+" does not exists");
				   return;
				}
	         System.out.print("Enter Updated Book price: ");
	         bk.setprice(scan.nextInt());
	         System.out.print("Enter Updated Available Units: ");
	         bk.setavailable_units(scan.nextInt());
	         session.update(bk);
	         tx.commit();
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
	   }

	   public  void deleteBook()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter Book ISBN to be deleted: ");
	   		long isbn= scan.nextLong();
	         Book bk = (Book)session.get(Book.class, isbn);
				if(bk==null)
			   {
				   System.out.println("Book with ISBN="+isbn+" does not exists");
				   return;
				}
	         bk.setavailable_units(0);
	         session.update(bk);
	         tx.commit();
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
	   }

	   public void displayBook( )
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter Book ISBN: ");
	   		long isbn= scan.nextLong();
	         Book book = (Book)session.get(Book.class, isbn);
				if(book.getisbn()!=isbn)
				{
				   System.out.println("Book with ISBN="+isbn+" does not exists");
				   return;
				}
	         System.out.println("Book : " + book.getbkname());
	         System.out.println("\tISBN: " + book.getisbn());
	         System.out.println("\tAuthor ID: " + book.getauthorid());
	         System.out.println("\tEdition: " + book.getedition());
	         System.out.println("\tPrice: " + book.getprice());
	         System.out.println("\tAvailable Units: " + book.getavailable_units());
	         System.out.print("\n");
	         tx.commit();
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
	   }
	   //-------------------Book Functions END---------------//

       

	   
	   public  void listallUser( )
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	         List<User> allusers = session.createQuery("FROM User").list();
	         for (Iterator iterator = allusers.iterator(); iterator.hasNext();)
	         {
	            User user = (User) iterator.next();
	            System.out.println("User ID : " + user.getUserid());
	            System.out.println("\tUserName: " + user.getUsername());
	            System.out.println("\tMobile: " + user.getMobile());
	            System.out.print("\n");
	         }
	      tx.commit();
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
	   }

	   public void addUser()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	         User user = new User();

	         System.out.print("Enter UserName: ");
	         user.setUsername(scan.next());
	         System.out.print("Enter Mobile Number: ");
	         user.setMobile(scan.nextLong());
	         System.out.print("Is user admin (y/n): ");
				String ip=scan.next();
				if(ip.equals("y"))
					user.setAdmin(true);
				else
					user.setAdmin(false);

	         session.save(user);
				System.out.println("User of ID = "+user.getUserid()+" has been created successfully");
	         tx.commit();
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
	   }

	   public  void updateUser()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter User ID to be updated: ");
				Integer userid=scan.nextInt();
			   User user = (User)session.get(User.class, userid);
				if(user==null)
			   {
			      System.out.println("User with UserID="+userid+" not found");
			      return;
			   }
	         System.out.print("Enter Updated UserName: ");
	         user.setUsername(scan.next());
	         System.out.print("Enter Updated Mobile Number: ");
	         user.setMobile(scan.nextLong());
	         session.update(user);
	         tx.commit();
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
	   }

	   public  void deleteUser()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter User ID to be deleted: ");
				Integer userid=scan.nextInt();
			   User user = (User)session.get(User.class, userid);
				if(user==null)
			   {
			      System.out.println("User with UserID="+userid+" not found");
			      return;
			   }
	         session.delete(user);
	         tx.commit();
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
	   }

	   public  void displayUser( )
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter User ID: ");
				Integer userid=scan.nextInt();
			   User user = (User)session.get(User.class, userid);
				if(user==null)
			   {
			      System.out.println("User with UserID="+userid+" not found");
			      return;
			   }
				System.out.println("User ID : " + user.getUserid());
				System.out.println("\tUserName: " + user.getUsername());
				System.out.println("\tMobile: " + user.getMobile());
				System.out.print("\n");
	         tx.commit();
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
	   }


	   
	   
	   //-------------------User Functions END---------------//


	   // -----------------Sale Functions Start---------------//
	   public  void listallSale( )
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	         List<Sale> allsales = session.createQuery("FROM Sale").list();
	         for (Iterator iterator = allsales.iterator(); iterator.hasNext();)
	         {
	            Sale sale = (Sale) iterator.next();
	            System.out.println("Sale ID : " + sale.getSaleid());
	            System.out.println("\tBook ISBN: " + sale.getIsbn());
	            System.out.println("\tUser ID: " + sale.getUserid());
	            System.out.println("\tNo. of copies: " + sale.getQuantity());
	            System.out.println("\tDate: " + sale.getDate());
	            System.out.print("\n");
	         }
	      tx.commit();
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
	   }

	   public  void addSale()
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	         Sale sale = new Sale();

	         System.out.print("Enter Book ISBN: ");
	   		long isbn= scan.nextLong();
	         Book bk = (Book)session.get(Book.class, isbn);
				if(bk==null)
			   {
				   System.out.println("Book with ISBN="+isbn+" does not exists");
				   return;
				}
	         sale.setIsbn(isbn);
	         System.out.print("Enter User ID: ");
				Integer userid=scan.nextInt();
			   User user = (User)session.get(User.class, userid);
				if(user==null)
			   {
			      System.out.println("User with UserID="+userid+" not found");
			      return;
			   }
	         sale.setUserid(userid);
	         System.out.print("How many copies: ");
				Integer qty=scan.nextInt();
				if(bk.getavailable_units()<qty)
				{
					System.out.println("Sorry! only "+bk.getavailable_units()+" left, press y to buy "+bk.getavailable_units()+" copies, else press n");
					String ip=scan.next();
					if(ip=="y")
					{
						qty=bk.getavailable_units();
					}
					else
					{
						return;
					}


		         session.update(bk);
				}
	         sale.setQuantity(qty);

	         session.save(sale);
				System.out.println("Sale of ID = "+sale.getSaleid()+" has been created successfully");
	         tx.commit();
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
	   }

	   public  void displaySale( )
	   {
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try
	      {
	         tx = session.beginTransaction();
	   		System.out.print("Enter Sale ID: ");
	   		Integer saleid= scan.nextInt();
	         Sale sale = (Sale)session.get(Sale.class, saleid);
				if(sale==null)
			   {
					System.out.println("Sale with ID="+saleid+" does not exists");
					return;
				}
				System.out.println("Sale ID : " + sale.getSaleid());
				System.out.println("\tBook ISBN: " + sale.getIsbn());
				System.out.println("\tUser ID: " + sale.getUserid());
				System.out.println("\tNo. of copies: " + sale.getQuantity());
				System.out.println("\tDate: " + sale.getDate());
				System.out.print("\n");
	         tx.commit();
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
	   }
	   //-------------------Sale Functions END---------------//

}
