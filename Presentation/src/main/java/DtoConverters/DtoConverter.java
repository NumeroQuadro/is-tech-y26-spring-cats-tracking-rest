package DtoConverters;

import WrappedModels.CatDto;
import WrappedModels.OwnerDto;
import WrappedModels.OwnerWithCatsDto;
import source.Models.Cat;
import source.Models.Owner;
import source.Models.OwnerWithCats;

import java.util.HashSet;
import java.util.stream.Collectors;

public class DtoConverter {
    public CatDto convertCatToCatDto(Cat cat) {
        return new CatDto(cat.getId(), cat.getName(), cat.getBirthDate(), cat.getBreed(), cat.getColor());
    }

    public OwnerDto convertOwnerToOwnerDto(Owner owner) {
        return new OwnerDto(owner.getId(), owner.getName(), owner.getBirthDate(), owner.getCats().stream().map(this::convertCatToCatDto).collect(Collectors.toSet()));
    }

    public OwnerWithCatsDto OwnerWithCatsToOwnerWithCatsDto(OwnerWithCats ownerWithCats) {
        return new OwnerWithCatsDto(ownerWithCats.getId(), convertOwnerToOwnerDto(ownerWithCats.getOwner()), convertCatToCatDto(ownerWithCats.getCat()));
    }
}
