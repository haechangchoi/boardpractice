package com.example.mapper;

import com.example.domain.Comment;

public interface CommentDao {
     int commentCount();
     Comment getCommentById(int id);
     void insertComment(Comment comment);
     void updateComment(Comment comment);
     void deleteCommentById(int id);

}
