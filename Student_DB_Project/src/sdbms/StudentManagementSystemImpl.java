package sdbms;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.management.loading.PrivateClassLoader;

import customesorting.SortStudentByAge;
import customesorting.SortStudentById;
import customesorting.SortStudentByMarks;
import customesorting.SortStudentByName;
import customexception.StudentNotFoundException;

public class StudentManagementSystemImpl  implements StudentManagementSystem{

	Scanner scan=new Scanner(System.in);

	Map<String, Student> db=new LinkedHashMap<String,Student>();


	@Override
	public void addStudent() {
		System.out.println("Enter Student Age: ");
		int age=scan.nextInt();

		System.out.println("Enter Student name:");
		String name=scan.next();

		System.out.println("Enter Student Marks:");
		int marks=scan.nextInt();

		Student std=new Student(age, name, marks);
		db.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is "+std.getId());

	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next();
		id = id.toUpperCase();

		if(db.containsKey(id)) {
			Student std= db.get(id);
			System.out.println("Id:"+std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
		}
		else {
			try {
				String message = "Student with the Id"+id+" is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e){
				System.out.println(e.getMessage());

			}
		}
	}


	@Override
	public void displayAllStudent() {
		if(db.size()!=0) {
			System.out.println("Student Records are as follows");
			System.out.println("--------------------------------");
			Set<String> keys = db.keySet();//JSP101 JSP102 JSP103
			for(String key : keys) {
				Student std = db.get(key);
				System.out.println(std); // System.Out.println(db.get(Key));
			}
		}
		else {
			try {
				String message ="Student Database is Empty, Nothing to Display";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next();
		id = id.toUpperCase();


		if(db.containsKey(id)) {
			System.out.println("Student Record Succesfully");
			System.out.println(db.get(id));
			db.remove(id);
			System.out.println("Student Record Deleted Successfully");
		}
		else
		{
			try {
				String message ="Student with Id "+id+" is not Found";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	@Override
	public void removeAllStudent() {
		if(db.size() !=0) {
			System.out.println("Available Student Records:"+db.size());
			db.clear();
			System.out.println("All the Student record deleted Successfully");
		}
		else {
			try {
				String message ="Student Database is Empty, Nothing to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next();
		id = id.toUpperCase();

		if(db.containsKey(id)) {
			Student std = db.get(id);

			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age:");
				int age =scan.nextInt();
				std.setAge(age); //std.setAge(scan.nextInt());
				System.out.println("Age Updated SuccessFully");
				break;

			case 2:
				System.out.println("Enter Name:");
				String name =scan.next();
				std.setName(name); //std.setName(scan.next());
				System.out.println("Name Updated SuccessFully");
				break;

			case 3:
				System.out.println("Enter Marks:");
				int marks =scan.nextInt();
				std.setMarks(marks); //std.setMarks(scan.nextInt());
				System.out.println("Marks Updated SuccessFully");
				break;
			default:
				try {
					String message ="Invalid Choice, Enter Valid Choice";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
		}
		else {
			try {
				String message ="Invalid Choice, Enter Valid Choice";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}


	}

	@Override
	public void countStudent() {
		System.out.println("Avaliable Student Records:"+db.size());


	}

	@Override
	public void sortStudent() {
		if(db.size()>=2) {


			Set<String> keys = db.keySet();
			List<Student> list =new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(keys));
			}

			System.out.println("1:Sort Student By Id:\n2:Sort Student By Age");
			System.out.println("3:Sort Student By Name:\n4:Sort Student By Marks");
			System.out.println("Enter Choice:");
			int choice = scan.nextInt();

			switch(choice) {
			case 1:
				Collections.sort(list, new SortStudentById());
				display(list);

				break;

			case 2:
				Collections.sort(list, new SortStudentByAge());
				display(list);
				break;

			case 3:
				Collections.sort(list, new SortStudentByName());
				display(list);
				break;

			case 4:
				Collections.sort(list, new SortStudentByMarks());
				display(list);
				break;
			default:
				try {
					String message ="Invalid Choice, Enter Valid Choice";
					throw new StudentNotFoundException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
              }
			}
		else{
			try {
				String message ="No Sufficient Student Records to Sort";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void display(List<Student> list) {
		for(Student s :list) {
			System.out.println(s);
		}
	}




	@Override
	public void getStudentWithHigestMarks() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Student> list =new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(keys));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(db.size()));
		}  else {
			try {
				String message ="No Sufficent Student Records Found to sort";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());

			}
		}
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Student> list =new ArrayList<Student>();
			for(String key : keys) {
				list.add(db.get(keys));
			}
			Collections.sort(list,new SortStudentByMarks());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message ="No Sufficent Student Records to Compare";
				throw new StudentNotFoundException(message);
			}
			catch(StudentNotFoundException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}






















