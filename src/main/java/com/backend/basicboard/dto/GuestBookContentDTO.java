package com.backend.basicboard.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
//@Builder
public class GuestBookContentDTO {

    private Long id;
    private String text;
    private Long authorId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;
    private String contentPassword;
    private String authorIp;
}
