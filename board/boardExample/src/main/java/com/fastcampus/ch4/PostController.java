package com.fastcampus.ch4;

import com.fastcampus.ch4.dao.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class PostController {

    @Autowired
    private PostService postService; // PostService를 주입하여 게시글 관련 로직을 처리

    @GetMapping("/write")
    public String showWriteForm() {
        // 글쓰기 페이지를 보여주는 메소드
        return "writeForm"; // writeForm.jsp로 이동
    }

    @PostMapping("/write")
    public String writePost(
            @RequestParam("title") String title,
            @RequestParam("writer") String writer,  // 수정된 부분
            @RequestParam("content") String content,
            @RequestParam("password") Integer password,
            RedirectAttributes redirectAttributes) {

        // Post 객체를 생성하여 글 정보를 저장
        Post post = new Post(title, writer, content, password);

        // PostService를 사용하여 새 게시글을 저장
        postService.savePost(post);

        // 성공 메시지를 추가하고 게시글 목록 페이지로 리다이렉트
        redirectAttributes.addFlashAttribute("message", "글이 성공적으로 작성되었습니다!");

        return "redirect:/board/list"; // 게시글 목록 페이지로 리다이렉트
    }

    @GetMapping("/list")
    public String listPosts(@RequestParam(defaultValue = "1") int page, Model model) {
        // 현재 페이지에 해당하는 게시글 목록을 가져와서 모델에 추가
        model.addAttribute("posts", postService.getPosts(page));

        // 페이지네이션 정보를 모델에 추가
        model.addAttribute("pageHandler", postService.getPageHandler(page));

        return "list"; // list.jsp로 이동
    }

    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable("id") Integer id, Model model) {
        // ID로 게시글을 조회하여 모델에 추가
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);

        return "view"; // view.jsp로 이동
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        // 수정할 게시글을 조회하여 모델에 추가
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);

        return "editForm"; // editForm.jsp로 이동
    }

    @PostMapping("/edit/{id}")
    public String editPost(
            @PathVariable("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("writer") String writer,  // 수정된 부분
            @RequestParam("content") String content,
            @RequestParam("password") Integer password,
            RedirectAttributes redirectAttributes) {

        // 원본 게시글을 조회
        Post originalPost = postService.getPostById(id);

        // 업데이트할 내용을 가진 새로운 Post 객체 생성
        Post updatedPost = new Post(title, writer, content, password);

        try {
            // PostService를 사용하여 게시글을 수정
            postService.updatePost(originalPost, updatedPost, password);

            // 성공 메시지를 추가하고 게시글 보기 페이지로 리다이렉트
            redirectAttributes.addFlashAttribute("message", "글이 성공적으로 수정되었습니다!");
            return "redirect:/board/view/" + id;

        } catch (IllegalArgumentException e) {
            // 비밀번호가 일치하지 않는 경우 에러 메시지를 추가하고 수정 페이지로 이동
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/board/edit/" + id;
        }
    }

    @PostMapping("/delete/{id}")
    public String deletePost(
            @PathVariable("id") Integer id,
            @RequestParam("password") Integer password,
            RedirectAttributes redirectAttributes) {

        try {
            // PostService를 사용하여 게시글을 삭제
            postService.deletePost(id, password);

            // 성공 메시지를 추가하고 게시글 목록 페이지로 리다이렉트
            redirectAttributes.addFlashAttribute("message", "글이 성공적으로 삭제되었습니다!");
            return "redirect:/board/list";

        } catch (IllegalArgumentException e) {
            // 비밀번호가 일치하지 않는 경우 에러 메시지를 추가하고 게시글 보기 페이지로 이동
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/board/view/" + id;
        }
    }
}
