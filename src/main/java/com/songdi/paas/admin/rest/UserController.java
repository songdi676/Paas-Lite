package com.songdi.paas.admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.songdi.paas.admin.biz.MenuBiz;
import com.songdi.paas.admin.biz.UserBiz;
import com.songdi.paas.admin.entity.Menu;
import com.songdi.paas.admin.entity.User;
import com.songdi.paas.admin.rpc.service.PermissionService;
import com.songdi.paas.admin.vo.FrontUser;
import com.songdi.paas.admin.vo.MenuTree;
import com.songdi.paas.auth.client.annotation.IgnoreUserToken;
import com.songdi.paas.common.rest.BaseController;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-08 11:51
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz, User> {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private MenuBiz menuBiz;

    
    @RequestMapping(value = "/front/info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(String token) throws Exception {
        FrontUser userInfo = permissionService.getUserInfo(token);
        if (userInfo == null) {
            return ResponseEntity.status(401).body(false);
        } else {
            return ResponseEntity.ok(userInfo);
        }
    }

    @RequestMapping(value = "/front/menus", method = RequestMethod.GET)
    public @ResponseBody List<MenuTree> getMenusByUsername(String token) throws Exception {
        return permissionService.getMenusByUsername(token);
    }

    @RequestMapping(value = "/front/menu/all", method = RequestMethod.GET)
    @IgnoreUserToken
    public @ResponseBody List<Menu> getAllMenus() throws Exception {
        return menuBiz.selectListAll();
    }
}
