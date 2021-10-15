package curdOpration;

import java.sql.Date;
import java.util.Scanner;

public class opration {
  public void curd() {
	  Scanner sc=new Scanner(System.in);
		Student s= new Student();
		logic op= new logic();
		opration op1=new opration();



		System.out.println("Enter Your choices \n1.Save 2.Update 3.GetOne 4.GetAll 5.Delete 6.Exit");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("Enter Student Number");
			int no=sc.nextInt();
			
			System.out.println("Enter Student Name");
			String name=sc.next();
			
			System.out.println("Enter Student Brith Date YYYY,MM,DD");
			System.out.println("If you in 1900 press 1 And If you in 2000 press 2: ");
			String y="";

			int n=sc.nextInt();
			if(n==1) {
				y="0";
			}
			else if(n==2) { 
				y="1";
			}
			else { 
				System.out.println("Wrong key pressed..");
				op1.curd();

			}
			System.out.println("Enter Only Last 2 digit of Brith Year (example 99,98,94,16,02,18):");
               String yy=sc.next();
			String yyy=y+yy;
			
			int yyyy=Integer.parseInt(yyy);
		
			
			System.out.println("Enter Brith Month :");
			int m=sc.nextInt();
			System.out.println("Enter Brith Day :");
			int d=sc.nextInt();
			
			java.util.Date udob=new Date(yyyy,m-1,d);
			java.sql.Date dob = new java.sql.Date(udob.getTime());

			
			System.out.println("Enter Student Join Date YYYY,MM,DD");
			System.out.println("If you in 1900 press 1 And If you in 2000 press 2: ");
			String y1="";

			int n1=sc.nextInt();
			if(n1==1) {
				y1="0";
			}
			else if(n1==2) { 
				y1="1";
			}
			else { 
				System.out.println("Wrong key pressed..");
				op1.curd();

			}
			System.out.println("Enter Only Last 2 digit of Brith Year (example 99,98,94,16,02,18):");
               String yy1=sc.next();
			String yyy1=y1+yy1;
			
			int yyyy1=Integer.parseInt(yyy1);
			System.out.println("Enter Join Month :");
			int mm=sc.nextInt();
			System.out.println("Enter Join Day :");
			int dd=sc.nextInt();
			
			java.util.Date udoj=new Date(yyyy1,mm-1,dd);
			java.sql.Date doj = new java.sql.Date(udoj.getTime());
			
			
		    s.setStudent_no(no);
			s.setStudent_name(name);
			s.setDob(dob);
			s.setDoj(doj);
			op.save(s);	
			op1.curd();
			break;
			
	        

		case 2:
			System.out.println("Enter new Name :");
			String nm=sc.next();
			System.out.println("Enter old student_no :");
			int id=sc.nextInt();
			op.updateById(id,nm);
			op1.curd();
			
			break;
		case 3:
			System.out.println("Enter Student Number for getting record:");
			int studId =sc.nextInt();
			op.getById(studId);
			op1.curd();
			break;
		case 4:
			op.getAll();
			op1.curd();
			break;
		case 5:
			System.out.println("Enter Student Number for delete record:");
			int studId1 =sc.nextInt();
			op.deleteById(studId1);
			op1.curd();
			break;
		case 6:
			System.exit(choice);
		 default:
			System.out.println("Wrong key Entered..!");
			op1.curd();
					
		}	
	  
  }
}
