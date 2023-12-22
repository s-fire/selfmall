package org.gly.fmmall.dao;

import org.gly.fmmall.entity.Category;
import org.gly.fmmall.entity.CategoryVO;
import org.gly.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper extends GeneralDAO<Category> {
    public List<CategoryVO> selectAllCategories();
    public List<CategoryVO> selectAllCategories2(int parentId);

    public List<CategoryVO> selectFirstLevelCategories();
}