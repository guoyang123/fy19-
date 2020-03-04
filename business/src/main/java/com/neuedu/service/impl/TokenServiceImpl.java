package com.neuedu.service.impl;

import com.neuedu.common.Consts;
import com.neuedu.common.RedisApi;
import com.neuedu.common.ServerResponse;
import com.neuedu.common.StatusEnum;
import com.neuedu.service.ITokenService;
import org.aspectj.weaver.patterns.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class TokenServiceImpl implements ITokenService {

    @Autowired
    RedisApi redisApi;
    @Value("${token.timeout}")
    Integer tokenTimeout;
    @Override
    public ServerResponse generateToken() {

        //1.生成token
       String uuid= UUID.randomUUID().toString();
       StringBuffer buffer=new StringBuffer();
       buffer.append(Consts.TOKEN_PREFIX).append(uuid);


       //2.保存到redis
        redisApi.set(buffer.toString(),buffer.toString());

        if(buffer.toString()!=null&&!buffer.toString().equals("")){
            return  ServerResponse.serverResponseBySucess(null,buffer.toString());
        }

        return ServerResponse.serverResponseByFail(StatusEnum.TOKEN_GENERATE_FAIL.getStatus(),StatusEnum.TOKEN_GENERATE_FAIL.getDesc());
    }

    @Override
    public ServerResponse checkToken(HttpServletRequest request) {

        //step1:先从请求头中获取token
        String token=request.getHeader(Consts.TOKEN_NAME);
        if(token==null||token.equals("")){
            //step2:从参数中获取token
           token= request.getParameter(Consts.TOKEN_NAME);
        }

        if(token==null||token.equals("")){
            //没有携带token
            return ServerResponse.serverResponseByFail(StatusEnum.TOKEN_EMPTY.getStatus(),StatusEnum.TOKEN_EMPTY.getDesc());
        }

        //step3: 校验token是否存在
        String value=redisApi.get(token);
        if(value==null||value.equals("")){
            //token在服务端不存在，被消费了
            //重复提交
            return ServerResponse.serverResponseByFail(StatusEnum.NOT_REPEATABLE.getStatus(),StatusEnum.NOT_REPEATABLE.getDesc());
        }

        //step4: token有效，本次请求可以通过拦截器
        Long result=redisApi.remove(token);

        if(result==null){
            return ServerResponse.serverResponseByFail(StatusEnum.NOT_REPEATABLE.getStatus(),StatusEnum.NOT_REPEATABLE.getDesc());
        }

        return ServerResponse.serverResponseBySucess();
    }
}
