package cz.fraloily.implementationpartsin.DTO.mappers;

import cz.fraloily.implementationpartsin.DTO.LibraryDTO;
import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = BookMapper.class)
public interface LibraryMapper {

    LibraryMapper INSTANCE = Mappers.getMapper(LibraryMapper.class);

    //@Mapping(source = "books.authors", target = "books.authors", qualifiedByName = "getIds")
    LibraryDTO libraryToLibraryDTO(Library library);

//    @Named("getIds")
//    public static Set<Long> map(Set<Author> value) {
//        return value.stream().map(Author::getId).collect(Collectors.toSet());
//    }
}
