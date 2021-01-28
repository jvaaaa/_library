package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.CategoryStaff;
import com._LibrarySystem.www.bean.User;
import com._LibrarySystem.www.dao.CategoryStaffDao;

import java.sql.SQLException;
import java.util.List;

public class CategoryStaffAction {
    public static boolean contain(int id) throws SQLException {
        User user = new User();
        user.setId(id);
        return CategoryStaffDao.contain(user);
    }

    public static void query(int id) throws SQLException{
        if (id==0){
            List<CategoryStaff> categoryStaffList = CategoryStaffDao.queryAll();
            show(categoryStaffList);
        }else {
            CategoryStaff categoryStaff = CategoryStaffDao.query(id);
            show(categoryStaff);
        }
    }

    private static void show(CategoryStaff categoryStaff) {
        if (categoryStaff.getId()!=0){
            System.out.println("查询成功,信息如下:");
            System.out.printf("id:%d\tname:%s\tgender:%s\tcontact:%s\tcategoryID:%d\ttelephone:%s\n",categoryStaff.getId(),categoryStaff.getName(),categoryStaff.getGender(),categoryStaff.getContact(),categoryStaff.getCategoryID(),categoryStaff.getTelephone());
        }else {
            System.out.println("查询失败，无该书目管理员信息");
        }
    }

    private static void show(List<CategoryStaff> categoryStaffList) {
        System.out.println("查询成功,信息如下:");
        for (CategoryStaff categoryStaff : categoryStaffList){
            System.out.printf("id:%d\tname:%s\tgender:%s\tcontact:%s\tcategoryID:%d\ttelephone:%s\n",categoryStaff.getId(),categoryStaff.getName(),categoryStaff.getGender(),categoryStaff.getContact(),categoryStaff.getCategoryID(),categoryStaff.getTelephone());
        }
    }

    public static boolean add(int id, String name, String gender, String contact, int categoryID, String telephone) throws SQLException{
        CategoryStaff categoryStaff = new CategoryStaff();
        categoryStaff.setId(id);
        categoryStaff.setName(name);
        categoryStaff.setGender(gender);
        categoryStaff.setContact(contact);
        categoryStaff.setCategoryID(categoryID);
        categoryStaff.setTelephone(telephone);
        return CategoryStaffDao.add(categoryStaff);
    }

    public static boolean delete(int id) throws SQLException{
        CategoryStaff categoryStaff = new CategoryStaff();
        categoryStaff.setId(id);
        return CategoryStaffDao.delete(categoryStaff);
    }

    public static boolean modify(int id, String state, String statement) throws SQLException{
        CategoryStaff categoryStaff = new CategoryStaff();
        categoryStaff.setId(id);
        return CategoryStaffDao.modify(categoryStaff,state,statement);
    }

    public static boolean demote(int id) throws SQLException{
        CategoryStaff categoryStaff = CategoryStaffDao.query(id);
        String name = categoryStaff.getName();
        String gender = categoryStaff.getGender();
        String telephone = categoryStaff.getTelephone();
        return (CommonStaffAction.add(id,name,gender,telephone) && CategoryStaffDao.delete(categoryStaff));
    }
}
