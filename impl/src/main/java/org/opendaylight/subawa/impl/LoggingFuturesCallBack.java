package org.opendaylight.subawa.impl;

import com.google.common.util.concurrent.FutureCallback;
import org.opendaylight.controller.md.sal.common.api.data.OptimisticLockFailedException;
import org.slf4j.Logger;

/**
 * Created by odldev on 7/7/16.
 */
public class LoggingFuturesCallBack<V> implements FutureCallback<V> {

    private Logger LOG;
    private String messageSuccess;
    private String messageFailure;

    public LoggingFuturesCallBack(String messageSuccess, String messageFailure,Logger LOG) {
        this.messageSuccess = messageSuccess;
        this.messageFailure = messageFailure;
        this.LOG = LOG;
    }

    @Override
    public void onFailure(Throwable e) {
        LOG.warn(messageFailure,e);

    }

    @Override
    public void onSuccess(V arg0) {
        LOG.info(messageSuccess, arg0);

    }

}
