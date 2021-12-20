package com.backend.basicboard.services;

import com.backend.basicboard.controllers.GuestBookContentController;
import com.backend.basicboard.entities.GuestBookContentEntity;
import com.backend.basicboard.repos.GuestBookContentRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
    public Page<GuestBookContentEntity> selectPageableList(Pageable pageable){
        return  guestBookContentRepo.findAll(pageable);

    }

    public GuestBookContentEntity createContent(GuestBookContentEntity guestBookContentEntity) {

        guestBookContentEntity.setContentPassword(getSHA512(guestBookContentEntity.getContentPassword()));
        guestBookContentRepo.save(guestBookContentEntity);

        return guestBookContentEntity;
    }

    public GuestBookContentEntity updateContent(GuestBookContentEntity guestBookContentEntity) {
        String pwd = selectOne(guestBookContentEntity.getId()).get().getContentPassword();
        if(comparePassword(guestBookContentEntity.getContentPassword(),pwd)){
            guestBookContentRepo.save(guestBookContentEntity);
        }else{

        }

        return guestBookContentEntity;
    }

    public void deleteContent(Long id) {
        guestBookContentRepo.deleteById(id);
    }

    public Optional<GuestBookContentEntity> selectOne(Long id) {

        Optional<GuestBookContentEntity> result = guestBookContentRepo.findById(id);
        return result;
    }

    public String getSHA512(String pwd) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(pwd.getBytes(StandardCharsets.UTF_8));
            pwd = String.format("%0128x", new BigInteger(1, digest.digest()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pwd;
    }
    public Boolean comparePassword(String pwd,String compare){
        return getSHA512("pwd").equals(compare);
    }
}
