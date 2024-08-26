//package com.fastcampus.ch4;
//
//import com.fastcampus.ch4.dao.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/comments")
//public class CommentController {
//
//    private final CommentService commentService;
//
//    @Autowired
//    public CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }
//
//    // 댓글 및 대댓글 추가 처리
//    @PostMapping("/add")
//    public String addComment(@ModelAttribute Comment comment, @RequestParam("postId") Integer postId) {
//        comment.setPostId(postId);
//        commentService.addComment(comment);
//        return "redirect:/posts/" + postId; // 게시글 상세 페이지로 리다이렉트
//    }
//
//    // 특정 게시글의 댓글 및 대댓글 목록 조회
//    @GetMapping("/post/{postId}")
//    public String getCommentsByPostId(@PathVariable("postId") Integer postId, Model model) {
//        List<Comment> comments = commentService.getCommentsByPostId(postId);
//        model.addAttribute("comments", comments);
//        return "comments/commentList"; // 댓글 목록을 보여주는 뷰
//    }
//
//    // 댓글 수정 처리
//    @PostMapping("/update/{id}")
//    public String updateComment(@PathVariable("id") Integer id, @ModelAttribute Comment comment, @RequestParam("postId") Integer postId) {
//        comment.setId(id);
//        commentService.updateComment(comment);
//        return "redirect:/posts/" + postId; // 게시글 상세 페이지로 리다이렉트
//    }
//
//    // 댓글 삭제 처리
//    @PostMapping("/delete/{id}")
//    public String deleteComment(@PathVariable("id") Integer id, @RequestParam("password") Integer password, @RequestParam("postId") Integer postId) {
//        commentService.deleteComment(id, password);
//        return "redirect:/posts/" + postId; // 게시글 상세 페이지로 리다이렉트
//    }
//
//    // 특정 댓글 조회
//    @GetMapping("/{id}")
//    public String getCommentById(@PathVariable("id") Integer id, Model model) {
//        Comment comment = commentService.getCommentById(id);
//        model.addAttribute("comment", comment);
//        return "comments/commentDetail"; // 특정 댓글을 보여주는 뷰
//    }
//}