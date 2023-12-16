package org.gly.fmmall.service;

import org.gly.fmmall.vo.ResultVO;

public interface UserService {
    public ResultVO userRegister(String name, String password);

    public ResultVO userLogin (String name, String password);
}
