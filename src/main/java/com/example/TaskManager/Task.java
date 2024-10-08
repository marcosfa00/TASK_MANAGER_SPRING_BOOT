package com.example.TaskManager;
// Define what a Task Nead
public class Task {
    private int id;
    private String Title;
    private String Description;
    private Boolean isDone;

    public Task(int id, String title, String description) {
        this.id = id;
        Title = title;
        Description = description;
        this.isDone = false;
    }

    // Define Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public Boolean getDone() {
        return isDone;
    }
    public void setDone(Boolean done) {
        isDone = done;
    }
}
