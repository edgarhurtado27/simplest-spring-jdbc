package com.pillarglobal.spring.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pillarglobal.spring.model.Student;
import com.pillarglobal.spring.model.StudentJDBCTemplate;


public class App {
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private static final String ID  = "Id : ";
	private static final String NAME  = "Name : ";
	private static final String AGE  = "Age : ";
	
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("model.application.context.xml");

        StudentJDBCTemplate studentJDBCTemplate = 
                (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        
        // studentJDBCTemplate.create("Zara", 11);
        // studentJDBCTemplate.create("Nuha", 2);
        // studentJDBCTemplate.create("Ayan", 15);
        
        List<Student> students = studentJDBCTemplate.listStudents();
        
        for (Student record : students) {
        	System.out.println("**********");
           System.out.println(ID + record.getId() );
           System.out.println(NAME + record.getName() );
           System.out.println(AGE + record.getAge());
        }
    }
}
