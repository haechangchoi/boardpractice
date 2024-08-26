//package com.fastcampus.ch4.dao;
//
//import com.fastcampus.ch4.Comment;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class CommentDaoImpl implements CommentDao {
//
//
//    private static final String NAMESPACE = "com.fastcampus.ch4.mapper.CommentMapper";
//
//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    // 댓글 추가
//    @Override
//    public void insertComment(Comment comment) {
//        sqlSessionTemplate.insert(NAMESPACE + ".insertComment", comment);
//    }
//
//    // 특정 게시글의 댓글 목록 조회
//    @Override
//    public List<Comment> getCommentsByPostId(Integer postId) {
//        return sqlSessionTemplate.selectList(NAMESPACE + ".getCommentsByPostId", postId);
//    }
//
//    // 댓글 수정
//    @Override
//    public void updateComment(Comment comment) {
//        sqlSessionTemplate.update(NAMESPACE + ".updateComment", comment);
//    }
//
//    // 댓글 삭제
//    @Override
//    public void deleteComment(Integer id, Integer password) {
//        Map<String, Integer> params = new HashMap<>();
//        params.put("id", id);
//        params.put("password", password);
//        sqlSessionTemplate.delete(NAMESPACE + ".deleteComment", params);
//    }
//    // 특정 댓글 조회
//    @Override
//    public Comment getCommentById(Integer id) {
//        return sqlSessionTemplate.selectOne(NAMESPACE + ".getCommentById", id);
//    }
//}
