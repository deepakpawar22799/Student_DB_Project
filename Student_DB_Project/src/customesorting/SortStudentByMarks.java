package customesorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentByMarks implements Comparator<Student> {
	public int compare(Student x,Student y) {
		return x.getMarks()-y.getMarks();
	}
	}
	//x -> object to be inserted and  y -> already existing object

