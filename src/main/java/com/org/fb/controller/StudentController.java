/**
 * 
 */
package com.org.fb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.fb.entity.Student;
import com.org.fb.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * https://docs.spring.io/spring-data/jpa/reference/jpa.html
 */
@Controller
@Slf4j
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@RequestMapping(value = "/getcount", method = RequestMethod.GET)
	@ResponseBody
	public String getCount() {
		log.debug("Total Rows found" + studentRepository.count());
		return String.valueOf(studentRepository.count());
	}

	@RequestMapping(value = "/createstudent", method = RequestMethod.POST)
	@ResponseBody
	public Student createStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}

	@RequestMapping(value = "/updatestudent", method = RequestMethod.PUT)
	@ResponseBody
	public Student updateStudent(@RequestBody Student student, @RequestHeader String id) {
		Optional<Student> student2 = studentRepository.findById(Integer.parseInt(id));
		if (student2.isPresent()) {
			student2.get().setAddress(student.getAddress());
			student = student2.get();
			student.setGender("M");
			studentRepository.save(student);
		}
		return student;

	}

}
