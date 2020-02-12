package com.neuedu.dao;

import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    List<User> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(User record);


    /**
     * 判断用户名是否存在
     * @param(str) :str代表sql语句占位符所对应的名称
     * */

    int countUsername(@Param("uname") String username);
    /**
     * 判断邮箱是否存在
     * @param(str) :str代表sql语句占位符所对应的名称
     * */

    int countEmail(@Param("email") String email);


    /**
     *
     * 根据用户名和密码查询用户信息
     * */

    User findUserByUsernameAndpassword(@Param("username") String username,
                                       @Param("password") String password);



}