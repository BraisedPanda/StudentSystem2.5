package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Nation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NationService {

    @Cacheable(value="nation" , key="'getNationById:'+#nationId")
    Nation getNationById(String nationId);

    //查询所有的nation
    @Cacheable(value="nation" )
    List<Nation> getAllNation();
}
