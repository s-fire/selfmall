package org.gly.fmmall.service;

import org.gly.fmmall.entity.ShoppingCart;
import org.gly.fmmall.vo.ResultVO;

public interface ShopCartService {
    public ResultVO addShopCart(ShoppingCart cart);

    public ResultVO listShopCart(String userId);

    public ResultVO updateShopCarByCarId(int carId,int carNum);
}
