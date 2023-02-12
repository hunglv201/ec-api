package com.vn.ec.repository;

import com.vn.ec.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UpdateStudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByIdAndDeleteFlag(Long id, Boolean delFlag);
}
