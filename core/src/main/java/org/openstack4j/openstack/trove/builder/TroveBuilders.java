/*******************************************************************************
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
package org.openstack4j.openstack.trove.builder;

import org.openstack4j.openstack.trove.domain.TroveDatabase;
import org.openstack4j.openstack.trove.domain.TroveDatabase.TroveDatabaseBuilder;
import org.openstack4j.openstack.trove.domain.TroveDatabaseUser;
import org.openstack4j.openstack.trove.domain.TroveDatabaseUser.TroveDatabaseUserBuilder;
import org.openstack4j.openstack.trove.domain.TroveInstanceCreate;
import org.openstack4j.openstack.trove.domain.TroveInstanceCreate.TroveInstanceCreateBuilder;

public class TroveBuilders {

	public TroveInstanceCreateBuilder instanceCreate() {
		return TroveInstanceCreate.builder();
	}

	public TroveDatabaseBuilder databaseCreate() {
		return TroveDatabase.builder();
	}

	public TroveDatabaseUserBuilder databaseUserCreate() {
		return TroveDatabaseUser.builder();
	}

}
