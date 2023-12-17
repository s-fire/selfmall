package org.gly.fmmall.controller;

import io.swagger.annotations.Api;
import org.gly.fmmall.service.IndexImagesService;
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
    @GetMapping("/imageList")
    public ResultVO listIndexImgs(){
        return indexImagesService.queryIndexImages();
    }
}
