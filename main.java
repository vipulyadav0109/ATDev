package curdOpration;

import java.sql.Date;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		opration op=new opration();
		op.curd();
	}
}

/*	
Database 
create table student
(
student_no     int    primary key,
student_name   varchar2(30), 
student_dob    date, 
student_doj    date);
*/