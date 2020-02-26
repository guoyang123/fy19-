package com.neuedu.service;

import com.neuedu.common.ServerResponse;

public interface IpayService {

    ServerResponse pay(Long orderNo);

}
