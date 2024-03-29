package source.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "cats_friends")
public class CatsWithFriends implements BaseEntity<CatsFriendsID> {
    @EmbeddedId
    private CatsFriendsID id;

    @ManyToOne
    @MapsId("catId")
    @JoinColumn(name = "cat_id", nullable = false)
    private Cat cat;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name = "friend_id", nullable = false)
    private Cat friend;

    @Override
    public String toString() {
        return "CatsWithFriends{" +
                ", catId=" + (cat != null ? cat.getId() : "null") +
                ", friendId=" + (friend != null ? friend.getId() : "null") +
                '}';
    }
}
