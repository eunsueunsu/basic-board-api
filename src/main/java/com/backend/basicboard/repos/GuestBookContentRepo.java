package com.backend.basicboard.repos;

import com.backend.basicboard.dto.GuestBookContentDTO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestBookContentRepo extends JpaRepository<GuestBookContentDTO,Long> {

}
