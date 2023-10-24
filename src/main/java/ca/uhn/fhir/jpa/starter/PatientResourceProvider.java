/*-
 * #%L
 * HAPI FHIR - Docs
 * %%
 * Copyright (C) 2014 - 2023 Smile CDR, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package ca.uhn.fhir.jpa.starter;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.api.config.JpaStorageSettings;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import ca.uhn.fhir.jpa.dao.r4.DaoPatientR4;
import ca.uhn.fhir.jpa.provider.BaseJpaResourceProvider;
import ca.uhn.fhir.rest.api.Constants;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.hl7.fhir.r4.model.Patient;

// THIS CLASS SHOULD BE CODE GENERATED!

@Path("/Patient")
@RequestScoped
@Produces({MediaType.APPLICATION_JSON, Constants.CT_FHIR_JSON, Constants.CT_FHIR_XML})
public class PatientResourceProvider extends BaseJpaResourceProvider<Patient> {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ca.uhn.fhir.jpa.rp.r4.PatientResourceProvider.class);

	@Inject
	public PatientResourceProvider(FhirContext ctx, DaoPatientR4 dao) {
		super(ctx);
		this.setDao(dao);
	}

	// Normally we would return this from the DAO, however AbstractJaxRsResourceProvider
	// calls getResourceType at constructor call stack and we return a dao == null error.
	// If this bit is codegenerated, there is no issue with hardcoding this.
	@Override
	public Class<Patient> getResourceType() {
		return Patient.class;
	}
}
