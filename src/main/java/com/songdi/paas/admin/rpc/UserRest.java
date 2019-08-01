package com.songdi.paas.admin.rpc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.songdi.paas.admin.rpc.service.PermissionService;
import com.songdi.paas.api.authority.vo.PermissionInfo;
import com.songdi.paas.api.vo.user.UserInfo;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-21 8:15
 */
@RestController
@RequestMapping("api")
public class UserRest {
    @Autowired
    private PermissionService permissionService;

    // @Cache(key = "permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public @ResponseBody List<PermissionInfo> getAllPermission() {
        return permissionService.getAllPermission();
    }

    // @Cache(key = "permission:u{1}")
    @RequestMapping(value = "/user/un/{username}/permissions", method = RequestMethod.GET)
    public @ResponseBody List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username) {
        return permissionService.getPermissionByUsername(username);
    }

    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
    public @ResponseBody UserInfo validate(@RequestBody Map<String, String> body) {
        return permissionService.validate(body.get("username"), body.get("password"));
    }

}
