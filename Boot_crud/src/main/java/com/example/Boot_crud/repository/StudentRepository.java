package com.example.Boot_crud.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Boot_crud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByNameLike(String search);

	List<Student> findByMobile(long num);

	List<Student> findByEmailLike(String search);
}
