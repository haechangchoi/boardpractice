package com.example.domain;

public class Comment {

    //필수 필드
    private Integer id;
    private String content;
    private String writer;
    private Integer password;
    private Integer postId;
    //선택 필드
    private Integer commentId;

    //private 생성자
    private Comment(Builder builder) {
        this.id = builder.id;
        this.content = builder.content;
        this.writer = builder.writer;
        this.password = builder.password;
        this.postId = builder.postId;
        this.commentId = builder.commentId;
    }
    //Builder 패턴
    public static class Builder {
        private Integer id;
        private String content;
        private String writer;
        private Integer password;
        private Integer postId;
        //선택 필드(null)
        private Integer commentId;

        public Builder(Integer id, String content, String writer, Integer password, Integer postId) {
            this.id = id;
            this.content = content;
            this.writer = writer;
            this.password = password;
            this.postId = postId;
        }

        public Builder setCommentId(Integer commentId){
            this.commentId = commentId;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }

    }
    // 필드 값이 변하지 않도록 복사하여 새로운 객체를 생성하는 메서드
    public Comment updateContent(String newContent) {
        return new Builder(this.id, newContent, this.writer, this.password, this.postId)
                .setCommentId(this.commentId) // commentId 그대로 유지
                .build();
    }
}
