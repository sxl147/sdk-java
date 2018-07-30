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
package com.huawei.openstack4j.openstack.cdn.v1.internal;

import com.google.common.base.Preconditions;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Log.Logs;
import com.huawei.openstack4j.openstack.cdn.v1.exception.ServerCdnErrorResponseException;

/**
 * CDN Logs Service
 * 
 * @author ChangjunZhao
 * @date 2018-05-06
 */
public class LogService extends BaseCdnServices {
	
	/**
	 * Querying Logs
	 * @param domainName
	 * @param queryDate
	 * @param pageSize
	 * @param pageNumber
	 * @return {@link Logs} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public Logs queryLogs(String domainName, Long queryDate, Integer pageSize, Integer pageNumber) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(queryDate, "parameter `queryDate` should not be null");
		Preconditions.checkNotNull(pageSize, "parameter `pageSize` should not be null");
		Preconditions.checkNotNull(pageNumber, "parameter `pageNumber` should not be null");
		Invocation<Logs> logsInvocation = get(Logs.class,
				uri("/logs")).param("domain_name", domainName).param("query_date", queryDate)
				.param("page_size",pageSize).param("page_number", pageNumber);

		return logsInvocation.execute(this.buildExecutionOptions(Logs.class));
	}

}
