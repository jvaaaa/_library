package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.Curator;
import com._LibrarySystem.www.dao.CuratorDao;

import java.sql.SQLException;
import java.util.List;

public class CuratorAction {
    public static boolean contain(int id) throws SQLException {
        List<Curator> curatorList = CuratorDao.queryAll();
        for (Curator curator : curatorList){
            if (curator.getId() == id){
                return true;
            }
        }
        return false;
    }
}
