package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.Nation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface NationService {


    //根据nation_id查找nation
    Nation getNationByPrimaryKey(Nation nation);

    
    //查找所有的nation
    List<Nation> listNation();
}
