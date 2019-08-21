package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.model.po.Nation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NationService {


    Nation getNationById(String nationId);

    //查询所有的nation

    List<Nation> listNations();
}
