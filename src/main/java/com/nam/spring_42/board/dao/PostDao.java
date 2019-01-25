package com.nam.spring_42.board.dao;

import com.nam.spring_42.board.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDao implements IDAO<Post> {

    private List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Optional<Post> get(int id) {
        return Optional.ofNullable(posts.get(id));
    }

    @Override
    public void update(Post entity) {
        posts.set(entity.getId(), entity);
    }

    @Override
    public void create(Post entity) {
        posts.add(entity);
    }

    @Override
    public void delete(Post entity) {
        posts.remove(entity);
    }
}
