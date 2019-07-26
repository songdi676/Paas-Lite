package com.songdi.paas.admin.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songdi.paas.admin.entity.ResourceAuthority;
import com.songdi.paas.admin.mapper.ResourceAuthorityMapper;
import com.songdi.paas.common.biz.BaseBiz;

/**
 * Created by Ace on 2017/6/19.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceAuthorityBiz extends BaseBiz<ResourceAuthorityMapper, ResourceAuthority> {}
