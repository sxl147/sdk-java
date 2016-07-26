package org.openstack4j.api.network;


import org.openstack4j.api.AbstractTest;
import org.openstack4j.api.Builders;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.network.ext.LoadBalancerV2;
import org.openstack4j.model.network.ext.LoadBalancerV2Update;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

/**
 *
 * @author ashleykasim
 *
 */
@Test(suiteName="Network/loadBalancerV2", enabled = true)
public class LoadBalancerV2Tests extends AbstractTest {
    private static final String LOADBALANCERSV2_JSON = "/network/loadbalancersv2.json";
    private static final String LOADBALANCERV2_JSON = "/network/loadbalancerv2.json";
    private static final String LOADBALANCERV2_UPDATE_JSON = "/network/loadbalancerv2_update.json";

    public void testListLoadBalancersV2() throws IOException {
        respondWith(LOADBALANCERSV2_JSON);
        List<? extends LoadBalancerV2> list = osv3().networking().lbaasV2().loadbalancerV2().list();
        assertEquals(list.size(), 3);
        assertEquals(list.get(0).getName(), "lb1");
    }

    public void testListLoadBalancersV2Filter() throws IOException {
        respondWith(LOADBALANCERSV2_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("provider", "octavia");
        List<? extends LoadBalancerV2> list = osv3().networking().lbaasV2().loadbalancerV2().list(map);
        assertEquals(list.size(), 3);
    }

    public void testGetLoadBalancerV2() throws IOException {
        respondWith(LOADBALANCERV2_JSON);
        String id = "282b71ea-9ceb-4cd6-8881-cb511af2edb5";
        LoadBalancerV2 lb = osv3().networking().lbaasV2().loadbalancerV2().get(id);
        assertNotNull(lb);
        assertEquals(lb.getId(), id);
    }

    public void testCreateLoadBalancerV2() throws IOException {
        respondWith(LOADBALANCERV2_JSON);
        String name = "lb1";
        String description = "im a baby lb";
        String address = "10.0.0.13";
        String subnetId = "388c5684-86b0-49ab-90ef-944b1f7328f8";
        LoadBalancerV2 create = Builders.loadbalancerV2()
                .adminStateUp(false)
                .name(name)
                .description(description)
                .address(address)
                .subnetId(subnetId)
                .build();
        LoadBalancerV2 result = osv3().networking().lbaasV2().loadbalancerV2().create(create);
        assertEquals(result.getName(), name);
        assertEquals(result.getDescription(), description);
        assertEquals(result.getVIPAddress(), address);
        assertEquals(result.getVIPSubnetId(), subnetId);
        assertFalse(result.isAdminStateUp());
    }

    public void testUpdateLoadBalancerV2() throws IOException {
        respondWith(LOADBALANCERV2_UPDATE_JSON);
        String name = "lb_updated";
        String description = "im no longer a baby lb";
        LoadBalancerV2Update update = Builders.loadBalancerV2Update()
                .adminStateUp(true)
                .description(description)
                .name(name)
                .build();
        LoadBalancerV2 result = osv3().networking().lbaasV2().loadbalancerV2().update("282b71ea-9ceb-4cd6-8881-cb511af2edb5", update);
        assertTrue(result.isAdminStateUp());
        assertEquals(result.getName(), name);
        assertEquals(result.getDescription(), description);
    }

    public void testDeleteLoadbalancerV2() {
        respondWith(204);
        ActionResponse result = osv3().networking().lbaasV2().loadbalancerV2().delete("282b71ea-9ceb-4cd6-8881-cb511af2edb5");
        assertTrue(result.isSuccess());
    }

    @Override
    protected Service service() {
        return Service.NETWORK;
    }
}
