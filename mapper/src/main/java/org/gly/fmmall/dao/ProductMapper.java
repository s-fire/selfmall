package org.gly.fmmall.dao;

import org.gly.fmmall.entity.Product;
import org.gly.fmmall.entity.ProductVO;
import org.gly.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper extends GeneralDAO<Product> {
    public List<ProductVO> selectRecommendProducts();
}