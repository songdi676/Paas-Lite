package com.songdi.paas.admin.rpc;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.songdi.paas.admin.biz.GateLogBiz;
import com.songdi.paas.admin.entity.GateLog;
import com.songdi.paas.api.vo.log.LogInfo;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 14:39
 */
@RequestMapping("api")
@RestController
public class LogRest {
    @Autowired
    private GateLogBiz gateLogBiz;

    @RequestMapping(value = "/log/save", method = RequestMethod.POST)
    public @ResponseBody void saveLog(@RequestBody LogInfo info) {
        GateLog log = new GateLog();
        BeanUtils.copyProperties(info, log);
        log.setCrtTime(new Date(info.getCrtTime()));
        gateLogBiz.insertSelective(log);
    }
}
