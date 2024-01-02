package org.gly.fmmall.dao;

import org.apache.ibatis.annotations.Param;
import org.gly.fmmall.entity.ShoppingCart;
import org.gly.fmmall.entity.ShoppingCartVO;
import org.gly.fmmall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {
    public List<ShoppingCartVO> selectShopCartListByUserId(String userId);

    public int updateCartById(@Param("carId") int carId,@Param("carNum") int carNum);

    public List<ShoppingCartVO> selectShopCarsByCids(List<Integer> cids);
}