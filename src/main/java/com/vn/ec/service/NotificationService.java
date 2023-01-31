package com.vn.ec.service;

import com.vn.ec.dto.request.NotificationRequest;
import com.vn.ec.dto.response.NotificationsResponse;
import com.vn.ec.dto.response.PageBase;
import com.vn.ec.repository.NotificationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.vn.ec.utlis.Utils.SIZE_PAGE;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationsRepository notificationsRepository;
    public  PageBase getByUserId(NotificationRequest request){
        Pageable pageable= PageRequest.of(request.getCurrentPage(),3);
        Page<NotificationsResponse> listNotification=notificationsRepository.getListNotification(request.getUserId(),pageable);
//        PageBase pageBase=PageBase.builder()
//                .currentPage(request.getCurrentPage())
//                .total(objects.getTotalElements())
//                .totalPages(objects.getTotalPages())
//                .perPage(SIZE_PAGE)
//                .build();

        PageBase pageBase1 = new PageBase();
        pageBase1.setCurrentPage(request.getCurrentPage());
        pageBase1.setPerPage(3);
        pageBase1.setTotal(listNotification.getTotalElements());
        pageBase1.setTotalPages(listNotification.getTotalPages());
        pageBase1.setResult(listNotification.getContent());
        return pageBase1;
    }
}
