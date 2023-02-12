package com.vn.ec.service;

import com.vn.ec.common.exception.RecordNotFoundException;
import com.vn.ec.entity.Student;
import com.vn.ec.repository.DeleteStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteStudentService {
    private final DeleteStudentRepository deleteStudentRepository;
    public boolean deleteStudent(Long id) {
        Student student = deleteStudentRepository.getStudentById(id);
        if (student==null){
            throw new RecordNotFoundException("user account not fount");
        }
        student.setDeleteFlag(true);
        deleteStudentRepository.save(student);
        return true;
    }
}
