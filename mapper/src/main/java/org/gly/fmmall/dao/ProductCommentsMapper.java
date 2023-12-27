package org.gly.fmmall.dao;

import org.apache.ibatis.annotations.Param;
import org.gly.fmmall.entity.ProductComments;
import org.gly.fmmall.entity.ProductCommentsVO;
import org.gly.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentsMapper extends GeneralDAO<ProductComments> {
    public List<ProductCommentsVO> selectProductCommentByProductId(@Param("productId") String productId,
                                                                   @Param("start") int start,
                                                                   @Param("limit") int limit);
}