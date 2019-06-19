package com.study.shiro.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/6/19
 * @version shiro v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void getUserByUsername() {
        System.out.printf(userDao.getUserByUsername("张三").toString());
    }
}