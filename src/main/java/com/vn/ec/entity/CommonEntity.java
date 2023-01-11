package com.vn.ec.entity;

import com.vn.ec.utlis.DateTimeUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "created_by")
    private Long createdBy = 0L;

    @Column(name = "updated_by")
    private Long updatedBy = 0L;

    @Column(name = "delete_flag")
    private Boolean deleteFlag = false;

    public void setCommonRegister(Long currentLoginId) {
        this.createdAt = DateTimeUtils.resultTimestamp();
        this.createdBy = currentLoginId;
        this.updatedAt = DateTimeUtils.resultTimestamp();
        this.updatedBy = currentLoginId;
        this.deleteFlag = false;
    }

    public void setCommonUpdate(Long currentLoginId) {
        this.updatedAt = DateTimeUtils.resultTimestamp();
        this.updatedBy = currentLoginId;
    }

    public void setCommonDelete(Long currentLoginId) {
        this.deleteFlag = true;
        setCommonUpdate(currentLoginId);
    }
}
