package com._LibrarySystem.www.service;

import com._LibrarySystem.www.bean.Book;
import com._LibrarySystem.www.bean.Category;
import com._LibrarySystem.www.bean.CategoryStaff;
import com._LibrarySystem.www.dao.BookDao;

import java.sql.SQLException;
import java.util.List;

public class BookAction {

    public static void query(int id) throws SQLException {
        if (id==0){
            List<Book> bookList = BookDao.queryAll();
            show(bookList);
        }else {
            Book book = BookDao.query(id);
            show(book);
        }
    }

    private static void show(Book book){
        if (book.getId()!=0){
            System.out.println("查询成功,信息如下:");
            System.out.printf("id:%d\tISBN:%s\tname:%s\tcategory:%s\tnumber:%d\tprice:%.2f\tauthor:%s\n",book.getId(),book.getISBN(),book.getName(),book.getCategory(),book.getNumber(),book.getPrice(),book.getAuthor());
        }else {
            System.out.println("查询失败，无该书籍信息");
        }
    }

    private static void show(List<Book> bookList){
        System.out.println("查询成功,信息如下:");
        for (Book book : bookList){
            System.out.printf("id:%d\tISBN:%s\tname:%s\tcategory:%s\tnumber:%d\tprice:%.2f\tauthor:%s\n",book.getId(),book.getISBN(),book.getName(),book.getCategory(),book.getNumber(),book.getPrice(),book.getAuthor());
        }
    }

    public static boolean add(int id, String ISBN, String name, String category, int number, double price, String author) throws SQLException{
        Book book = new Book();
        book.setId(id);
        book.setISBN(ISBN);
        book.setName(name);
        book.setCategory(category);
        book.setNumber(number);
        book.setPrice(price);
        book.setAuthor(author);
        return BookDao.add(book);
    }

    public static boolean contain(int id) throws SQLException{
        List<Book> bookList = BookDao.queryAll();
        for (Book book : bookList){
            if (book.getId() ==  id){
                return true;
            }
        }
        return false;
    }

    public static boolean delete(int id) throws SQLException{
        if (contain(id)) {
            Book book = new Book();
            book.setId(id);
            return BookDao.delete(book);
        } else {
            return false;
        }
    }

    public static boolean modify(int id, String state, String statement) throws SQLException{
        Book book = new Book();
        book.setId(id);
        return BookDao.modify(book,state,statement);
    }

    public static boolean modify(int id, String state, int number) throws SQLException{
        Book book = new Book();
        book.setId(id);
        return BookDao.modify(book,state,number);
    }

    public static boolean modify(int id, String state, double price) throws SQLException{
        Book book = new Book();
        book.setId(id);
        return BookDao.modify(book,state,price);
    }

    public static boolean borrowable(int id) throws SQLException{
        Book book = BookDao.query(id);
        return book.getNumber()>0;
    }

    public static boolean borrow(int id) throws SQLException{
        Book book = new Book();
        book.setId(id);
        return BookDao.borrow(book);
    }

    public static boolean revert(int id) throws SQLException{
        Book book = new Book();
        book.setId(id);
        return BookDao.revert(book);
    }

    public static void query(CategoryStaff categoryStaff, int id) throws SQLException{
        Category category = CategoryAction.query(categoryStaff.getCategoryID());
        if (id == 0){
            List<Book> bookList = BookDao.queryAll(category);
            show(bookList);
        }else {
            Book book = BookDao.query(category,id);
            show(book);
        }
    }
}
