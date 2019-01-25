package com.nam.spring_42.board;

import com.nam.spring_42.board.dao.PostDao;
import com.nam.spring_42.board.model.Post;

public class Main {
    public static void main(String[] args){

        PostDao postDao = new PostDao();

        Post post1 = new Post();
        post1.setId(0);
        post1.setTitle("Title1");
        post1.setText("Text1");

        postDao.create(post1);

        Post post2 = new Post();
        post2.setId(1);
        post2.setTitle("Title2");
        post2.setText("Text2");

        postDao.create(post1);


        postDao.getAll().forEach(post -> System.out.println(post));

    }
}
