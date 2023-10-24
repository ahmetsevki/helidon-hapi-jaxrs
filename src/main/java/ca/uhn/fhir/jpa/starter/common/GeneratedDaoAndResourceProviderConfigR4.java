package ca.uhn.fhir.jpa.starter.common;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.api.config.JpaStorageSettings;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import ca.uhn.fhir.jpa.dao.r4.DaoPatientR4;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

// THIS CLASS SHOULD BE CODE GENERATED!
public class GeneratedDaoAndResourceProviderConfigR4 {


    @Inject
    public DaoPatientR4 xdaoPatientR4; // so this is container managed

//    @Named("myPatientDaoR4")
//    @Produces
//    @ApplicationScoped
//    public IFhirResourceDao<org.hl7.fhir.r4.model.Patient> daoPatientR4() {
//        return xdaoPatientR4;
//    }

//    @Named("myPatientRpR4")
//    public ca.uhn.fhir.jpa.rp.r4.PatientResourceProvider rpPatientR4() {
//        ca.uhn.fhir.jpa.rp.r4.PatientResourceProvider retVal;
//        retVal = new ca.uhn.fhir.jpa.rp.r4.PatientResourceProvider(myFhirContext);
//        retVal.setDao(daoPatientR4());
//        return retVal;
//    }
}
