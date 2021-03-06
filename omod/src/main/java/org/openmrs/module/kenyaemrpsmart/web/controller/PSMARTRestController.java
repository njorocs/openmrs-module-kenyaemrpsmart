/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.kenyaemrpsmart.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.kenyaemrpsmart.jsonvalidator.mapper.IncomingPatientSHR;
import org.openmrs.module.kenyaemrpsmart.jsonvalidator.mapper.OutgoingPatientSHR;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * The main controller.
 */
@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/smartcard")
public class PSMARTRestController extends BaseRestController {

	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(method = RequestMethod.POST, value = "/receiveshr")
	@ResponseBody
	public Object receiveSHR(WebRequest request) {
		int patientID = request.getParameter("patientID") != null? Integer.parseInt(request.getParameter("patientID")): 0;
		if (patientID != 0) {
			OutgoingPatientSHR shr = new OutgoingPatientSHR(patientID);
			return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated()).add("identification", shr.patientIdentification().toString());

		}
		return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated()).add("identification", "No patient id specified in the request: Got this: => " + request.getParameter("patientID"));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/prepareshr")
	@ResponseBody
	public Object prepareSHR(WebRequest request) {
		IncomingPatientSHR shr = new IncomingPatientSHR(getIncomingSHRSample());
		return new SimpleObject().add("sessionId", request.getSessionId()).add("authenticated", Context.isAuthenticated()).add("patient", shr.processIncomingSHR());
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController#getNamespace()
	 */

	@Override
	public String getNamespace() {
		return "v1/kenyaemrpsmart";
	}

	private String getIncomingSHRSample () {
		return "{\n" +
				"  \"VERSION\": \"1.0.0\",\n" +
				"  \"PATIENT_IDENTIFICATION\": {\n" +
				"    \"EXTERNAL_PATIENT_ID\": {\n" +
				"      \"ID\": \"110ec58a-a0f2-4ac4-8393-c866d813b8d2\",\n" +
				"      \"IDENTIFIER_TYPE\": \"GODS_NUMBER\",\n" +
				"      \"ASSIGNING_AUTHORITY\": \"MPI\",\n" +
				"      \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"    },\n" +
				"    \"INTERNAL_PATIENT_ID\": [\n" +
				"      {\n" +
				"        \"ID\": \"12345678-ADFGHJY-0987654-NHYI891\",\n" +
				"        \"IDENTIFIER_TYPE\": \"CARD_SERIAL_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"CARD_REGISTRY\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"123456781\",\n" +
				"        \"IDENTIFIER_TYPE\": \"HEI_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"MCH\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"1234567801\",\n" +
				"        \"IDENTIFIER_TYPE\": \"CCC_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"CCC\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"00101\",\n" +
				"        \"IDENTIFIER_TYPE\": \"HTS_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"HTS\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"ABC56767\",\n" +
				"        \"IDENTIFIER_TYPE\": \"ANC_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"ANC\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      }\n" +
				"    ],\n" +
				"    \"PATIENT_NAME\": {\n" +
				"      \"FIRST_NAME\": \"GRACE\",\n" +
				"      \"MIDDLE_NAME\": \"MWANIKI\",\n" +
				"      \"LAST_NAME\": \"MONGARE\"\n" +
				"    },\n" +
				"    \"DATE_OF_BIRTH\": \"20111111\",\n" +
				"    \"DATE_OF_BIRTH_PRECISION\": \"EXACT\",\n" +
				"    \"SEX\": \"F\",\n" +
				"    \"DEATH_DATE\": \"\",\n" +
				"    \"DEATH_INDICATOR\": \"N\",\n" +
				"    \"PATIENT_ADDRESS\": {\n" +
				"      \"PHYSICAL_ADDRESS\": {\n" +
				"        \"VILLAGE\": \"KWAKIMANI\",\n" +
				"        \"WARD\": \"KIMANINI\",\n" +
				"        \"SUB_COUNTY\": \"KIAMBU EAST\",\n" +
				"        \"COUNTY\": \"KIAMBU\",\n" +
				"        \"NEAREST_LANDMARK\": \"KIAMBU EAST\"\n" +
				"      },\n" +
				"      \"POSTAL_ADDRESS\": \"789 KIAMBU\"\n" +
				"    },\n" +
				"    \"PHONE_NUMBER\": \"254720278655\",\n" +
				"    \"MARITAL_STATUS\": \"\",\n" +
				"    \"MOTHER_DETAILS\": {\n" +
				"      \"MOTHER_NAME\": {\n" +
				"        \"FIRST_NAME\": \"WAMUYU\",\n" +
				"        \"MIDDLE_NAME\": \"MARY\",\n" +
				"        \"LAST_NAME\": \"WAITHERA\"\n" +
				"      },\n" +
				"      \"MOTHER_IDENTIFIER\": [\n" +
				"        {\n" +
				"          \"ID\": \"1234567\",\n" +
				"          \"IDENTIFIER_TYPE\": \"NATIONAL_ID\",\n" +
				"          \"ASSIGNING_AUTHORITY\": \"GOK\",\n" +
				"          \"ASSIGNING_FACILITY\": \"\"\n" +
				"        },\n" +
				"        {\n" +
				"          \"ID\": \"12345678\",\n" +
				"          \"IDENTIFIER_TYPE\": \"NHIF\",\n" +
				"          \"ASSIGNING_AUTHORITY\": \"NHIF\",\n" +
				"          \"ASSIGNING_FACILITY\": \"\"\n" +
				"        },\n" +
				"        {\n" +
				"          \"ID\": \"12345-67890\",\n" +
				"          \"IDENTIFIER_TYPE\": \"CCC_NUMBER\",\n" +
				"          \"ASSIGNING_AUTHORITY\": \"CCC\",\n" +
				"          \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"        },\n" +
				"        {\n" +
				"          \"ID\": \"12345678\",\n" +
				"          \"IDENTIFIER_TYPE\": \"PMTCT_NUMBER\",\n" +
				"          \"ASSIGNING_AUTHORITY\": \"PMTCT\",\n" +
				"          \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"        }\n" +
				"      ]\n" +
				"    }\n" +
				"  },\n" +
				"  \"NEXT_OF_KIN\": [\n" +
				"    {\n" +
				"      \"NOK_NAME\": {\n" +
				"        \"FIRST_NAME\": \"WAIGURU\",\n" +
				"        \"MIDDLE_NAME\": \"KIMUTAI\",\n" +
				"        \"LAST_NAME\": \"WANJOKI\"\n" +
				"      },\n" +
				"      \"RELATIONSHIP\": \"**AS DEFINED IN GREENCARD\",\n" +
				"      \"ADDRESS\": \"4678 KIAMBU\",\n" +
				"      \"PHONE_NUMBER\": \"25489767899\",\n" +
				"      \"SEX\": \"F\",\n" +
				"      \"DATE_OF_BIRTH\": \"19871022\",\n" +
				"      \"CONTACT_ROLE\": \"T\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"HIV_TEST\": [\n" +
				"    {\n" +
				"      \"DATE\": \"20180101\",\n" +
				"      \"RESULT\": \"POSITIVE\",\n" +
				"      \"TYPE\": \"CONFIRMATORY\",\n" +
				"      \"FACILITY\": \"10829\",\n" +
				"      \"STRATEGY\": \"HP\",\n" +
				"      \"PROVIDER_DETAILS\": {\n" +
				"        \"NAME\": \"MATTHEW NJOROGE, MD\",\n" +
				"        \"ID\": \"12345-67890-abcde\"\n" +
				"      }\n" +
				"    }\n" +
				"  ],\n" +
				"  \"IMMUNIZATION\": [\n" +
				"    {\n" +
				"      \"NAME\": \"OPV_AT_BIRTH\",\n" +
				"      \"DATE_ADMINISTERED\": \"20180101\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"CARD_DETAILS\": {\n" +
				"    \"STATUS\": \"ACTIVE/INACTIVE\",\n" +
				"    \"REASON\": \"LOST/DEATH/DAMAGED\",\n" +
				"    \"LAST_UPDATED\": \"20180101\",\n" +
				"    \"LAST_UPDATED_FACILITY\": \"10829\"\n" +
				"  }\n" +
				"}";
	}

}
