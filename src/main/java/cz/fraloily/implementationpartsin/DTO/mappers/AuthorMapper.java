package cz.fraloily.implementationpartsin.DTO.mappers;

import cz.fraloily.implementationpartsin.DTO.AuthorDTO;
import cz.fraloily.implementationpartsin.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "firstname", target = "firstname")
    AuthorDTO authorToAuthorDTO(Author author);


}
