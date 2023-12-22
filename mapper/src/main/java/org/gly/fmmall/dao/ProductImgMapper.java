package org.gly.fmmall.dao;

import org.gly.fmmall.entity.ProductImg;
import org.gly.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    public List<ProductImg> selectProductImgByProductId(int productId);
}