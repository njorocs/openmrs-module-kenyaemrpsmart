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
package org.openmrs.module.kenyaemrpsmart.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openmrs.module.kenyaemrpsmart.jsonvalidator.mapper.IncomingPatientSHR;
import org.openmrs.module.kenyaemrpsmart.jsonvalidator.mapper.OutgoingPatientSHR;
import org.openmrs.test.BaseModuleContextSensitiveTest;

/**
 * Tests {@link {EndPointService}}.
 */

public class IncomingPatientSHRTest extends BaseModuleContextSensitiveTest {

	@Before
	public void setup() throws Exception {
		executeDataSet("dataset/test-dataset.xml");
	}
	@Test
	public void shouldReturnPatientSHR() {

		IncomingPatientSHR shr = new IncomingPatientSHR(getIncomingSHRSample());
		Assert.assertNotNull(shr.processIncomingSHR());
	}

	private String getIncomingSHRSample () {
		return "{\n" +
				"  \"VERSION\": \"1.0.0\",\n" +
				"  \"PATIENT_IDENTIFICATION\": {\n" +
				"    \"EXTERNAL_PATIENT_ID\": {\n" +
				"      \"ID\": \"110ec58a-a0f2-4ac4-8393-c866d813b8d1\",\n" +
				"      \"IDENTIFIER_TYPE\": \"GODS_NUMBER\",\n" +
				"      \"ASSIGNING_AUTHORITY\": \"MPI\",\n" +
				"      \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"    },\n" +
				"    \"INTERNAL_PATIENT_ID\": [\n" +
				"      {\n" +
				"        \"ID\": \"12345678-ADFGHJY-0987654-NHYI890\",\n" +
				"        \"IDENTIFIER_TYPE\": \"CARD_SERIAL_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"CARD_REGISTRY\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"12345678\",\n" +
				"        \"IDENTIFIER_TYPE\": \"HEI_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"MCH\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"12345678\",\n" +
				"        \"IDENTIFIER_TYPE\": \"CCC_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"CCC\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"001\",\n" +
				"        \"IDENTIFIER_TYPE\": \"HTS_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"HTS\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      },\n" +
				"      {\n" +
				"        \"ID\": \"ABC567\",\n" +
				"        \"IDENTIFIER_TYPE\": \"ANC_NUMBER\",\n" +
				"        \"ASSIGNING_AUTHORITY\": \"ANC\",\n" +
				"        \"ASSIGNING_FACILITY\": \"10829\"\n" +
				"      }\n" +
				"    ],\n" +
				"    \"PATIENT_NAME\": {\n" +
				"      \"FIRST_NAME\": \"THERESA\",\n" +
				"      \"MIDDLE_NAME\": \"MAY\",\n" +
				"      \"LAST_NAME\": \"WAIRIMU\"\n" +
				"    },\n" +
				"    \"DATE_OF_BIRTH\": \"20131111\",\n" +
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
				"    \"PHONE_NUMBER\": \"254720278654\",\n" +
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
