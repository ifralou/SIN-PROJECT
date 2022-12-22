package cz.fraloily.implementationpartsin.repository;

import cz.fraloily.implementationpartsin.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> getAuthorByEmail(String email);
    Optional<Author> getAuthorById(Long id);
    Optional<Author> getAuthorByEmailAndFirstnameAndSurname(
            String email, String firstname, String surname
    );

    Long deleteAuthorById(Long id);
}
