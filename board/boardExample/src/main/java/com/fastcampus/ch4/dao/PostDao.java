package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.Post;

import java.util.List;

public interface PostDao {

    void insertPost(Post post);
    List<Post> selectPostByWriter(String writer);
    Post selectPostById(Integer id);
    void deletePost(Integer id, Integer password);
    void deleteAllPost();
    void updatePost(Post original, Post updated, Integer password);
    // 특정 범위의 게시글 목록을 가져옴 (페이징 처리)
    List<Post> selectPosts(int offset, int limit);

    // 전체 게시글 수를 반환
    int countPosts();
}
