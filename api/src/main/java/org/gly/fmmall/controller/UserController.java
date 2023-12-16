package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.gly.fmmall.entity.Users;
import org.gly.fmmall.service.UserService;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(value = "提供用户管理相关接口", tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private User user;

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({@ApiImplicitParam(dataType = "string", name = "username", value = "用户名称", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户密码", required = true)})
    @PostMapping("/register")
    public ResultVO userRegister(@RequestBody Users user) {
        return userService.userRegister(user.getUsername(), user.getPassword());
//        return new ResultVo(200,"成功",null);
    }

    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "username", value = "用户登录账号", required = true),
            @ApiImplicitParam(dataType = "string", name = "password", value = "用户登录密码", required = true)
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String username,
                          @RequestParam(value = "password") String password) {
        return userService.userLogin(username, password);
    }
}
