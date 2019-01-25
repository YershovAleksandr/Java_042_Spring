package com.nam.spring_42.board.services;

import com.nam.spring_42.board.dao.PostDao;
import com.nam.spring_42.board.model.Post;

import java.util.List;

public class PostService {
    private static PostDao postDao = new PostDao();

    public static List<Post> getAllPosts(){
        return postDao.getAll();
    }

    public static Post getPostById(int id){
        return postDao.get(id);
    }

    public static void postUpdate(Post post){
        postDao.update(post);
    }

    public static void postCreate(Post post){
        postDao.create(post);
    }

    public static void postDelete(Post post){
        postDao.delete(post);
    }
}
