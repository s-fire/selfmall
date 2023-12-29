package org.gly.fmmall.service;

import org.gly.fmmall.entity.UserAddr;
import org.gly.fmmall.vo.ResultVO;

import java.util.List;

public interface UserAddressService {
    public ResultVO getUserAddressByUserId(int userId);
}
