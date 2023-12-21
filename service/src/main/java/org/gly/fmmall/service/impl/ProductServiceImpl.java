package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.ProductMapper;
import org.gly.fmmall.entity.ProductVO;
import org.gly.fmmall.service.ProductService;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public ResultVO listRecommendProducts() {
         List<ProductVO> productVOS= productMapper.selectRecommendProducts();
         return new ResultVO(ResStatus.OK,null,productVOS);
    }
}
