package ca.uhn.fhir.jpa.starter;

import ca.uhn.fhir.jpa.util.IPersistenceContextProvider;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;


@RequestScoped
public class PersistenceContextProvider implements IPersistenceContextProvider {
    @PersistenceContext(unitName = "HAPI_PU", type = PersistenceContextType.TRANSACTION)
    private EntityManager myEntityManager;

    public EntityManager getEntityManager() {
        return myEntityManager;
    }
}
