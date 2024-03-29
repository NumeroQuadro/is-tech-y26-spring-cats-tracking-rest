package source.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CatsFriendsID implements Serializable {
    @Column(name = "cat_id")
    private Integer catId;

    @Column(name = "friend_id")
    private Integer friendId;
}