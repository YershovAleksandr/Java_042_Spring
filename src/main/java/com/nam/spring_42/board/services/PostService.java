package com.nam.spring_42.board.services;

import com.nam.spring_42.board.dao.PostDao;
import com.nam.spring_42.board.model.Post;

import java.util.List;

public class PostService {
    private PostDao postDao = new PostDao();

    public List<Post> getAllPosts(){
        return postDao.getAll();
    }

    public Post getPostById(int id){
        return postDao.get(id);
    }

    public void postUpdate(Post post){
        postDao.update(post);
    }

    public void postCreate(Post post){
        postDao.create(post);
    }

    public void postDelete(Post post){
        postDao.delete(post);
    }
}
