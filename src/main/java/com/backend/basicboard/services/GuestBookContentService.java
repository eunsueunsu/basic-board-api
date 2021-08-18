package com.backend.basicboard.services;

import com.backend.basicboard.controllers.GuestBookContentController;
import com.backend.basicboard.entities.GuestBookContentEntity;
import com.backend.basicboard.repos.GuestBookContentRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestBookContentService {


    private final JPAQueryFactory jpaQueryFactory;
    private final GuestBookContentRepo guestBookContentRepo;

    @Autowired
    GuestBookContentService(final JPAQueryFactory jpaQueryFactory, final GuestBookContentRepo guestBookContentRepo) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.guestBookContentRepo = guestBookContentRepo;
    }

    public List<GuestBookContentEntity> selectList(final GuestBookContentController.GetRequest request) {
        List<GuestBookContentEntity> list = guestBookContentRepo.findAll();
        return list;
    }

    public GuestBookContentEntity createContent(GuestBookContentEntity guestBookContentEntity) {
        guestBookContentRepo.save(guestBookContentEntity);
        return guestBookContentEntity;
    }


    public GuestBookContentEntity updateContent(GuestBookContentEntity guestBookContentEntity) {
        guestBookContentRepo.save(guestBookContentEntity);
        return guestBookContentEntity;
    }

    public void deleteContent(Long id) {
        guestBookContentRepo.deleteById(id);
    }

    public Optional<GuestBookContentEntity> selectOne(Long id, GuestBookContentController.GetRequest request) {

        Optional<GuestBookContentEntity> result = guestBookContentRepo.findById(id);
        return result;
    }
}
