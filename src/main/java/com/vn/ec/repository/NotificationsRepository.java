package com.vn.ec.repository;

import com.vn.ec.dto.response.NotificationsResponse;
import com.vn.ec.entity.Notifications;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    @Query(value = "SELECT n.id as id , n.title as title, " +
            " n.type as type," +
            " n.summary as summary," +
            " n.unread AS unread, " +
            "n.redirect_url AS redirectUrl, " +
            "n.created_at AS createAt,\n" +
            "i.image_url as imageUrl "+
            "FROM notifications n  LEFT JOIN images i on i.id= n.image_id" +
            " WHERE n.customer_id = :userId " +
            " AND n.delete_flag = false order by  id",nativeQuery = true)
    Page<NotificationsResponse> getListNotification(@Param("userId") Long id, Pageable pageable);

}
