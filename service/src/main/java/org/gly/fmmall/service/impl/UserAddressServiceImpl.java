package org.gly.fmmall.service.impl;

import org.gly.fmmall.dao.UserAddrMapper;
import org.gly.fmmall.entity.UserAddr;
import org.gly.fmmall.service.UserAddressService;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddrMapper userAddrMapper;
    @Override
    public ResultVO getUserAddressByUserId(int userId) {
        Example example = new Example(UserAddr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        List<UserAddr> userAddrs = userAddrMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK,"success",userAddrs);
    };
}
