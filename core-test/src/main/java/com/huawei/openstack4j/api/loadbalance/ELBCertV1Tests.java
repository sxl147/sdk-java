/*******************************************************************************
 * 	Copyright 2018 Huawei Technologies Co., Ltd.                                     
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.api.loadbalance;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.model.loadbalance.Certificate;
import com.huawei.openstack4j.openstack.loadbalance.domain.ELBCertificate;
import com.huawei.openstack4j.openstack.loadbalance.domain.ELBCertificateUpdate;
import com.huawei.openstack4j.openstack.loadbalance.domain.ELBCertificate.Certificates;

@Test(suiteName = "ELBLoadBalancer/CertV1")
public class ELBCertV1Tests extends AbstractTest {

	private static final String JSON_CERT_CREATE = "/loadbalance/elb_cert_create.json";
	private static final String JSON_CERTS = "/loadbalance/elb_certs.json";
	private static final String JSON_CERT_UPDATE = "/loadbalance/elb_cert_update.json";

	public void testCreateCert() throws IOException {
		respondWith(JSON_CERT_CREATE);
		Certificate cert = ELBCertificate.builder().name("SDK-test-cert").description("desc")
				.certificate(
						"-----BEGIN CERTIFICATE-----\nMIIDXTCCAkWgAwIBAgIJANoPUy2NktS6MA0GCSqGSIb3DQEBBQUAMEUxCzAJBgNV\nBAYTAkFVMRMwEQYDVQQIDApTb21lLVN0YXRlMSEwHwYDVQQKDBhJbnRlcm5ldCBX\naWRnaXRzIFB0eSBMdGQwHhcNMTYwNjIyMDMyOTU5WhcNMTkwNjIyMDMyOTU5WjBF\nMQswCQYDVQQGEwJBVTETMBEGA1UECAwKU29tZS1TdGF0ZTEhMB8GA1UECgwYSW50\nZXJuZXQgV2lkZ2l0cyBQdHkgTHRkMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIB\nCgKCAQEArmUUhzm5sxxVr/ku4+6cKqnKgZvDl+e/6CNCAq8YMZXTpJP64DjDPny9\n+8s9MbFabEG3HqjHSKh3b/Ew3FXr8LFa9YuWuAi3W9ii29sZsOwmzIfQhIOIaP1Y\nNR50DDjbAGTaxzRhV40ZKSOCkaUTvl3do5d8ttD1VlF2r0w0DfclrVcsS5v3kw88\n9gJ3s3hNkatfQiSt4qLNMehZ8Xofx58DIAOk/f3Vusj3372PsJwKX39cHX/NpIHC\nHKE8qaGCpDqv0daH766eJ065dqO9DuorXPaPT/nxw4PAccb9fByLrTams0ThvSlZ\no6V3yvHR4KN7mmvbViEmWRy+9oiJEwIDAQABo1AwTjAdBgNVHQ4EFgQUlXhcABza\n2SdXPYpp8RkWvKblCNIwHwYDVR0jBBgwFoAUlXhcABza2SdXPYpp8RkWvKblCNIw\nDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQUFAAOCAQEAHmsFDOwbkD45PF4oYdX+\ncCoEGNjsLfi0spJ6b1CHQMEy2tPqYZJh8nGuUtB9Zd7+rbwm6NS38eGQVA5vbWZH\nMk+uq5un7YFwkM+fdjgCxbe/3PMkk/ZDYPHhpc1W8e/+aZVUBB2EpfzBC6tcP/DV\nSsjq+tG+JZIVADMxvEqVIF94JMpuY7o6U74SnUUrAi0h9GkWmeYh/Ucb3PLMe5sF\noZriRdAKc96KB0eUphfWZNtptOCqV6qtYqZZ/UCotp99xzrDkf8jGkm/iBljxb+v\n0NTg8JwfmykCj63YhTKpHf0+N/EK5yX1KUYtlkLaf8OPlsp/1lqAL6CdnydGEd/s\nAA==\n-----END CERTIFICATE-----")
				.privateKey(
						"-----BEGIN RSA PRIVATE KEY-----\nMIIEpAIBAAKCAQEArmUUhzm5sxxVr/ku4+6cKqnKgZvDl+e/6CNCAq8YMZXTpJP6\n4DjDPny9+8s9MbFabEG3HqjHSKh3b/Ew3FXr8LFa9YuWuAi3W9ii29sZsOwmzIfQ\nhIOIaP1YNR50DDjbAGTaxzRhV40ZKSOCkaUTvl3do5d8ttD1VlF2r0w0DfclrVcs\nS5v3kw889gJ3s3hNkatfQiSt4qLNMehZ8Xofx58DIAOk/f3Vusj3372PsJwKX39c\nHX/NpIHCHKE8qaGCpDqv0daH766eJ065dqO9DuorXPaPT/nxw4PAccb9fByLrTam\ns0ThvSlZo6V3yvHR4KN7mmvbViEmWRy+9oiJEwIDAQABAoIBACV47rpHuxEza24O\nevbbFI9OQIcs8xA26dN1j/+HpAkzinB4o5V+XOWWZDQwbYu58hYE4NYjqf6AxHk3\nOCqAA9yKH2NXhSEyLkP7/rKDF7geZg/YtwNiR/NXTJbNXl4p8VTaVvAq3yey188x\nJCMrd1yWSsOWD2Qw7iaIBpqQIzdEovPE4CG6GmaIRSuqYuoCfbVTFa6YST7jmOTv\nEpG+x6yJZzJ4o0vvfKbKfvPmQizjL+3nAW9g+kgXJmA1xTujiky7bzm2sLK2Slrx\n5rY73mXMElseSlhkYzWwyRmC6M+rWALXqOhVDgIGbaBV4IOzuyH/CUt0wy3ZMIpv\nMOWMNoECgYEA1LHsepCmwjlDF3yf/OztCr/DYqM4HjAY6FTmH+xz1Zjd5R1XOq60\nYFRkhs/e2D6M/gSX6hMqS9sCkg25yRJk3CsPeoS9v5MoiZQA8XlQNovcpWUI2DCm\naZRIsdovFgIqMHYh/Y4CYouee7Nz7foICzO9svrYrbOIVmMwDVJ8vzMCgYEA0ebg\nm0lCuOunyxaSBqOv4Q4sk7Ix0702dIrW0tsUJyU+xuXYH1P/0m+t4/KUU2cNwsg3\njiNzQR9QKvF8yTB5TB4Ye/9dKlu+BEOskvCpuErxc6iVJ+TZOrQDDPNcq56qez5b\nvv9EDdgzpjkjO+hS1j3kYOuG11hrP4Pox4PijqECgYEAz6RTZORKqFoWsZss5VK3\np0LGkEkfw/jYmBgqAQhpnSD7n20hd1yPI2vAKAxPVXTbWDFLzWygYiWRQNy9fxrB\n9F7lYYqtY5VagdVHhnYUZOvtoFoeZFA6ZeAph9elGCtM3Lq3PD2i/mmncsQibTUn\nHSiKDWzuk8UtWIjEpHze5BkCgYEAifD9eG+bzqTnn1qU2pIl2nQTLXj0r97v84Tu\niqF4zAT5DYMtFeGBBI1qLJxVh7342CH2CI4ZhxmJ+L68sAcQH8rDcnGui1DBPlIv\nDl3kW3280bJfW1lUvPRh8NfZ9dsO1HF1n75nveVwg/OWyR7zmWIRPPRrqAeua45H\nox5z/CECgYBqwlEBjue8oOkVVu/lKi6fo6jr+0u25K9dp9azHYwE0KNHX0MwRALw\nWbPgcjge23sfhbeqVvHo0JYBdRsk/OBuW73/9Sb5E+6auDoubCjC0cAIvs23MPju\nsMvKak4mQkI19foRXBydB/DDkK26iei/l0xoygrw50v2HErsQ7JcHw==\n-----END RSA PRIVATE KEY-----")
				.build();
		Certificate create = osv3().loadBalancer().certs().create(cert);
		assertTrue("60884e005ce546b1b580bf259cd37016".equals(create.getId()));
	}

	public void testDeleteCert() {
		respondWith(204);
		String certificateId = "60884e005ce546b1b580bf259cd37016";
		ActionResponse resp = osv3().loadBalancer().certs().delete(certificateId);
		assertTrue(resp.isSuccess(), resp.getFault());
	}

	public void testUpdateCert() throws IOException {
		respondWith(JSON_CERTS);
		respondWith(JSON_CERT_UPDATE);
		Certificates certs = osv3().loadBalancer().certs().list();
		assertTrue(certs != null && Integer.valueOf(certs.getInstanceNum()) == 1, "No cert for update");

		Certificate cert = certs.getCertificates().get(0);
		String after = new StringBuilder(cert.getDescription()).reverse().toString();
		ELBCertificateUpdate update = ELBCertificateUpdate.fromCertificate(cert).toBuilder().description(after).build();
		Certificate afterUpdate = osv3().loadBalancer().certs().update(cert.getId(), update);
		assertTrue(after.equals(afterUpdate.getDescription()));
	}
	
	@Override
	protected Service service() {
		return Service.LOAD_BALANCER;
	}
}
