package com.vn.ec.service;

import com.vn.ec.dto.request.CreateStudentRequest;
import com.vn.ec.entity.Student;
import com.vn.ec.repository.CreateStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CreateStudentService {
    private final CreateStudentRepository createStudentRepository;

    @Transactional
    public String createStudent(CreateStudentRequest request) {
        Student student1 = new Student();
        student1.setFullName(request.getFullName());
        student1.setBirthDay(request.getBirthDay());
        student1.setClassName(request.getClassName());
        student1.setMajor(request.getMajor());
        student1.setHometown(request.getHometown());
        student1.setGender(request.getGender());
        student1.setAverageMark(request.getAverageMark());
        createStudentRepository.save(student1);
        return "tạo mới thành công";
    }
}
