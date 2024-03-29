package source;

import DtoConverters.DtoConverter;
import WrappedModels.CatDto;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.Services.CatService;
import src.Services.OwnerService;

import java.util.Collection;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@NoArgsConstructor
@RequestMapping("/cats_tracking/cats")
public class CatsRestController {
    @Autowired
    private CatService catService;
    @Autowired
    private OwnerService ownerService;
    private final DtoConverter dtoConverter = new DtoConverter();

    // http://localhost:8080/cats_tracking/cats/all-black-cats
    @GetMapping("/all-black-cats")
    public List<CatDto> getAllBlackCats() {
        var blackCats = catService.getAllBlackCats();

        return blackCats.stream().map(dtoConverter::convertCatToCatDto).toList();
    }
}
