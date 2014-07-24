package net.nemerosa.dojo.springboot.model;

public class Todo {

    private final int id;
    private final String title;
    private final boolean done;

    protected Todo(int id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public static Todo of(int id, String title) {
        return new Todo(id, title, false);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }
}
