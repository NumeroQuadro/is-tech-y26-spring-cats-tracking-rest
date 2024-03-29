package WrappedModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import source.Models.OwnerCatsID;

@Getter
@AllArgsConstructor
public class OwnerWithCatsDto implements Dto {
    private OwnerCatsID id;
    private OwnerDto owner;
    private CatDto cat;

    public OwnerWithCatsDto() { }

    @Override
    public String toString() {
        return "OwnerWithCatsDto{" +
                "id=" + id +
                ", owner=" + owner +
                ", cat=" + cat +
                '}';
    }
}