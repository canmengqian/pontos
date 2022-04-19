package com.pontons.springboot.nacosconfig.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("discovery")
@Api("nacos测试")
@NacosPropertySource(dataId = "nacos-config", autoRefreshed = true)
public class DiscoveryController {

    @NacosInjected
    private ConfigService configService;

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;


    @RequestMapping(value = "/get", method = GET)
    public String get(@RequestParam String serviceName) throws NacosException {
        return configService.getServerStatus();
    }

    @RequestMapping(value = "/config/value", method = GET)
    public String configValue() throws NacosException {
        return ""+useLocalCache;
    }


    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "/service/get", method = GET)
    @ResponseBody
    public List<Instance> serviceGet(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
