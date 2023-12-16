package org.gly.fmmall.service.impl;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.gly.fmmall.dao.UsersMapper;
import org.gly.fmmall.entity.Users;
import org.gly.fmmall.service.UserService;
import org.gly.fmmall.utils.MD5Utils;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Users user;

    @Override
    public ResultVO userRegister(String name, String password) {
//        User user = userDao.queryUserByName(name);
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> users = usersMapper.selectByExample(example);
        if (users.isEmpty()) {
            String md5Pwd = MD5Utils.md5(password);
            user.setUsername(name);
            user.setPassword(md5Pwd);
            user.setUserRegtime(new Date());
            user.setUserModtime(new Date());
            user.setUserImg("img/default.png");
            int i = usersMapper.insertUseGeneratedKeys(user);
            if (i > 0) {
                return new ResultVO(200, "注册成功", null);
            } else {
                return new ResultVO(500, "注册失败", null);
            }
        } else {
            return new ResultVO(500, "用户名已存在", null);
        }
    }

    @Override
    public ResultVO userLogin(String name, String password) {
        // 创建一个 Example 对象，传入 Users.class
        Example example = new Example(Users.class);
        // 创建 Example 的查询条件
        Example.Criteria criteria = example.createCriteria();
        // 添加查询条件，根据用户名相等来查询
        criteria.andEqualTo("username", name);
        // 根据 Example 对象进行查询，返回符合条件的 Users 对象列表
        List<Users> users = usersMapper.selectByExample(example);
        if (users.size() == 0) {
            return new ResultVO(500, "用户名不存在", null);
        } else {
            String pwd = MD5Utils.md5(password);
            if (pwd.equals(users.get(0).getPassword())) {
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();
                map.put("key1", "value1");
                map.put("key2", "value2");
                String token = builder.setSubject(name)                     //主题，就是token中携带的数据
                        .setIssuedAt(new Date())                            //设置token的生成时间
                        .setId(users.get(0).getUserId() + "")               //设置用户id为token  id
                        .setClaims(map)                                     //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) //设置token过期时间
                        .signWith(SignatureAlgorithm.HS256,"ly6666")     //设置加密方式和加密密码
                        .compact();
                return new ResultVO(200, token, users.get(0));
            }else{
                return new ResultVO(500,"密码错误", null);
            }
        }


    }
}
