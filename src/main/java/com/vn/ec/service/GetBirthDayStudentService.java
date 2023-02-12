package com.vn.ec.service;

import com.vn.ec.dto.response.Aip2Response;
import com.vn.ec.dto.response.Aip53Response;
import com.vn.ec.repository.GetBirthDayStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class GetBirthDayStudentService {
    private final GetBirthDayStudentRepository getBirthDayStudentRepository;
    public List<Aip53Response> getBirthDayStudent(){
        long millis=System.currentTimeMillis();
        Date birthDate = new java.sql.Date(millis);
        return getBirthDayStudentRepository.getBirthDayStudent1(birthDate);
    }
}
