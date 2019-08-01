package com.songdi.paas.admin.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.songdi.paas.admin.entity.GroupType;
import com.songdi.paas.admin.mapper.GroupTypeMapper;
import com.songdi.paas.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-12 8:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class GroupTypeBiz extends BaseBiz<GroupTypeMapper, GroupType> {}
