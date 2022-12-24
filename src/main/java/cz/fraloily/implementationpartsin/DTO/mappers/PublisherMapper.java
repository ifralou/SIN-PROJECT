package cz.fraloily.implementationpartsin.DTO.mappers;

import cz.fraloily.implementationpartsin.DTO.PublisherDTO;
import cz.fraloily.implementationpartsin.entity.Author;
import cz.fraloily.implementationpartsin.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDTO publisherToPublisherDTO(Publisher publisher);


}
