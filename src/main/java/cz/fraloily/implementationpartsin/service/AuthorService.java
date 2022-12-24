package cz.fraloily.implementationpartsin.service;

import cz.fraloily.implementationpartsin.DTO.AuthorDTO;

public interface AuthorService {

    public AuthorDTO getAuthorById(Long id);
    public AuthorDTO createAuthorIfNotExists(AuthorDTO author);

    public AuthorDTO updateAuthorCredentials(Long id, AuthorDTO incoming);

    public void deleteAuthorById(Long id);

    public AuthorDTO addPublisher(Long authorId, Long publisherId);
}
