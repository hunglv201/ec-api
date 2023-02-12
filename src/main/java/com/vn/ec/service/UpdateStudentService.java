package com.vn.ec.service;

import com.vn.ec.common.Constants;
import com.vn.ec.dto.request.API51UpdatePwdRequest;
import com.vn.ec.entity.Student;
import com.vn.ec.repository.UpdateStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateStudentService {
    private final UpdateStudentRepository updateStudentRepository;
    public String updateStudent(API51UpdatePwdRequest req,Long id) {

        Optional<Student> studentDB = updateStudentRepository.findByIdAndDeleteFlag(id ,Constants.DELETE_FALSE);
        if (studentDB.isEmpty()) {
            return "user not found";
        }
        Student studentNew = studentDB.get();
        studentNew.setFullName(req.getFullName());
        studentNew.setBirthDay(req.getBirthDay());
        studentNew.setClassName(req.getClassName());
        studentNew.setMajor(req.getMajor());
        studentNew.setHometown(req.getHometown());
        studentNew.setGender(req.getGender());
        studentNew.setAverageMark(req.getAverageMark());
        updateStudentRepository.save(studentNew);
        return "success change password";
    }

}
