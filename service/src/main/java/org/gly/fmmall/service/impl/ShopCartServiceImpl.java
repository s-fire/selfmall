package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.ShoppingCartMapper;
import org.gly.fmmall.entity.ShoppingCart;
import org.gly.fmmall.entity.ShoppingCartVO;
import org.gly.fmmall.service.ShopCartService;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;
    @Override
    public ResultVO addShopCart(ShoppingCart cart) {
        int i = shoppingCartMapper.insert(cart);
        if (i > 0 ){
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }

    @Override
    public ResultVO listShopCart(String userId) {
        List<ShoppingCartVO> shoppingCartVOList = shoppingCartMapper.selectShopCartListByUserId(userId);
        return new ResultVO(ResStatus.OK,"success",shoppingCartVOList);
    }

    @Override
    public ResultVO updateShopCarByCarId(int carId, int carNum) {
        int i = shoppingCartMapper.updateCartById(carId, carNum);
        if(i>0){
            return new ResultVO(ResStatus.OK,"success",null);
        }else{
            return new ResultVO(ResStatus.NO,"fail",null);
        }
    }
}
