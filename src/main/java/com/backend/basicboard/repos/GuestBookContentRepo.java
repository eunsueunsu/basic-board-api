package com.backend.basicboard.repos;

import com.backend.basicboard.dto.GuestBookContentDTO;
import com.backend.basicboard.entities.GuestBookContentEntity;
import com.backend.basicboard.entities.QGuestBookContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GuestBookContentRepo extends JpaRepository<GuestBookContentEntity, Long> {

    List<GuestBookContentEntity> findAll();


}
