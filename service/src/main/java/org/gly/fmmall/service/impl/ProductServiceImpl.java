package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.ProductImgMapper;
import org.gly.fmmall.dao.ProductMapper;
import org.gly.fmmall.dao.ProductParamsMapper;
import org.gly.fmmall.dao.ProductSkuMapper;
import org.gly.fmmall.entity.*;
import org.gly.fmmall.service.ProductService;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductImgMapper productImgMapper;
    @Autowired
    ProductSkuMapper productSkuMapper;
    @Autowired
    ProductParamsMapper productParamsMapper;
    @Override
    public ResultVO listRecommendProducts() {
        List<ProductVO> productVOS = productMapper.selectRecommendProducts();
        return new ResultVO(ResStatus.OK, null, productVOS);
    }

    public ResultVO getProductBasicsInfo(String productId) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        criteria.andEqualTo("productStatus",1);
        List<Product> products = productMapper.selectByExample(example);
        if (!products.isEmpty()){
//            图片
            Example example1 = new Example(ProductImg.class);
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("itemId",productId);
            List<ProductImg> productImgs = productImgMapper.selectByExample(example1);
//            sku
            Example example2 = new Example(ProductSku.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("productId",productId);
            List<ProductSku> productSkus = productSkuMapper.selectByExample(example2);
            HashMap<String,Object> baseInfo = new HashMap<>();
            baseInfo.put("product",products.get(0));
            baseInfo.put("productImgs",productImgs);
            baseInfo.put("productSku",productSkus);
            return new ResultVO(ResStatus.OK,"success",baseInfo);
        }else{
            return new ResultVO(ResStatus.NO,null,null);
        }
    }

    @Override
    public ResultVO getProductParamsByProductId(String productId) {
//        Example.Criteria productId1 = new Example(ProductParams.class).createCriteria().andEqualTo("productId", productId);
        Example example = new Example(ProductParams.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",productId);
        List<ProductParams> productParams1 = productParamsMapper.selectByExample(example);
        if (!productParams1.isEmpty()){
            return new ResultVO(ResStatus.OK,"success",productParams1.get(0));
        }else{
            return new ResultVO(ResStatus.NO,null,null);
        }
    }
}
