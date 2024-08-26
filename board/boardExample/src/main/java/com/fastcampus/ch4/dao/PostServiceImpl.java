package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.PageHandler;
import com.fastcampus.ch4.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 이 클래스가 Spring의 서비스 계층을 담당하며, Spring 컨테이너에 의해 관리된다는 것을 나타냅니다.
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao; // PostDao를 주입하여 데이터베이스와의 상호작용을 처리

    private static final int PAGE_SIZE = 10; // 한 페이지에 표시될 게시글의 수를 10개로 설정

    /**
     * 새로운 게시글을 저장하는 메서드
     *
     * @param post 저장할 게시글 객체
     */
    @Override
    public void savePost(Post post) {
        postDao.insertPost(post);
    }

    @Override
    public void updatePost(Post original, Post updated, Integer password){
        if(original.getPassword().equals(password)){
            postDao.updatePost(original, updated, password);
        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    @Override
    public void deletePost(Integer id, Integer password){
        Post selectedPostById = postDao.selectPostById(id);
        if(selectedPostById.getId().equals(id)  && selectedPostById.getPassword().equals(password)){
            postDao.deletePost(id, password);
        }else{
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

    }

    @Override
    public Post getPostById(Integer id){
        return postDao.selectPostById(id);
    }

    /**
     * 페이지 번호에 해당하는 게시글 목록을 가져옵니다.
     *
     * @param page 가져올 페이지 번호
     * @return 해당 페이지에 있는 게시글 목록 (Post 형태)
     */
    @Override
    public List<Post> getPosts(int page) {
        // offset: 데이터베이스 쿼리에서 가져올 게시글의 시작 지점을 계산합니다.
        // 예를 들어, 페이지가 1이면 offset은 0, 페이지가 2이면 offset은 10이 됩니다.
        int offset = (page - 1) * PAGE_SIZE;

        // postDao의 selectPosts 메서드를 호출하여 데이터베이스에서 게시글 목록을 가져옵니다.
        // offset과 limit(한 번에 가져올 게시글 수)를 매개변수로 전달합니다.
        List<Post> posts = postDao.selectPosts(offset, PAGE_SIZE);

        return posts;
    }

    /**
     * 페이지네이션 처리를 위한 PageHandler 객체를 생성합니다.
     *
     * @param currentPage 현재 페이지 번호
     * @return 페이지네이션 정보를 포함한 PageHandler 객체
     */
    @Override
    public PageHandler getPageHandler(int currentPage) {
        // 데이터베이스에서 전체 게시글 수를 가져옵니다.
        int totalPosts = postDao.countPosts();

        // PageHandler 객체를 생성하여 페이지네이션 정보를 계산하고 반환합니다.
        // totalPosts: 전체 게시글 수
        // currentPage: 현재 페이지 번호
        // PAGE_SIZE: 한 페이지에 표시할 게시글 수
        return new PageHandler(totalPosts, currentPage, PAGE_SIZE);
    }

}