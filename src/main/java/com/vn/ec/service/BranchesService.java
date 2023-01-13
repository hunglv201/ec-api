package com.vn.ec.service;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.dto.response.Api2ResponseV2;
import com.vn.ec.dto.response.BranchesDtoV2;
import com.vn.ec.entity.Branches;
import com.vn.ec.entity.DistrictMaster;
import com.vn.ec.repository.BranchesRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class BranchesService {
    private final BranchesRepository branchesRepository;
    private final ModelMapper mapper;
    public ApiResponse getAllBranch() {
        return ApiResponse.apiResponseCompleted(branchesRepository.findAllBranch());
    }
    public ApiResponse getAllBranchV2() {
        return ApiResponse.apiResponseCompleted(branchesRepository.findAllBranchV2());
    }
    public ApiResponse getAllBranchV3() {
        List<BranchesDtoV2> branchesDtoV2list = branchesRepository.findAllByDeleteFlagFalse();
        List<BranchesDtoV2> branchesDtoV2s = new ArrayList<>();
//        List<BranchesDtoV2> postDtoList = Arrays.asList(mapper.map(branchesDtoV2list, BranchesDtoV2[].class));
        for (int i =0; i<branchesDtoV2list.size();i++){
//            BranchesDtoV2 branchesDtoV2 = new BranchesDtoV2();
//            api2ResponseV2.set(branchesDtoV2list.get(i).get());
//            api2ResponseV2.set(branchesDtoV2list.get(i).get());
            BranchesDtoV2 branchesDtoV2 = mapper.map(branchesDtoV2list.get(i),BranchesDtoV2.class );
            branchesDtoV2s.add(branchesDtoV2);
        }
        return ApiResponse.apiResponseCompleted(branchesDtoV2s);
    }
}
