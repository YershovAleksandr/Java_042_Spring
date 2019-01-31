package com.nam.spring_42.board.dao;

import com.nam.spring_42.board.model.Post;
import com.nam.spring_42.board.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao implements IDAO<Post> {

    private static Logger log = LoggerFactory.getLogger(PostDao.class);

    private List<Post> posts = new ArrayList<>();

    private static Connection getConnection(){
        try{
            Class.forName(Tools.driverClassName);
        } catch(ClassNotFoundException e){
            log.error("Can't get class. No driver found", e);
            return null;
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Tools.url, Tools.username, Tools.password);
        } catch(SQLException e){
            log.error("Can't get connection. Incorrect URL", e);
            return null;
        }

        return connection;
    }

    @Override
    public List<Post> getAll() {
        Connection connection = getConnection();

        if (connection == null){
            return null;
        }

        Statement statement = null;
        ResultSet resultSet = null;

        List<Post> postList = new ArrayList<>();

        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery("select * FROM posts");

            while(resultSet.next()){
                Post post = new Post();

                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setText(resultSet.getString("text"));

                log.info("Select from MySQL -> " + post);

                postList.add(post);
            }

        }catch(SQLException e){
            log.error("WTF??", e);
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                log.error("Can't close connection", e);
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("Can't close statement", e);
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.error("Can't close resultset", e);
                }
            }

            try{
                connection.close();
            } catch(SQLException e){
                log.error("Can't close connection", e);
            }
        }

        return postList;
    }

    @Override
    public Post get(int id) {
        Connection connection = getConnection();

        if (connection == null){
            return null;
        }

        Statement statement = null;
        ResultSet resultSet = null;

        Post post = new Post();

        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(String.format("select * FROM posts WHERE id = %d", id));

            while(resultSet.next()){
                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setText(resultSet.getString("text"));

                log.info("Select from MySQL -> " + post);
            }

        }catch(SQLException e){
            log.error("WTF??", e);
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                log.error("Can't close connection", e);
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("Can't close statement", e);
                }
            }

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    log.error("Can't close resultset", e);
                }
            }

            try{
                connection.close();
            } catch(SQLException e){
                log.error("Can't close connection", e);
            }
        }

        return post;
    }

    @Override
    public void update(Post entity) {
        log.info("update");

        posts.set(entity.getId(), entity);
    }

    @Override
    public void create(Post entity) {
        Connection connection = getConnection();

        if (connection == null){
            return;
        }

        Statement statement = null;

        try {
            statement = getConnection().createStatement();

            String sql = String.format("INSERT INTO posts (title, text) VALUES ('%s', '%s')", entity.getTitle(), entity.getText());
            int result = statement.executeUpdate(sql);

            log.info("Insert into MySQL -> " + entity + "\tResult = " + result);
        }catch(SQLException e){
            log.error("WTF??", e);
        }finally {
            try{
                connection.close();
            }catch(SQLException e){
                log.error("Can't close connection", e);
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("Can't close statement", e);
                }
            }

            try{
                connection.close();
            } catch(SQLException e){
                log.error("Can't close connection", e);
            }
        }
    }

    @Override
    public void delete(Post entity) {
        log.info("delete");

        posts.remove(entity);
    }
}
