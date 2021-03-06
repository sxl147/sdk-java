package com.huawei.openstack4j.openstack.vpc.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.vpc.v1.contants.PublicIpStatus;
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("publicip")
public class VirtualPublicIp implements ModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2488535914184128625L;
	@JsonProperty("id")
	private String id;
	@JsonProperty("status")
	private PublicIpStatus status;
	@JsonProperty("profile")
	private VirtualProfile profile;
	@JsonProperty("type")
	private String type;
	@JsonProperty("public_ip_address")
	private String publicIpAddress;
	@JsonProperty("private_ip_address")
	private String privateIpAddress;
	@JsonProperty("port_id")
	private String portId;
	@JsonProperty("tenant_id")
	private String tenantId;
	@JsonProperty("create_time")
	private String createTime;
	@JsonProperty("bandwidth_id")
	private String bandwidthId;
	@JsonProperty("bandwidth_size")
	private String bandwidthSize;
	@JsonProperty("bandwidth_share_type")
	private String bandwidthShareType;
	@JsonProperty("bandwidth_name")
	private String bandwidthName;
	@JsonProperty("enterprise_project_id")
	private String enterpriseProjectId;
	
}
