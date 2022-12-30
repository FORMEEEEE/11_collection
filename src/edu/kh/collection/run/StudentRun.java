package edu.kh.collection.run;

import edu.kh.collection.model.service.StudentService;
import edu.kh.collection.model.vo.test.People;

public class StudentRun {

	public static void main(String[] args) {

		StudentService st = new StudentService();
		//st.displayMenu();
		People pe = new People();
		
		pe.displayMenu();
	}
	

}
