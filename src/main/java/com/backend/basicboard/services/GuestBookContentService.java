package com.backend.basicboard.services;

import com.backend.basicboard.controllers.GuestBookContentController;
import com.backend.basicboard.repos.GuestBookContentRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookContentService {


    private final JPAQueryFactory jpaQueryFactory;
    private final GuestBookContentRepo guestBookContentRepo;

    @Autowired
    GuestBookContentService(final JPAQueryFactory jpaQueryFactory, final GuestBookContentRepo guestBookContentRepo){
        this.jpaQueryFactory = jpaQueryFactory;
        this.guestBookContentRepo = guestBookContentRepo;
    }

    private void selectList(final GuestBookContentController.GetRequest request) {
//        return GuestBookContentDTO
    }
}
