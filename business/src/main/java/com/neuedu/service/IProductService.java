package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Product;
import org.springframework.web.bind.annotation.RequestParam;

public interface IProductService {

    ServerResponse addorUpdate(Product product);

    /**
     * 前台-商品检索
     */

    ServerResponse list(Integer categoryId, String keyword, Integer pageNum, Integer pageSize, String orderBy);


    /**
     * 前台-查看详情
     * */
    ServerResponse detail(Integer productId);
    /**
     * 商品扣库存
     * type: 0 ->减quantity库存
     *       1->加quantity库存
     * */
    ServerResponse updateStock(Integer productId,Integer quantity,int type);

}