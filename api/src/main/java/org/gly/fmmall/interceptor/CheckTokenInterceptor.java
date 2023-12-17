package org.gly.fmmall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.UnsupportedJwtException;
import org.gly.fmmall.vo.ResStatus;
import org.gly.fmmall.vo.ResultVO;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CheckTokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (token == null) {
            ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录", null);
            doResponse(response,resultVO);
        } else {
            try {
                Jwt parse = Jwts.parser().setSigningKey("ly6666").parse(token);
                System.out.println(parse);
                return true;
            } catch (ExpiredJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_OVERDUE, "登录过期，请重新登录！", null);
                doResponse(response, resultVO);
            } catch (UnsupportedJwtException e) {
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "Token不合法，请自重！", null);
                doResponse(response, resultVO);
            } catch (Exception e) {
                ResultVO resultVO = new ResultVO(ResStatus.LOGIN_FAIL_NOT, "请先登录！", null);
                doResponse(response, resultVO);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        //  获取响应输出流
        PrintWriter writer = response.getWriter();
        //  将结果Vo转换为json字符串
        String s = new ObjectMapper().writeValueAsString(resultVO);
        //  将json字符串写入响应
        writer.print(s);
        //  刷新输出流
        writer.flush();
        //  关闭输出流
        writer.close();
    }
}
