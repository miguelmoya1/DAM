
package orderedComments;

import java.time.ZonedDateTime;

public class Comment {
    protected String username;
    protected String comment;
    protected ZonedDateTime date;

    public String getUsername() {
        return username;
    }

    public Comment setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Comment setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public Comment setDate(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public Comment(String username, String comment, ZonedDateTime time) {
        this.username = username;
        this.comment = comment;
        this.date = time;
    }
    
    public Comment() {
    }
}
