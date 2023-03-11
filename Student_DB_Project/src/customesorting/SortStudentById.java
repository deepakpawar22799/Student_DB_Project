 package customesorting;

import java.util.Comparator;

import sdbms.Student;

public class SortStudentById implements Comparator<Student> {
public int compare(Student x,Student y) {
	return x.getId().compareTo(y.getId());
}
}
//x -> object to be inserted and  y -> already existing object