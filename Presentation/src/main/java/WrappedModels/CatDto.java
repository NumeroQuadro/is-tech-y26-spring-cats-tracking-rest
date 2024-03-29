package WrappedModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import source.Models.CatColor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CatDto implements Dto {
    private Integer id;
    private String name;
    private LocalDate birthDate;
    private String breed;
    private CatColor color;

    private final Set<CatDto> friends = new HashSet<>();

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
