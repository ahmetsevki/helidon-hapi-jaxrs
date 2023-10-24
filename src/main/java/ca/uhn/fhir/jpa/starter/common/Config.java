package ca.uhn.fhir.jpa.starter.common;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.api.config.JpaStorageSettings;
import ca.uhn.fhir.jpa.starter.AppProperties;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

public class Config {
    @Produces
    @ApplicationScoped
    @Named("fhirContextR4")
    public FhirContext fhirContext(){

        return FhirContext.forR4();
    }


    @Produces
    @ApplicationScoped
    public AppProperties appProperties() {
        return new AppProperties();
    }

    @Produces
    @ApplicationScoped
    public JpaStorageSettings getStorageSettings(AppProperties appProperties){
        FhirServerConfigCommon fhirServerConfigCommon = new FhirServerConfigCommon(appProperties);
        return fhirServerConfigCommon.jpaStorageSettings();
    }

}
