package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.bean.po.Nation;
import com.braisedpanda.shirotest.mapper.NationMapper;
import com.braisedpanda.shirotest.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {

    @Autowired
    NationMapper nationMapper;

    @Override
    public Nation getNationById(String nationId) {
        Nation nation = nationMapper.getNationById(nationId);
        return nation;
    }
    //查询所有的nation
    @Override
    public List<Nation> listNations() {
           List<Nation> nationList = nationMapper.listNations();
           return nationList;
    }
}
