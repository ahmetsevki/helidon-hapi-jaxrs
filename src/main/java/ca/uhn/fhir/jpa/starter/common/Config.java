package ca.uhn.fhir.jpa.starter.common;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.api.config.JpaStorageSettings;
import ca.uhn.fhir.jpa.starter.AppProperties;
import ca.uhn.fhir.jpa.starter.PersistenceContextProvider;
import ca.uhn.fhir.jpa.util.IPersistenceContextProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

public class Config {
    @Inject
    IPersistenceContextProvider persistenceContextProvider;
    @Produces
    @ApplicationScoped
    @Named("fhirContextR4")
    public FhirContext fhirContext(){

        return FhirContext.forR4();
    }

    @Produces
    @RequestScoped
    public EntityManager entityManager(){
        return persistenceContextProvider.getEntityManager();
    }
}
