package org.gly.fmmall.dao;

import org.gly.fmmall.entity.ProductImg;
import org.gly.fmmall.general.GeneralDAO;

import java.util.List;

public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    public List<ProductImg> selectProductImgByProductId(int productId);
}