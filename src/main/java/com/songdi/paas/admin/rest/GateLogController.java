package com.songdi.paas.admin.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.songdi.paas.admin.biz.GateLogBiz;
import com.songdi.paas.admin.entity.GateLog;
import com.songdi.paas.common.rest.BaseController;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 20:32
 */
@Controller
@RequestMapping("/api/admin/gateLog")
public class GateLogController extends BaseController<GateLogBiz, GateLog> {
    // @RequestMapping(value = "/page",method = RequestMethod.GET)
    // @ResponseBody
    // public TableResultResponse<GateLog> page(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue
    // = "1")int offset, String name){
    // Example example = new Example(GateLog.class);
    // if(StringUtils.isNotBlank(name)) {
    // example.createCriteria().andLike("menu", "%" + name + "%");
    // }
    // int count = baseBiz.selectCountByExample(example);
    // PageHelper.startPage(offset, limit);
    // return new TableResultResponse<GateLog>(count,baseBiz.selectByExample(example));
    // }
}
