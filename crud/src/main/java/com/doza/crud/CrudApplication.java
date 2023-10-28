package com.doza.crud;

import com.doza.crud.dao.StudentDAO;
import com.doza.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);

			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to ...
		System.out.println("Update student ...");
		myStudent.setFirstName("Doza");
		//update the student
		studentDAO.update(myStudent);
		//display the updates student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Khnykin");
		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudents : theStudents) {
			System.out.println(tempStudents);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object!");
		Student tempStudent = new Student("Daniil", "Khnykin", "daniil@gmail.com");

		//save the student object
		System.out.println("Save the student!");
		studentDAO.save(tempStudent);

		//display id of the saved object
		int theId = tempStudent.getId();

		//retrieve student based on the id; primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//create the 3 student object
		System.out.println("Creating new student object!");
		Student tempStudent1 = new Student("Daniil", "Khnykin", "daniil@gmail.com");
		Student tempStudent2 = new Student("Kris", "Yakhontova", "kris@gmail.com");
		Student tempStudent3 = new Student("Chok", "Chihua", "chok@gmail.com");

		//save the students objects
		System.out.println("Save the students!");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of the saved object
		System.out.println("Saved students.. Generated id: " + tempStudent1.getId());
		System.out.println("Saved students.. Generated id: " + tempStudent2.getId());
		System.out.println("Saved students.. Generated id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object!");
		Student tempStudent = new Student("Daniil", "Khnykin", "daniil@gmail.com");

		//save the student object
		System.out.println("Save the student!");
		studentDAO.save(tempStudent);

		//display id of the saved object
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
