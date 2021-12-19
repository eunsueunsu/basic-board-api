package com.backend.basicboard.controllers;

import com.backend.basicboard.dto.GuestBookContentDTO;
import com.backend.basicboard.entities.GuestBookContentEntity;
import com.backend.basicboard.services.GuestBookContentService;
import lombok.Data;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GuestBookContentController {

    private final GuestBookContentService guestBookContentService;

    @Autowired
    GuestBookContentController(final GuestBookContentService guestBookContentService) {
        this.guestBookContentService = guestBookContentService;
    }

    @GetMapping("/content/{id}")
    public ResponseEntity selectOne(@PathVariable Long id, GetRequest request) {
        Optional<GuestBookContentEntity> result = guestBookContentService.selectOne(id, request);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/contents")
    public ResponseEntity selectList(@RequestBody GetRequest request) {
        final Map<String, Object> jsonObject = new HashMap<>();
        List<GuestBookContentEntity> list = guestBookContentService.selectList(request);
        jsonObject.put("data", list);
        return new ResponseEntity<>(jsonObject, HttpStatus.OK);
    }

    // TODO : postRequest로 변경 / 예외처리 / pwd 암호화
    @PostMapping("/content")
    public ResponseEntity create(@RequestBody PostRequest postRequest) {
        GuestBookContentEntity guestBookContentEntity = new GuestBookContentEntity();
        guestBookContentEntity.setContentPassword(postRequest.contentPassword);
        guestBookContentEntity.setAuthorIp(postRequest.authorIp);
        guestBookContentEntity.setText(postRequest.text);
        guestBookContentEntity.setAuthorId(postRequest.authorIp);
        GuestBookContentEntity savedEntity = guestBookContentService.createContent(guestBookContentEntity);
        return new ResponseEntity(savedEntity, HttpStatus.OK);
    }

    @PutMapping("/content/{id}")
    public ResponseEntity update(GuestBookContentEntity guestBookContentEntity) {
        GuestBookContentEntity updatedEntity = guestBookContentService.updateContent(guestBookContentEntity);
        return new ResponseEntity(updatedEntity, HttpStatus.OK);
    }

    @DeleteMapping("/content/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        guestBookContentService.deleteContent(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @Data
    public static class GetRequest {
        private int currentPage;
        private int pageSize;
    }

    @Data
    public static class PostRequest {

        private String authorId;
        private String text;
        private String authorIp;
        private String contentPassword;


    }

}
