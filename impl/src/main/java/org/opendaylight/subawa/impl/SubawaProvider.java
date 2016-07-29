/*
 * Copyright © 2015 Cisco and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.subawa.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.subawa.rev150105.SubawaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubawaProvider implements BindingAwareProvider, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(SubawaProvider.class);
    private RpcRegistration<SubawaService> subawaService;


    @Override
    public void onSessionInitiated(ProviderContext session) {
        LOG.info("SubawaProvider Session Initiated");
        DataBroker db = session.getSALService(DataBroker.class);
        subawaService = session.addRpcImplementation(SubawaService.class, new SubawaImp(db));
    }

    @Override
    public void close() throws Exception {
        LOG.info("SubawaProvider Closed");
    }

}
