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
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.api.Constants;
import ca.uhn.fhir.rest.api.MethodOutcome;

import ca.uhn.fhir.rest.api.RequestTypeEnum;
import ca.uhn.fhir.rest.api.RestOperationTypeEnum;
import ca.uhn.fhir.util.OperationOutcomeUtil;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.hl7.fhir.instance.model.api.IBaseOperationOutcome;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.Practitioner;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import ca.uhn.fhir.jpa.model.util.JpaConstants;

/**
 * A demo JaxRs Practitioner Rest Provider, this is a Plain Server version but in JaxRs
 */
// START SNIPPET: jax-rs-provider-construction
@Path("/Practitioner")
@RequestScoped
@Produces({MediaType.APPLICATION_JSON, Constants.CT_FHIR_JSON, Constants.CT_FHIR_XML})
public class JaxRsPractitionerRestProvider extends AbstractJaxRsResourceProvider<Practitioner> {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(JaxRsPractitionerRestProvider.class);
	public JaxRsPractitionerRestProvider() {
		// we should be getting this from config. but hapi is configured for sprint boot
		// super(FhirContext.forR4(), JaxRsPatientRestProvider.class);		
		super(FhirContext.forR4());		
	}
	// END SNIPPET: jax-rs-provider-construction

	@Override
	public Class<Practitioner> getResourceType() {
		return Practitioner.class;
	}

	@Create
	public MethodOutcome create(@ResourceParam final Practitioner practitioner, @ConditionalUrlParam String theConditional) {
		// create the practitioner ...
		ourLog.error("Create is called!");
		return new MethodOutcome(new IdType(1L)).setCreated(true);
	}

	// you implement the FHIR methods! https://hapifhir.io/hapi-fhir/docs/server_plain/jax_rs.html#features
	@Update	
	public MethodOutcome update(@ResourceParam final Practitioner practitioner, @ConditionalUrlParam String theConditional) {
		ourLog.debug("update is called: {}", practitioner.toString());
		return new MethodOutcome(new IdType(1L)).setResource(practitioner);
	}

	 @Operation(name=JpaConstants.OPERATION_VALIDATE)
	 public IBaseOperationOutcome validateResource(@ResourceParam String resource) throws Exception {
		ourLog.debug("validate {}",resource);
		return OperationOutcomeUtil.newInstance(this.getFhirContext());
	 }
}
