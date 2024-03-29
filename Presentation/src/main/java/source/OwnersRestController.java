package source;

import DtoConverters.DtoConverter;
import WrappedModels.CatDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import source.Models.Cat;
import src.Services.CatService;
import src.Services.OwnerService;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@NoArgsConstructor
@RequestMapping("/cats_tracking/owners")
public class OwnersRestController {
    @Autowired
    private CatService catService;
    @Autowired
    private OwnerService ownerService;
    private final DtoConverter dtoConverter = new DtoConverter();

    // http://localhost:8080/cats_tracking/owners/get-all-cats-owned-by-owner?ownerName=Bob
    @GetMapping("/get-all-cats-owned-by-owner")
    public Collection<CatDto> getAllCatsOwnedByOwner(@RequestParam("ownerName") String ownerName) throws IOException {
        Collection<Cat> cats = catService.getAllCatsOwnedByOwner(ownerName);

        return cats.stream().map(dtoConverter::convertCatToCatDto).collect(Collectors.toList());
    }
}
