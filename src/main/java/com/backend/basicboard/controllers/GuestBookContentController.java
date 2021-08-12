package com.backend.basicboard.controllers;

import com.backend.basicboard.dto.GuestBookContentDTO;
import com.backend.basicboard.services.GuestBookContentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GuestBookContentController {

    private final GuestBookContentService guestBookContentService;

    @Autowired
    GuestBookContentController(final GuestBookContentService guestBookContentService){
        this.guestBookContentService = guestBookContentService;
    }

    @GetMapping("/content")
    public ResponseEntity selectList(GetRequest request){
        final Map<String,Object> jsonObject = new HashMap<>();
//        final GuestBookContentDTO guestBookContentDTO = guestBookContentService.
         jsonObject.put("data","test");
        return new ResponseEntity<>(jsonObject,HttpStatus.OK);
    }

    @Data
    public class GetRequest {
        private int currentPage;
        private int pageSize;
    }

}
