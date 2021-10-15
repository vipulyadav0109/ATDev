package curdOpration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.pool.OracleDataSource;


public class logic {
		
		public int save(Student s) {
			int row=0;

			 Connection con = null;
			 OracleDataSource ods;
			try {
				ods = new OracleDataSource();
				
				ods.setUser("system");
				ods.setPassword("system");
				ods.setDriverType("thin");
				ods.setServerName("localhost");
				ods.setPortNumber(1521);
				ods.setDatabaseName("xe");
				
				 con=ods.getConnection();

				} catch (Exception e) {
				e.printStackTrace();
			}
		
		    PreparedStatement prp=null;
		
		String QRY ="insert into Student values(?,?,?,?)";
		
		try{ 
			
			prp=con.prepareStatement(QRY);
			
		   	 prp.setInt(1,s.getStudent_no());
			 prp.setString(2,s.getStudent_name());
			 prp.setDate(3,(Date) s.getDob());
			 prp.setDate(4,(Date) s.getDoj());
			 
			
			row=prp.executeUpdate();
		      if (row>0) {
			  System.out.println("record inserted sucessfully");
		          }
			}catch(Exception e) {
			 e.printStackTrace();
		   }
		 return row;
		}

		
		public int updateById(int studId,String name) {
			int row=0;

			 Connection con = null;
			 OracleDataSource ods;
			try {
				ods = new OracleDataSource();
				
				ods.setUser("system");
				ods.setPassword("system");
				ods.setDriverType("thin");
				ods.setServerName("localhost");
				ods.setPortNumber(1521);
				ods.setDatabaseName("xe");
				
				 con=ods.getConnection();

				} catch (Exception e) {
				e.printStackTrace();
			}
				    PreparedStatement prp=null;

		String QRY="update  student set student_name='"+name+"' where student_no="+studId;
		
		   try{ prp=con.prepareStatement(QRY);
			
		        row=prp.executeUpdate();
		        System.out.println("update......");
			
		      }catch(Exception e) {
			   e.printStackTrace();
		       }
		   return row;
		}


		public void getById(int studId) {
			Student stud = new Student();
			
			 Connection con = null;
			 OracleDataSource ods;
			try {
				ods = new OracleDataSource();
				
				ods.setUser("system");
				ods.setPassword("system");
				ods.setDriverType("thin");
				ods.setServerName("localhost");
				ods.setPortNumber(1521);
				ods.setDatabaseName("xe");
				
				 con=ods.getConnection();

				} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement prp;
			ResultSet rs;

			String SELECT_QUERY = "select * from student where student_no=" + studId;
			System.out.println(studId);

			try {
					prp = con.prepareStatement(SELECT_QUERY);
					rs = prp.executeQuery();

				while (rs.next()) {

	System.out.println("Student no=="+rs.getInt("student_no")+"    Student Name=="+rs.getString("student_name")
	+"   Student DOB=="+rs.getDate("student_dob")+"   Student DOJ=="+rs.getDate("student_doj"));       	  

			}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		
		public void deleteById(int studId) {
			Student stud = new Student();
			int row=0;
			 Connection con = null;
			 OracleDataSource ods;
			try {
				ods = new OracleDataSource();
				
				ods.setUser("system");
				ods.setPassword("system");
				ods.setDriverType("thin");
				ods.setServerName("localhost");
				ods.setPortNumber(1521);
				ods.setDatabaseName("xe");
				
				 con=ods.getConnection();

				} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement prp;
			ResultSet rs;
			

			String SELECT_QUERY = "delete from student where student_no=" + studId;
			System.out.println(studId);

			try{ prp=con.prepareStatement(SELECT_QUERY);
			
	        row=prp.executeUpdate();
	        System.out.println("Delete......");
		

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		
		public void getAll() {
			Student stud = new Student();
	 
			Connection con = null;
			 OracleDataSource ods;
			try {
				ods = new OracleDataSource();
				
				ods.setUser("system");
				ods.setPassword("system");
				ods.setDriverType("thin");
				ods.setServerName("localhost");
				ods.setPortNumber(1521);
				ods.setDatabaseName("xe");
				
				 con=ods.getConnection();

				} catch (Exception e) {
				e.printStackTrace();
			}			
			PreparedStatement prp;
			ResultSet rs;

			String SELECT_QUERY = "select * from student";
			try {
					prp = con.prepareStatement(SELECT_QUERY);
					rs = prp.executeQuery();

		while (rs.next()) {
			
         System.out.println("Student no=="+rs.getInt("student_no")+"    Student Name=="+rs.getString("student_name")
			+"   Student DOB=="+rs.getDate("student_dob")+"   Student DOJ=="+rs.getDate("student_doj"));       	  

				}     	
			} catch (Exception e) {
				e.printStackTrace();
			}
		   }
		}


