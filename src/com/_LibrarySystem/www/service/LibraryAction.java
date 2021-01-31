package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.Library;
import com._LibrarySystem.www.dao.LibraryDao;

import java.sql.SQLException;
import java.util.List;

public class LibraryAction {
    public static void query(int id) throws SQLException {
        if (id==0){
            List<Library> libraryList = LibraryDao.queryAll();
            show(libraryList);
        }else {
            Library library = LibraryDao.query(id);
            show(library);
        }
    }

    private static void show(Library library) {
        if (library.getId()!=0){
            System.out.println("查询成功,信息如下:");
            System.out.printf("id:%d\tname:%s\taddress:%s\tCuratorID:%d\n", library.getId(), library.getName(), library.getAddress(), library.getCuratorID());
        }else {
            System.out.println("查询失败，无该图书馆信息");
        }
    }

    private static void show(List<Library> libraryList) {
        System.out.println("查询成功,信息如下:");
        for (Library library : libraryList) {
            System.out.printf("id:%d\tname:%s\taddress:%s\tCuratorID:%d\n", library.getId(), library.getName(), library.getAddress(), library.getCuratorID());
        }
    }

    public static boolean contain(int id) throws SQLException{
        List<Library> libraryList = LibraryDao.queryAll();
        for (Library library : libraryList){
            if (library.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static boolean add(int id, String name, String address, int curatorID) throws SQLException{
        Library library = new Library();
        library.setId(id);
        library.setName(name);
        library.setAddress(address);
        library.setCuratorID(curatorID);
        return LibraryDao.add(library);
    }
}
