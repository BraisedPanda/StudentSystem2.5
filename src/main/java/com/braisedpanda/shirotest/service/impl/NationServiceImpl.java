package com.braisedpanda.shirotest.service.impl;

import com.braisedpanda.shirotest.model.po.Nation;
import com.braisedpanda.shirotest.mapper.NationMapper;
import com.braisedpanda.shirotest.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {

    @Autowired
    NationMapper nationMapper;

    /**
    * @Description: 根据nation_id查找nation
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public Nation selectNationByPrimaryKey(Nation nation) {
        Nation nation2 = nationMapper.selectByPrimaryKey(nation);

        return nation2;
    }

    /**
    * @Description: 查询所有的nation
    * @Param:
    * @return:
    * @Date: 2019/8/22 0022
    */
    @Override
    public List<Nation> selectAllNation() {
        List<Nation> nationList = nationMapper.selectAll();

           return nationList;
    }
}
