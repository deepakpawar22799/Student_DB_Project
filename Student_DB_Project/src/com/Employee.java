package com;
 class Employee {
	 String id;
	 String name;
	 
	 static int count = 101;
	 
	 Employee(String name){
		 this.id = "JSP"+count;
		 this.name= name;
		 count++;
	 }
	 
	 public static void main(String[] args) {
		Employee e1 = new Employee("tom");
		System.out.println("Id:"+e1.id+" Name:"+e1.name);
		
		Employee e2 = new Employee("jack");
		System.out.println("Id:"+e2.id+" Name:"+e2.name);
		
		Employee e3 = new Employee("smith");
		System.out.println("Id:"+e3.id+" Name:"+e3.name);
	}
	

}
