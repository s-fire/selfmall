package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.gly.fmmall.service.ProductService;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
@Api(value = "商品信息接口", tags = "商品管理")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/detail-info/{pid}")
    @ApiOperation(value = "查询商品基本信息")
    public ResultVO getProductBasicInfo(@PathVariable String pid) {
        return productService.getProductBasicsInfo(pid);
    }
    @GetMapping("/detail-params/{pid}")
    @ApiOperation(value = "查询商品参数信息")
    public ResultVO getProductParams(@PathVariable String pid) {
        return productService.getProductParamsByProductId(pid);
    }
}
