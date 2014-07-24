package net.nemerosa.dojo.springboot.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    private final int id;
    private final String title;
    @Wither
    private final boolean done;

    public static Todo of(int id, String title) {
        return new Todo(id, title, false);
    }

}
