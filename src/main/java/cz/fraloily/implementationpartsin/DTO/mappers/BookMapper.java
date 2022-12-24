package cz.fraloily.implementationpartsin.DTO.mappers;

import cz.fraloily.implementationpartsin.DTO.BookDTO;
import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "authors", target = "authors", qualifiedByName = "getIds")
    BookDTO bookToBookDTO(Book book);

    @Named("getIds")
    public static Set<Long> map(Set<Author> value) {
        return value.stream().map(Author::getId).collect(Collectors.toSet());
    }
}
