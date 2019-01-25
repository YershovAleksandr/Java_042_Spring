package com.nam.spring_42.board.model;

public class Post {
    private int id;
    private String title;
    private String text;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return String.format("[Id = %d, Title = %s, Text = %s]", id, title, text);
    }
}
