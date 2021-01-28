package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.Category;
import com._LibrarySystem.www.dao.CategoryDao;

import java.sql.SQLException;
import java.util.List;

public class CategoryAction {

    public static boolean contain(int id) throws SQLException {
        List<Category> categoryList = CategoryDao.queryAll();
        for (Category category : categoryList){
            if (category.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static boolean add(int id, String name) throws SQLException{
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return CategoryDao.add(category);
    }

    public static boolean delete(int id) throws SQLException{
        Category category = new Category();
        category.setId(id);
        return CategoryDao.delete(category);
    }

    public static Category query(int categoryID) throws SQLException{
        List<Category> categoryList = CategoryDao.queryAll();
        for (Category category : categoryList){
            if (category.getId() == categoryID){
                return category;
            }
        }
        return new Category();
    }
}
