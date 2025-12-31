package com.klu.app;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.sql.ordering.antlr.Factory;

import com.klu.model.Deptatment;
import com.klu.model.Employee;
import com.klu.util.HibernateUtil;
public class MainApp {
	static SessionFactory factry=HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("1.Insert emply");
			System.out.println("2.View emply");
			System.out.println("2.Update emply salary");
			System.out.println("2.Delete emply");
			System.out.println("5.Exit");
			System.out.println("Enter ur choice=");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				instEmpy(sc);
				break;
			case 2:
				viewEmpy(sc);
				break;
			case 3:
				updEmpy(sc);
				break;
			case 4:
				delEmpy(sc);
				break;
			default:
				System.out.println("Enter the correct choice\n");
			}
		}while(choice!=5);
		factry.close();
		sc.close();
	}
	//-------------Insertion of empy
	private static void instEmpy(Scanner sc)
	{
		Session session=factry.openSession();
		Transaction tx=session.beginTransaction();
		Deptatment dept=new Deptatment();
		System.out.println("Enter the department name=");
		String deptname=sc.next();
		dept.setDeptName(deptname);
//		System.out.println("Enter the department id= ");
//		int id=sc.nextInt();
//		dept.setDeptId(id);
		Employee emp=new Employee();
		System.out.println("Enter the empy name=");
		String empyname=sc.next();
		double sal=sc.nextDouble();
		emp.setEmpName(empyname);
		System.out.println("Enter the emp salary=");
		emp.setEmpSalary(sal);
		
		session.persist(dept);
		session.persist(emp);
		tx.commit();
		session.close();
//		System.out.println("DepartmentName= "+dept.getDeptName());
//		System.out.println("DepartmentId= "+dept.getDeptId());
//		System.out.println("EmployeeName= "+emp.getEmpName());
//		System.out.println("EmployeeSalary= "+emp.getSalary());
		System.out.println("Successsfully inserted");
	}
//	-----------------Read--------------
	private static void viewEmpy(Scanner sc)
	{
		Session session=factry.openSession();
		System.out.println("Enter empy ID= ");
		int id=sc.nextInt();
		Employee emp=session.get(Employee.class,id);
		System.out.println("Employee Details: ");
		if(emp!=null)
		{
			System.out.println("	Name: "+emp.getEmpName());
			System.out.println("	Id: "+emp.getEmpId());
			System.out.println("	Salary: "+emp.getEmpSalary());
			System.out.println("	Salary: "+emp.getDepatment().getDeptName());	
		}
		else
		{
			System.out.println("Enploye not found");
		}
		session.close();
	}
//-------------------Update---------------
	private static void updEmpy(Scanner sc)
	{
		Session session=factry.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Enter the empy id: ");
		int id=sc.nextInt();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null)
		{
			System.out.println("Enter the emp salary= ");
			emp.setEmpSalary(sc.nextDouble());
			tx.commit();
			System.out.println("Employee salary has updated");
		}
		else
		{
			System.out.println("Employee not found");
			tx.rollback();
		}
		session.close();
	}
//----------------delEmpy-----------------------
	private static void delEmpy(Scanner sc)
	{
		Session session=factry.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Enter the empy id=");
		int id=sc.nextInt();
		Employee emp=session.get(Employee.class,id);
		if(emp!=null)
		{
			session.remove(emp);
			tx.commit();
			System.out.println("Employee deleted successfully");
		}
		else
		{
			System.out.println("Employee not found");
		}
	}

}
