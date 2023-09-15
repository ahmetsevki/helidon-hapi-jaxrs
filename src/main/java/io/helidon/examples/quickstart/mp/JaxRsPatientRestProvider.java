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
package io.helidon.examples.quickstart.mp;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jaxrs.server.AbstractJaxRsResourceProvider;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.api.Constants;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.api.RequestTypeEnum;
import ca.uhn.fhir.rest.api.RestOperationTypeEnum;

import java.io.IOException;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * A demo JaxRs Patient Rest Provider
 */
// START SNIPPET: jax-rs-provider-construction
@Path("/Patient")
@RequestScoped
@Produces({MediaType.APPLICATION_JSON, Constants.CT_FHIR_JSON, Constants.CT_FHIR_XML})
public class JaxRsPatientRestProvider extends AbstractJaxRsResourceProvider<Patient> {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(JaxRsPatientRestProvider.class);
	public JaxRsPatientRestProvider() {
		// we should be getting this from config. but hapi is configured for sprint boot
		// super(FhirContext.forR4(), JaxRsPatientRestProvider.class);		
		super(FhirContext.forR4());		
	}
	// END SNIPPET: jax-rs-provider-construction

	@Override
	public Class<Patient> getResourceType() {
		return Patient.class;
	}

	@Create
	public MethodOutcome create(@ResourceParam final Patient patient, @ConditionalUrlParam String theConditional) {		
		// create the patient ...
		ourLog.debug("Create is called!");
		return new MethodOutcome(new IdType(1L)).setCreated(true);
	}

	// you implement the FHIR methods! https://hapifhir.io/hapi-fhir/docs/server_plain/jax_rs.html#features
	@Update	
	public MethodOutcome update(@ResourceParam final Patient patient) {
		ourLog.debug("update is called: {}", patient.toString());
		return new MethodOutcome(new IdType(1L)).setResource(patient);
	}


	// // START SNIPPET: jax-rs-provider-operation
	// @GET
	// @Path("/{id}/$someCustomOperation")
	// public Response someCustomOperationUsingGet(@PathParam("id") String id, String resource) throws Exception {		
	// 	ourLog.debug("someCustomOperationUsingGet",id, resource);
	// 	return customOperation(
	// 			resource,
	// 			RequestTypeEnum.GET,
	// 			id,
	// 			"$someCustomOperation",
	// 			RestOperationTypeEnum.EXTENDED_OPERATION_INSTANCE);
	// }

	// @Operation(
	// 		name = "someCustomOperation",
	// 		idempotent = true,
	// 		returnParameters = {@OperationParam(name = "return", type = StringDt.class)})
	// public Parameters someCustomOperation(@IdParam IdType myId, @OperationParam(name = "dummy") StringDt dummyInput) {
	// 	ourLog.debug("someCustomOperation is called");
	// 	Parameters parameters = new Parameters();
	// 	parameters.addParameter().setName("return").setValue(new StringType("My Dummy Result"));
	// 	return parameters;
	// }
	// // END SNIPPET: jax-rs-provider-operation

	// @POST
	// @Path("/{id}/$someCustomOperation")
	// public Response someCustomOperationUsingPost(@PathParam("id") String id, String resource) throws Exception {
	// 	return customOperation(
	// 			resource,
	// 			RequestTypeEnum.POST,
	// 			id,
	// 			"$someCustomOperation",
	// 			RestOperationTypeEnum.EXTENDED_OPERATION_INSTANCE);
	// }
}
