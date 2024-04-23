/**
 * 
 */
package com.org.fb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.fb.entity.Student;

/**
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
