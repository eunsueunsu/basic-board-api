package com.backend.basicboard.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "guest_book_content")
@NoArgsConstructor
public class GuestBookContentEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "author_id")
    private String authorId;

    @Column(name = "created_at" ,columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at" , columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private ZonedDateTime updatedAt;

    @Column(name = "deleted_at")
    private ZonedDateTime deletedAt;

    @Column(name = "content_password")
    private String contentPassword;

    @Column(name = "author_ip")
    private String authorIp;





}
