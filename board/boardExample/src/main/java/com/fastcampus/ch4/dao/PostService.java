package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.PageHandler;
import com.fastcampus.ch4.Post;

import java.util.List;

public interface PostService {
    void savePost(Post post);

    void updatePost(Post original, Post updated, Integer password);

    void deletePost(Integer id, Integer password);

    Post getPostById(Integer id);

    List<Post> getPosts(int page);

    PageHandler getPageHandler(int currentPage);
}
