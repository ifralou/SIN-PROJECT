package cz.fraloily.implementationpartsin.incomings;

public interface Incoming<Out> {
    Out updateEntity(Out entity);
}
