package com.alibaba.dubbo.test.service.chain.impl;

import com.alibaba.dubbo.test.service.chain.CatService;
import com.alibaba.dubbo.test.service.chain.DogService;
import com.alibaba.dubbo.test.service.chain.MouseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ken.lj on 2017/9/8.
 */
@Service("dogService")
public class DogServiceImpl implements DogService {
    @Autowired
    private CatService catService;

    @Autowired
    private MouseService mouseService;

    @Override
    public void eat(String master) {
        System.out.println(master + " eat me.");
        catService.eat("cat");
        mouseService.eat("mouse");
    }

    @Override
    public String getName() {
        return "Hachiko Dog";
    }
}