package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/config.xml");
		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press 1: insert student record..");
		System.out.println("Press 2: get single student record..");
		System.out.println("Press 3: get All students record..");
		System.out.println("Press 4: Update student record..");
		System.out.println("Press 5: Dalete student record..");
		System.out.println("Press 6: Exit..");
		System.out.println("App is Ready: Please Enter value\n");
		boolean go = true;
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		while (go) {
			try {
				int value = Integer.parseInt(br.readLine()); 
				switch (value) {
				case 1: 
					try {  
						System.out.println("Enter your Student ID: ");
						int id = Integer.parseInt(br1.readLine());
						System.out.println("Enter your Name: ");
						String name = br1.readLine();
						System.out.println("Enter your City: ");
						String city = br1.readLine(); 
						Student st = new Student();
						st.setStudentId(id);
						st.setStudentName(name);
						st.setStudentCity(city);
						if(0<id && name !=null && city!=null) {
							dao.insert(st);
							System.out.println("Inserted student record..");
							System.out.println("You want to continue more opretions\nenter input otherwise press 6 to Exit program..!!");
							
						}else {
							System.out.println("record not Inserted something is missing..\n");
						}
					} catch (Exception e) { 
						System.out.println("Please enter valid input: \n");
					}
					break;
				case 2:
					try {
						System.out.println("Enter student ID to get record..");
						int i = Integer.parseInt(br1.readLine());
						Student student = dao.getStudent(i);
						System.out.println("\nSingle Record: "+student); 
					} catch (Exception e) { 
						System.out.println("Record not found..!");
						System.out.println("Please enter valid student ID: \n");
					}
					break;
				case 3:
					System.out.println("All students record..");  
					System.out.println("All records: "+dao.getAllStudents());
					break;
				case 4: 
					try {
						System.out.println("Enter your Student ID: ");
						int uid = Integer.parseInt(br1.readLine());
						System.out.println("Enter your Name: ");
						String uname = br1.readLine();
						System.out.println("Enter your City: ");
						String ucity = br1.readLine(); 
						Student ust = new Student(uid,uname,ucity); 
						if(0<uid && uname !=null && ucity!=null) {
							dao.updateStudent(ust);
							System.out.println("Updated student record..");
							System.out.println("You want to continue more opretions\nenter input otherwise press 6 to Exit program..!!");
							
						}else {
							System.out.println("record not Inserted something is missing..\n");
						}
					} catch (Exception e) { 
						System.out.println("Record not found..!");
						System.out.println("Please enter valid student ID: \n");
					}
					
					break;
				case 5:
					try {
						System.out.println("Enter student ID to Delete record..");
						int di = Integer.parseInt(br1.readLine());
						dao.deleteStudent(di);
						System.out.println("\nRecord Deleted..!!");
					} catch (Exception e) {
						System.out.println("Record not found..!");
						System.out.println("Please enter valid student ID: \n");
					}
					break;
				case 6:
					go=false;
					System.out.println("Exit..");
					break;
				default: 
						System.out.println("Please enter valid input...!!");
						System.out.println("Press 1: insert student record..");
						System.out.println("Press 2: get single student record..");
						System.out.println("Press 3: get All students record..");
						System.out.println("Press 4: Update student record..");
						System.out.println("Press 5: Dalete student record..");
						System.out.println("Press 6: Exit..");
					break;
				}
			} catch (Exception e) {
				System.out.println("Input something went wrong...!!");
				e.printStackTrace();
			}
		}
	}

}
