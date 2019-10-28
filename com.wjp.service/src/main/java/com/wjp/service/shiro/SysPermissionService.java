package com.wjp.service.shiro;

import java.util.List;

public interface SysPermissionService {
    List<String> selectPermissionByUserId(Long userId);
}
