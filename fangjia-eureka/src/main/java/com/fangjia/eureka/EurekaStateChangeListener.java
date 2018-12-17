package com.fangjia.eureka;

import com.netflix.appinfo.InstanceInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Eureka事件监听
 *
 * @author yinjihuan
 * @create 2018-03-09 13:45
 **/
@Component
public class EurekaStateChangeListener {

    private Log log = LogFactory.getLog(EurekaStateChangeListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.error(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        log.info(event.getInstanceInfo().getAppName() + "进行注册....");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("注册中心启动....");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka-Server启动....");
    }
}
