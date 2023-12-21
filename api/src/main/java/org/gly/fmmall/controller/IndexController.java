package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.gly.fmmall.service.CategoryService;
import org.gly.fmmall.service.IndexImagesService;
import org.gly.fmmall.service.ProductService;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
@Api(value = "首页相关接口", tags = "首页管理")
@CrossOrigin
public class IndexController {
    @Autowired
    IndexImagesService indexImagesService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/imageList")
    @ApiOperation("首页轮播图")
    public ResultVO listIndexImgs() {
        return indexImagesService.queryIndexImages();
    }

    @GetMapping("/category-list")
    @ApiOperation("分类列表接口")
    public ResultVO listCategory() {
        return categoryService.selectAllCategories();
    }

    @GetMapping("/list-recommends")
    @ApiOperation("商品推荐接口")
    public ResultVO listRecommendProducts() {
        return productService.listRecommendProducts();
    }
}
