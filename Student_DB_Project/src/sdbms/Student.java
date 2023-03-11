package sdbms;

public class Student {
	private String id;
	private int age;
	private String name;
	private int marks;
	
	static int count=101;
	
	Student(int age,String name,int marks){
		this.id="JSP"+count;
		this.age=age;
		this.name=name;
		this.marks=marks;
		count++;
	}
	

	@Override
	public String toString() {
		return "Id:"+id+" Age:"+age+"  Name:"+name+" Marks:"+marks ;
	}


	public String getId() {
		return id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	

	
	
	
	
	
	
	
	
	
}
