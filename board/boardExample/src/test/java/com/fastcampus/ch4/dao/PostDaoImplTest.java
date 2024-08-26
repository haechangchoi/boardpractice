package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.Post;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PostDaoImplTest extends TestCase {

    @Autowired
    private PostDao postDao;

    @Before
    public void setup() {

    postDao.deleteAllPost();

    }

    @Test
    public void testInsertPost() {
        Post newPost = new Post("test","test","test",1234);

        postDao.insertPost(newPost);
        int inserted = postDao.countPosts();
        assertEquals(1, inserted);


    }
    @Test
    public void testSelectPostByWriter() {
        Post newPost = new Post("test","test","test",1234);

        postDao.insertPost(newPost);
        int inserted = postDao.countPosts();
        assertEquals(1, inserted);

        List<Post> selected = postDao.selectPostByWriter(newPost.getWriter());
        assertEquals(1,selected.size());

    }
    @Test
    public void testSelectPostById() {

        Post newPost = new Post("test","test","test",1234);

        postDao.insertPost(newPost);
        int inserted = postDao.countPosts();
        assertEquals(1, inserted);

        Post selectedPostById = postDao.selectPostById(newPost.getId());

        assertEquals(newPost.getId(), selectedPostById.getId());

    }

    public void testDeletePost() {
    }

    public void testDeleteAllPost() {
    }

    public void testUpdatePost() {
    }

    public void testSelectPosts() {
    }

    public void testCountPosts() {
    }
}