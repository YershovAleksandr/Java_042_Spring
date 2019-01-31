package com.nam.spring_42.board.controllers;

import com.nam.spring_42.board.model.Post;
import com.nam.spring_42.board.services.PostService;
import com.nam.spring_42.board.utils.Tools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @Value("${spring.datasource.url}")
    public String url;
    @Value("${spring.datasource.username}")
    public String username;
    @Value("${spring.datasource.password}")
    public String password;
    @Value("${spring.datasource.driver-class-name}")
    public String driverClassName;

    public void doit(){
        Tools.url = url;
        Tools.username = username;
        Tools.password = password;
        Tools.driverClassName = driverClassName;
    }

    @RequestMapping("/viewposts")
    public String viewPosts(Model model){
        doit();

        model.addAttribute("foo", "bar");

        //createPosts();

        model.addAttribute("posts", PostService.getAllPosts());


        return "viewposts";
    }

    @RequestMapping("/viewpost")
    public ModelAndView viewPost(@RequestParam(value = "id", defaultValue = "42") String id){
        ModelAndView model = new ModelAndView("viewposts");
        model.addObject("foo", "bar");

        List<Post> postList = new ArrayList<>();
        Post post = PostService.getPostById(Integer.valueOf(id));
        postList.add(post);

        model.addObject("posts", postList);

        return model;
    }

    @PostMapping("/createpost")
    public String viewPosts(@RequestParam(value = "title") String title, @RequestParam(value = "text") String text){
        if (!title.equals("") && !text.equals("")){
            Post post = new Post();

            post.setTitle(title);
            post.setText(text);

            PostService.postCreate(post);
        }

        return "redirect:/viewposts";
    }
}