package com.backend.basicboard.controllers;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GuestBookContentController {


    @Data
    public class GetRequest {
        private int currentPage;
        private int pageSize;
    }

}
