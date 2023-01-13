package com.vn.ec.repository;

import com.vn.ec.dto.response.Aip2Response;
import com.vn.ec.dto.response.Api2ResponseV2;
import com.vn.ec.dto.response.BranchesDto;
import com.vn.ec.dto.response.BranchesDtoV2;
import com.vn.ec.entity.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {
    @Query(value = "select id as branchId, branch_name as branchName " +
            "from branches where delete_flag = false order by id"
            , nativeQuery = true)
    List<BranchesDto> findAllBranch();
    @Query(value = "SELECT br.branchName as BranchName , br.id AS BranchId\n" +
            " FROM Branches  br\n" +
            "WHERE br.deleteFlag = false")
    List<BranchesDto> findAllBranchV2();
    List<BranchesDtoV2> findAllByDeleteFlagFalse();

}
