package com.vn.ec.repository;

import com.vn.ec.dto.response.Aip53Response;
import com.vn.ec.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GetBirthDayStudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT  s.full_name as fullName, s.birth_day as birthDay\n" +
            "FROM student s\n" +
            "WHERE s.birth_day=:birthDate and s.delete_Flag = false", nativeQuery = true)
    List<Aip53Response> getBirthDayStudent1(Date birthDate);
}
