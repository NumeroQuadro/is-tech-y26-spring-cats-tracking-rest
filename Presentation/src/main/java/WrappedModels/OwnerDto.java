package WrappedModels;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class OwnerDto implements Dto {
    private Integer id;
    private String name;
    private LocalDate birthDate;

    private Set<CatDto> cats = new HashSet<>();
    private final Set<OwnerWithCatsDto> ownerWithCats = new HashSet<>();

    @Override
    public String toString() {
        return "OwnerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", cats=" + cats +
                ", ownerWithCats=" + ownerWithCats +
                '}';
    }
}
