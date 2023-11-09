package ca.uhn.fhir.jpa.starter;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsConformanceProvider;
import ca.uhn.fhir.jpa.provider.BaseJpaResourceProvider;
import ca.uhn.fhir.jpa.rp.r4.PatientResourceProvider;
import ca.uhn.fhir.rest.api.Constants;
import ca.uhn.fhir.rest.server.IResourceProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.ConcurrentHashMap;

@Path("")
@ApplicationScoped
@Produces({MediaType.APPLICATION_JSON, Constants.CT_FHIR_JSON, Constants.CT_FHIR_XML})
public class JaxRsConformanceProvider extends AbstractJaxRsConformanceProvider {

    @Inject
    private PatientResourceProvider provider;

    @Inject
    private JaxRsPractitionerRestProvider provider2;
    public JaxRsConformanceProvider() {
        super(FhirContext.forR4(),"My Server Description", "My Server Name", "My Server Version");
    }

    @Override
    protected ConcurrentHashMap<Class<? extends IResourceProvider>, IResourceProvider> getProviders() {
        ConcurrentHashMap<Class<? extends IResourceProvider>, IResourceProvider> map =
                new ConcurrentHashMap<Class<? extends IResourceProvider>, IResourceProvider>();
        map.put(JaxRsConformanceProvider.class, this);
        map.put(BaseJpaResourceProvider.class, provider);
        map.put(JaxRsPractitionerRestProvider.class,provider2 );
        return map;
    }
}