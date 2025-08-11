package com.personalblog.controller;

import com.personalblog.model.PostPreview;
import com.personalblog.model.PostDetail;
import com.personalblog.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostsController {
    @GetMapping("/posts")
    public String listPosts(@RequestParam(name = "page", defaultValue = "1") int page,
                            @RequestParam(name = "size", defaultValue = "10") int size,
                            @RequestParam(name = "tag", required = false) String tag,
                            Model model) {

        // Dummy data
        List<PostPreview> posts = List.of(
                new PostPreview(1L, "Hello Spring",
                        "https://placehold.co/300x160",
                        "This is the first paragraph preview…",
                        3, 7, List.of("spring", "java")),
                new PostPreview(2L, "Thymeleaf Tips",
                        "https://placehold.co/300x160",
                        "Some handy tips for Thymeleaf…",
                        5, 12, List.of("thymeleaf", "views"))
        );

        int totalPages = 5;

        model.addAttribute("posts", posts);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("selectedTag", tag);

        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable(name = "id") long id, Model model) {
        var post = new PostDetail(
                id,
                "Hello Spring " + id,
                "https://placehold.co/800x300",
                List.of(
                        "This is paragraph one of the post body.",
                        "This is paragraph two with more details."
                ),
                List.of("spring","java"),
                7
        );
        var comments = List.of(
                new Comment(101L, id, "Nice post!"),
                new Comment(102L, id, "Thanks for sharing.")
        );

        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post";
    }

}
