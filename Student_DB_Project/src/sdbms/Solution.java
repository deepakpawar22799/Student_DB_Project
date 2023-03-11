package sdbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		System.out.println("Welcome to Student Database Project");
		System.out.println("-----------------------------------");

		Scanner scan = new Scanner(System.in);

		StudentManagementSystem sms = new StudentManagementSystemImpl();

		while(true) {

			System.out.println("n1:Add Student\n2:Display Student");
			System.out.println("n3:displayAllStudent\n4:removeStudent");
			System.out.println("n5:removeAllStudent\n6:updateStudent");
			System.out.println("n7:countStudent\n8:sortStudent");
			System.out.println("n9:getStudentWithHigestMarks\n10:getStudentWithLowestMarks");
			System.out.println("11:Exit");
			
			int choice = scan.nextInt();

			switch(choice) {
			case 1:sms.addStudent();
			break;
			
			case 2:sms.displayStudent();
			break;
			
			case 3:sms.displayAllStudent();
			break;
			
			case 4:sms.removeStudent();
			break;
			
			case 5:sms.removeAllStudent();
			break;
			
			case 6:sms.addStudent();
			break;
			
			case 7:sms.countStudent();
			break;
			
			case 8:sms.sortStudent();
			break;
			
			case 9:sms.getStudentWithHigestMarks();
			break;
			
			case 10:sms.getStudentWithLowestMarks();
			break;
			
			case 11:
				System.out.println("Thank You......");
				System.exit(0);
			break;
			
			default:
				try {
					String message="Invalid Choice Valid Choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
			
			}
			}//end 
			System.out.println("---------------------------");

		}
	}
	}
