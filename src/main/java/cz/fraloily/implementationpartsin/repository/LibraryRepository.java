package cz.fraloily.implementationpartsin.repository;


import cz.fraloily.implementationpartsin.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {

    Optional<Library> findById(Long id);
}
