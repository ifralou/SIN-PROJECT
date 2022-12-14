package cz.fraloily.implementationpartsin.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FailedResponse extends ResponseStatusException {

    public FailedResponse(HttpStatus status, String reason) {
        super(status, reason);
    }

}
