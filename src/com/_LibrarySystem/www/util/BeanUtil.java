package com._LibrarySystem.www.util;

import com._LibrarySystem.www.bean.CommonStaff;
import com._LibrarySystem.www.bean.Curator;
import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.dao.CommonStaffDao;
import com._LibrarySystem.www.dao.CuratorDao;

import java.sql.SQLException;
import java.util.List;

public class BeanUtil {
    public static CommonStaff toCommonStaff(User user) throws SQLException,ClassNotFoundException {
        if (!CommonStaffDao.contain(user)) {
            throw new ClassNotFoundException("类型转换错误");
        } else {
            List<CommonStaff> commonStaffList = CommonStaffDao.queryAll();
            for (CommonStaff commonStaff : commonStaffList) {
                if (commonStaff.getId() == user.getId()) {
                    return commonStaff;
                }
            }
            return null;
        }
    }

    public static Curator toCurator(User user) throws SQLException,ClassNotFoundException{
        if (!CuratorDao.contain(user)){
            throw new ClassNotFoundException("类型转换错误");
        } else {
            List<Curator> curatorList = CuratorDao.queryAll();
            for (Curator curator : curatorList){
                if (curator.getId() == user.getId()){
                    return curator;
                }
            }
            return null;
        }
    }
}
