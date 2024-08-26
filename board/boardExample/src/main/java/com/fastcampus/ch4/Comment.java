//package com.fastcampus.ch4;
//
//import java.time.LocalDateTime;
//
//public class Comment {
//    private Integer id;            // 댓글의 고유 ID
//    private String writer;         // 댓글 작성자
//    private String content;        // 댓글 내용
//    private Integer password;      // 댓글 수정/삭제 시 사용할 비밀번호
//    private LocalDateTime created; // 댓글 작성일
//    private LocalDateTime updated; // 댓글 수정일
//    private Integer postId;        // 댓글이 속한 게시글의 ID
//    private Integer parentId;      // 부모 댓글의 ID (답글일 경우)
//
//    // 기본 생성자
//    public Comment() {}
//
//    // 매개변수가 있는 생성자 (자동 생성 및 시간 관련 필드 제외)
//    public Comment(String writer, String content, Integer password, Integer postId, Integer parentId) {
//        this.writer = writer;
//        this.content = content;
//        this.password = password;
//        this.postId = postId;
//        this.parentId = parentId;
//    }
//
//    // Getter와 Setter 메서드
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getWriter() {
//        return writer;
//    }
//
//    public void setWriter(String writer) {
//        this.writer = writer;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Integer getPassword() {
//        return password;
//    }
//
//    public void setPassword(Integer password) {
//        this.password = password;
//    }
//
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }
//
//    public LocalDateTime getUpdated() {
//        return updated;
//    }
//
//    public void setUpdated(LocalDateTime updated) {
//        this.updated = updated;
//    }
//
//    public Integer getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Integer postId) {
//        this.postId = postId;
//    }
//
//    public Integer getParentId() {
//        return parentId;
//    }
//
//    public void setParentId(Integer parentId) {
//        this.parentId = parentId;
//    }
//}
