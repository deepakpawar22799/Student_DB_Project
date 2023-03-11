package customesorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByName implements Comparator<Student>{
	public int compare(Student x,Student y) {
		return x.getName().compareTo(y.getName());
	}
	}
	//x -> object to be inserted and  y -> already existing object

