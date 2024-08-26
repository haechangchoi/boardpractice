//package com.fastcampus.ch4.dao;
//
//import com.fastcampus.ch4.Comment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CommentService {
//
//    private final CommentDao commentDao;
//
//    @Autowired
//    public CommentService(CommentDao commentDao) {
//        this.commentDao = commentDao;
//    }
//
//    // 댓글 및 대댓글 추가
//    public void addComment(Comment comment) {
//        commentDao.insertComment(comment);
//    }
//
//    // 특정 게시글의 댓글 및 대댓글 목록 조회
//    public List<Comment> getCommentsByPostId(Integer postId) {
//        return commentDao.getCommentsByPostId(postId);
//    }
//
//    // 댓글 수정
//    public void updateComment(Comment comment) {
//        commentDao.updateComment(comment);
//    }
//
//    // 댓글 삭제
//    public void deleteComment(Integer id, Integer password) {
//        commentDao.deleteComment(id, password);
//    }
//
//    // 특정 댓글 조회
//    public Comment getCommentById(Integer id) {
//        return commentDao.getCommentById(id);
//    }
//}
