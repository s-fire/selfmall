package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.CategoryMapper;
import org.gly.fmmall.entity.CategoryVO;
import org.gly.fmmall.service.CategoryService;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public ResultVO selectAllCategories() {
        List<CategoryVO> categoryVos = categoryMapper.selectAllCategories2(0);
        return new ResultVO(ResStatus.OK,"success",categoryVos);
    }

    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        return new ResultVO(ResStatus.OK,"success",categoryVOS);
    }
}
