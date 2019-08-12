/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   康鸿
 * Date:     2019/8/8 14:17
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.manager.web;


import com.kh.pojo.ResponseResult;
import com.kh.pojo.entity.MenuInfo;
import com.manager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/12
 * @since 1.0.0
 * Description
 */

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    //获取权限列表
    @RequestMapping("menuList")
    @ResponseBody
    public ResponseResult findMenu() {
        ResponseResult responseResult = new ResponseResult();

        List<MenuInfo> forMenuInfo = menuService.getForMenuInfo(0L);
        responseResult.setResult(forMenuInfo);
        responseResult.setCode(200);
        responseResult.setSuccess("列表返回成功");
        return responseResult;
    }

}