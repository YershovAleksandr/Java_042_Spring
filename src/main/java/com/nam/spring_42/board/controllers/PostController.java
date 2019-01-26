package com.nam.spring_42.board.controllers;

import com.nam.spring_42.board.model.Post;
import com.nam.spring_42.board.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class PostController {

    @GetMapping("/posts")
    public List<Post> getPost(){
        return PostService.getAllPosts();
    }

    @GetMapping("/postscreate")
    public void createPosts(){
        Post post1 = new Post();

        post1.setId(0);
        post1.setTitle("Title1");
        post1.setText("Text1");

        PostService.postCreate(post1);

        Post post2 = new Post();

        post2.setId(1);
        post2.setTitle("Title2");
        post2.setText("Text2");

        PostService.postCreate(post2);
    }

    @GetMapping("/viewposts")
    public String viewPosts(Model model){

        model.addAttribute("foo", "bar");

        createPosts();

        model.addAttribute("posts", PostService.getAllPosts());

        return "viewposts";
    }
}