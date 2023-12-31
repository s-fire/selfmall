package org.gly.fmmall.service;

import org.gly.fmmall.vo.ResultVO;

public interface ProductService {
    public ResultVO  listRecommendProducts();

    public ResultVO getProductBasicsInfo(String productId);

    public ResultVO getProductParamsByProductId(String productId);

}
