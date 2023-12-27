package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.gly.fmmall.service.ProductCommentService;
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
    @Autowired
    ProductCommentService productCommentService;

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

    @ApiOperation("商品评论接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页码", required = true),
            @ApiImplicitParam(dataType = "int", name = "limit", value = "显示条数", required = true)
    })
    @GetMapping("/detail-commonts/{pid}")
    public ResultVO getProductCommentByPid(@PathVariable String pid, int pageNum, int limit) {
        return productCommentService.getProductComments(pid, pageNum, limit);
    }
    @ApiOperation("商品评论统计接口")
    @GetMapping("/detail-commontscount/{pid}")
    public ResultVO getProductCommentCount(@PathVariable String pid){
        return productCommentService.getProductCommentsCount(pid);
    }
}
