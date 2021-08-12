package com.backend.basicboard.repos;

import com.backend.basicboard.dto.GuestBookContentDTO;
import com.backend.basicboard.entities.GuestBookContentEntity;
import com.backend.basicboard.entities.QGuestBookContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestBookContentRepo extends JpaRepository<GuestBookContentEntity,Long> {

}
