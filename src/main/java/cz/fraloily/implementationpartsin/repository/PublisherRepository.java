package cz.fraloily.implementationpartsin.repository;

import cz.fraloily.implementationpartsin.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    @Override
    Optional<Publisher> findById(Long aLong);
}
