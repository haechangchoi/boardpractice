package com.fastcampus.ch4;

import com.fastcampus.ch4.dao.PostDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Spring ApplicationContext 초기화
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");


        // PostDaoImpl 빈을 가져옴
        PostDaoImpl postDao = context.getBean(PostDaoImpl.class);

        // 테스트 코드
        Post newPost = new Post("Sample Title", "Sample Content", "Sample Writer", 1234);
        postDao.insertPost(newPost);
        System.out.println("Inserted post: " + newPost);

        System.out.println(newPost.getId());
        System.out.println(newPost.getTitle());
    }
}
