package com.vn.ec.repository;

import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteStudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select * from student " +
            "where id=:id and delete_flag= false", nativeQuery = true)
    Student getStudentById(Long id);
}
