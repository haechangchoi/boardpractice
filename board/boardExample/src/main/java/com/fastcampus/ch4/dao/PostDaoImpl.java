package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.Post;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostDaoImpl implements PostDao{

    final String NAMESPACE = "com.fastcampus.ch4.dao.PostDao";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public void insertPost(Post post) {
        sqlSessionTemplate.insert(NAMESPACE+".insertPost", post);
    }

    @Override
    public List<Post> selectPostByWriter(String writer) {
        return sqlSessionTemplate.selectList(NAMESPACE + ".selectPostByWriter", writer);
    }

    @Override
    public Post selectPostById(Integer id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".selectPostById", id);
    }

    @Override
    public void deletePost(Integer id, Integer password) {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        sqlSessionTemplate.delete(NAMESPACE + ".deletePost", params);
    }

    @Override
    public void deleteAllPost() {
        sqlSessionTemplate.delete(NAMESPACE + ".deleteAllPost");
    }

    @Override
    public void updatePost(Post original, Post updated, Integer password) {
        Map<String, Object> params = new HashMap<>();
        params.put("original", original);
        params.put("updated", updated);
        params.put("password", password);
        sqlSessionTemplate.update(NAMESPACE + ".updatePost", params);
    }

    @Override
    public List<Post> selectPosts(int offset, int limit) {
        Map<String, Integer> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", limit);
        return sqlSessionTemplate.selectList(NAMESPACE + ".selectPosts", params);
    }

    @Override
    public int countPosts() {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".countPosts");
    }
}
