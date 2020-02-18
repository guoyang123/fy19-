package com.neuedu.service.impl;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.common.Consts;
import com.neuedu.common.ServerResponse;
import com.neuedu.common.StatusEnum;
import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import com.neuedu.service.ICategoryService;
import com.neuedu.service.IProductService;
import com.neuedu.utils.DateUtils;
import com.neuedu.vo.ProductDetailVO;
import com.neuedu.vo.ProductListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ICategoryService categoryService;


    @Autowired
    ProductMapper productMapper;

    @Override
    public ServerResponse addorUpdate(Product product) {

        if(product==null){
            return ServerResponse.serverResponseByFail(StatusEnum.PARAM_NOT_EMPTY.getStatus(),StatusEnum.PARAM_NOT_EMPTY.getDesc());
        }


        Integer productId=product.getId();

        String subImages=product.getSubImages();// 1.png,2.png,3.png
        if(subImages!=null&&subImages.length()>0){
         String mainImage=subImages.split(",")[0];
         product.setMainImage(mainImage);
        }


        if(productId==null){//添加商品

         int insertCount=   productMapper.insert(product);
         if(insertCount<=0){
             return ServerResponse.serverResponseByFail(StatusEnum.PRODUCT_ADD_FAIL.getStatus(),StatusEnum.PRODUCT_ADD_FAIL.getDesc());
         }else{
             return  ServerResponse.serverResponseBySucess("商品添加成功",null);
         }

        }else{//商品更新

            //step1:查询商品
           Product product1= productMapper.selectByPrimaryKey(product.getId());
            if(product1==null){
                //更新的商品不存在
                return ServerResponse.serverResponseByFail(StatusEnum.UPDATE_PRODUCT_NOT_EXISTS.getStatus(),StatusEnum.UPDATE_PRODUCT_NOT_EXISTS.getDesc());
            }

            //step2:更新商品

           int updateCount= productMapper.updteProductByActivate(product);
            if(updateCount<=0){
                return ServerResponse.serverResponseByFail(StatusEnum.PRODUCT_UPDATE_FAIL.getStatus(),StatusEnum.PRODUCT_UPDATE_FAIL.getDesc());
            }else{
                return  ServerResponse.serverResponseBySucess("商品更新成功",null);
            }


        }

    }

    /**
     *
     * 前台-商品检索
     * */

    @Override
    public ServerResponse list(Integer categoryId, String keyword, Integer pageNum, Integer pageSize, String orderBy) {



        //step1:判断是否传递了categoryId和keyword
        if(categoryId==-1&& (keyword==null||keyword.equals(""))){
            //前端没有传递categoryId和Keyword,往前端返回空的数据

            //PageHelper

            PageHelper.startPage(pageNum,pageSize);
            List<Product> productList=new ArrayList<>();
            PageInfo pageInfo=new PageInfo(productList);

            return ServerResponse.serverResponseBySucess(null,pageInfo);


        }

        //step2:判断CategoryId是否传递
        List<Integer> categoryList=new ArrayList<>();

        if(categoryId!=-1){//传递categoryId

            //查询categoryId下的所有子类
            ServerResponse<Set<Integer>> response=categoryService.get_deep_category(categoryId);

            if(response.isSucess()){
                Set<Integer> categoryIds=response.getData();

               Iterator<Integer> iterator= categoryIds.iterator();
               while(iterator.hasNext()){
                   categoryList.add(iterator.next());
               }

            }
        }

        //step3:判断keyword是否为空

        if(keyword!=null && !keyword.equals("")){
            keyword="%"+keyword+"%";
        }


        //step4:执行查询


        //一定写在查询前面
        PageHelper.startPage(pageNum,pageSize);

        // fieldname_desc
        if(orderBy!=null&&!orderBy.equals("")){//传递排序参数
            String[] orders=orderBy.split("_");
            PageHelper.orderBy(orders[0]+" "+orders[1]);

        }

        //

       List<Product> productList=productMapper.findProducsByCategoryIdsAndkeyword(categoryList,keyword);

       List<ProductListVO> productListVOList=new ArrayList<>();
       for(Product product:productList){
           ProductListVO productListVO=new ProductListVO();
           productListVO.setId(product.getId());
           productListVO.setCategoryId(product.getCategoryId());
           productListVO.setMainImage(product.getMainImage());
           productListVO.setName(product.getName());
           productListVO.setPrice(product.getPrice());
           productListVO.setStatus(product.getStatus());
           productListVO.setSubtitle(product.getSubtitle());
           productListVOList.add(productListVO);
       }



       //构建分页模型
       PageInfo pageInfo=new PageInfo(productListVOList);



        //step5:返回结果

        return ServerResponse.serverResponseBySucess("",pageInfo);
    }

    @Override
    public ServerResponse detail(Integer productId) {

      if(productId==null){
          return ServerResponse.serverResponseByFail(StatusEnum.PARAM_NOT_EMPTY.getStatus(),StatusEnum.PARAM_NOT_EMPTY.getDesc());
      }

    Product product=  productMapper.selectByPrimaryKey(productId);

      if(product.getStatus()!=Consts.ProductStatusEnum.PRODUCT_ONLINE.getStatus()){
          //商品已经下架或者被删除了
          return ServerResponse.serverResponseByFail(StatusEnum.PRODUCT_OFFLINEORDELETE_FAIL.getStatus(),StatusEnum.PRODUCT_OFFLINEORDELETE_FAIL.getDesc());

      }




        ProductDetailVO productDetailVO=product2vo(product);

        return ServerResponse.serverResponseBySucess(null,productDetailVO);
    }


    private ProductDetailVO product2vo(Product product){
        ProductDetailVO vo=new ProductDetailVO();

        vo.setCategoryId(product.getCategoryId());
        vo.setCreateTime(DateUtils.date2Str(product.getCreateTime()));
        vo.setDetail(product.getDetail());
        vo.setId(product.getId());
        vo.setMainImage(product.getMainImage());
        vo.setName(product.getName());
        vo.setPrice(product.getPrice());
        vo.setStatus(product.getStatus());
        vo.setSubImages(product.getSubImages());
        vo.setSubtitle(product.getSubtitle());
        vo.setUpdateTime(DateUtils.date2Str(product.getUpdateTime()));

        return vo;

    }

}
