package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.ProductCommentsMapper;
import org.gly.fmmall.entity.ProductComments;
import org.gly.fmmall.entity.ProductCommentsVO;
import org.gly.fmmall.service.ProductCommentService;
import org.gly.fmmall.utils.PageHelper;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductCommentImpl implements ProductCommentService {
    @Autowired
    ProductCommentsMapper productCommentsMapper;

    @Override
    public ResultVO getProductComments(String pid, int pageNum, int limit) {
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",pid);
        List<ProductComments> productCommentsList = productCommentsMapper.selectByExample(example);
        int count = productCommentsList.size();

        int pageCount = count%limit == 0? count/limit : (count/limit)+1;

        int start = (pageNum-1)*limit;
        List<ProductCommentsVO> productCommentsVOS = productCommentsMapper.selectProductCommentByProductId(pid, start, limit);
        return new ResultVO(ResStatus.OK, "success", new PageHelper<ProductCommentsVO>(pageCount,count,productCommentsVOS));
    }

    @Override
    public ResultVO getProductCommentsCount(String pid) {
        Example example = new Example(ProductComments.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",pid);
        int total = productCommentsMapper.selectCountByExample(example);

        Example example1 = new Example(ProductComments.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("productId",pid);
        criteria1.andEqualTo("commType",1);
        int goodTotal = productCommentsMapper.selectCountByExample(example1);

        Example example2 = new Example(ProductComments.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("productId",pid);
        criteria2.andEqualTo("commType",0);
        int middleTotal = productCommentsMapper.selectCountByExample(example2);

        Example example3 = new Example(ProductComments.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andEqualTo("productId",pid);
        criteria3.andEqualTo("commType",-1);
        List<ProductComments> badTotal = productCommentsMapper.selectByExample(example3);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("total",total);
        hashMap.put("goodTotal",goodTotal);
        hashMap.put("middleTotal",middleTotal);
        hashMap.put("badTotal",badTotal.size());
        return new ResultVO(ResStatus.OK,"success",hashMap);
    }
}
