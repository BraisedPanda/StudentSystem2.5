package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Nation;
import com.braisedpanda.shirotest.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NationServiceImpl implements NationService{

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
