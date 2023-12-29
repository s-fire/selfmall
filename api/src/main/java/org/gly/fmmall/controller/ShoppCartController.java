package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.gly.fmmall.entity.ShoppingCart;
import org.gly.fmmall.service.ShopCartService;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(value = "购物车接口",tags = "购物车管理")
public class ShoppCartController {
    @Autowired
    ShopCartService shopCartService;
    @PostMapping("/add")
    @ApiOperation(value = "添加购物车")
    public ResultVO addCarts(@RequestBody ShoppingCart cart){
        return shopCartService.addShopCart(cart);
    }

    @GetMapping("/list")
    @ApiOperation(value = "购物车列表接口")
    @ApiImplicitParams({@ApiImplicitParam(dataType = "int",name = "userId", value = "用户ID",required = true)})
    public ResultVO listCarts(String userId){
        return shopCartService.listShopCart(userId);
    }
    @GetMapping("/update/{cid}/{cnum}")
    @ApiOperation(value = "修改购物车")
    public ResultVO updateCar(@PathVariable("cid") Integer cid,@PathVariable("cnum") Integer cnum){
        return shopCartService.updateShopCarByCarId(cid,cnum);
    }
}
