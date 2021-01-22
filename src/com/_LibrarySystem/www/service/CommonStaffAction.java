package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.CommonStaff;
import com._LibrarySystem.www.dao.CommonStaffDao;

import java.sql.SQLException;
import java.util.List;

public class CommonStaffAction {
    public static void query(int id) throws SQLException {
        if (id==0){
            List<CommonStaff> commonStaffList = CommonStaffDao.queryAll();
            show(commonStaffList);
        }else {
            CommonStaff commonStaff = CommonStaffDao.query(id);
            show(commonStaff);
        }
    }

    private static void show(List<CommonStaff> commonStaffList) {
        System.out.println("查询成功,信息如下:");
        for (CommonStaff commonStaff : commonStaffList){
            System.out.printf("id:%d\tname:%s\tgender:%s\ttelephone:%s\n",commonStaff.getId(),commonStaff.getName(),commonStaff.getGender(),commonStaff.getTelephone());
        }
    }

    private static void show(CommonStaff commonStaff) {
        if (commonStaff.getId()!=0){
            System.out.println("查询成功,信息如下:");
            System.out.printf("id:%d\tname:%s\tgender:%s\ttelephone:%s\n",commonStaff.getId(),commonStaff.getName(),commonStaff.getGender(),commonStaff.getTelephone());
        }else {
            System.out.println("查询失败，无该书籍信息");
        }
    }

    public static boolean add(int id, String name, String gender, String telephone) throws SQLException{
        CommonStaff commonStaff = new CommonStaff();
        commonStaff.setId(id);
        commonStaff.setName(name);
        commonStaff.setGender(gender);
        commonStaff.setTelephone(telephone);
        return CommonStaffDao.add(commonStaff);
    }
}
