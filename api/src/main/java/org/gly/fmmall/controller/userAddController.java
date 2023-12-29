package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.gly.fmmall.service.UserAddressService;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Api(value = "用户地址管理",tags = "收获地址")
@RequestMapping("/useraddr")
public class userAddController {
    @Autowired
    UserAddressService userAddressService;
    @GetMapping("/list")
    @ApiOperation(value = "用户地址列表")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name="userId",value = "用户Id",required = true)
    })
    public ResultVO listAddress(int userId){
        return userAddressService.getUserAddressByUserId(userId);
    }
}
