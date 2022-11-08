package cz.fraloily.implementationpartsin.repository;

import cz.fraloily.implementationpartsin.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Optional<Publisher> getPublisherById(Long id);
    Optional<Publisher> getPublisherByName(String name);
}
