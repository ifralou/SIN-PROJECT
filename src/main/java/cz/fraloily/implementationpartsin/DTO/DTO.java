package cz.fraloily.implementationpartsin.DTO;

public interface DTO<Out> {
    Out updateEntity(Out entity);
}
