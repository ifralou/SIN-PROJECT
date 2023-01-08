# SIN seminar project.

### Seminars
Changes made during the seminars will be added here.

## Sem1
First data model diagram:
![data model](/src/main/resources/firstDiagram.png)

## Sem2

> Doimplementujte BO vrstvu (bussiness object) – JPA

Package entity

> Implementujte závistlosti (1:N,N:M,1:1...) 
> 
> Verze pro A,B – vazba N,M 

M:N - Author.java (books, publishers);

1:1 - Publisher.java (address);

1:N - Publisher.java (book);

> Bean Validation (@NotNull)

Accross all entities.

> Navrhněte datový model v UML class diagramu.

Sem1 - data model

> Implementujte DAO vrstvu nebo repository s CRUD operacemi

Package repository 

## Sem3

> Navrhněte systémové operace a popište je UML sekvenční diagramy.

Add publisher to author example:
![data model](/src/main/resources/seq1.svg)

> Implementujte service layer
> 
> Implementace všechny tří služby ze sekvenčního diagramu.

Package services

> Loggujte do Loggeru.

Done

> Popište logickou strukturu aplikace pomocí UML diagramu nasazení.

Springboot default application configuration.

> Použijte Junit tests

Test folder.

## Sem4

> Implementujte controller layer pro vytvořenou service layer

Controller package.

> Proveďte statickou analýzu kódu

Results:
![Result](/src/main/resources/analysis.png)

> interceptory – logování délky requestů

Package interceptor

> mapování BO na DTO objekty – mapstruct

DTO package + DTO/mappers package

## Sem5
> bezpecnost (autorizace, autentifikace)
> 
> viz kody na seminar repozitari gitlabu

No codes are presented at repository.

> mockito

done

> cache

basic default spring-cache-starter implementation














### Reference
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.4/maven-plugin/reference/html/#build-image)

