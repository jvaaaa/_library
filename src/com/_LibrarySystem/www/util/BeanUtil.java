package com._LibrarySystem.www.util;

import com._LibrarySystem.www.bean.*;
import com._LibrarySystem.www.dao.CategoryStaffDao;
import com._LibrarySystem.www.dao.CommonStaffDao;
import com._LibrarySystem.www.dao.CuratorDao;

import java.sql.SQLException;
import java.util.List;

public class BeanUtil {
    public static CommonStaff toCommonStaff(User user) throws SQLException{
        List<CommonStaff> commonStaffList = CommonStaffDao.queryAll();
        for (CommonStaff commonStaff : commonStaffList) {
            if (commonStaff.getId() == user.getId()) {
                return commonStaff;
            }
        }
        return new CommonStaff();
    }

    public static Curator toCurator(User user) throws SQLException{
        List<Curator> curatorList = CuratorDao.queryAll();
        for (Curator curator : curatorList) {
            if (curator.getId() == user.getId()) {
                return curator;
            }
        }
        return new Curator();
    }

    public static CategoryStaff toCategoryStaff(User user) throws SQLException{
        List<CategoryStaff> categoryStaffList = CategoryStaffDao.queryAll();
        for (CategoryStaff categoryStaff : categoryStaffList) {
            if (categoryStaff.getId() == user.getId()) {
                return categoryStaff;
            }
        }
        return new CategoryStaff();
    }
}
