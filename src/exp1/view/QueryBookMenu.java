package exp1.view;

import exp1.bean.Book;
import exp1.dao.BookDao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QueryBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    private static void queryShow(List<Book> bookList){
        if (bookList.size() == 0){
            System.out.println("无信息");
        }else {
            System.out.println("查找到如下结果:");
            for (Book book : bookList) {
                System.out.printf("id:%d\tISBN:%s\tname:%s\tcategory:%s\tnumber:%d\tprice:%.2f\tauthor:%s\n",book.getId(),book.getISBN(),book.getName(),book.getCategory(),book.getNumber(),book.getPrice(),book.getAuthor());
            }
        }
    }

    private static void queryBookByName() throws SQLException {
        System.out.print("请输入书名:");
        String name = scanner.nextLine();
        List<Book> bookList = BookDao.query("select id,ISBN,name,category,number,price,author from library.book where name = ?",name);
        queryShow(bookList);
    }

    private static void queryBookByCategory() throws SQLException{
        System.out.print("请输入书籍类别:");
        String category = scanner.nextLine();
        List<Book> bookList = BookDao.query("select id,ISBN,name,category,number,price,author from library.book where category = ?",category);
        queryShow(bookList);
    }

    private static void queryBookByAuthor() throws SQLException{
        System.out.print("请输入作者:");
        String author = scanner.nextLine();
        List<Book> bookList = BookDao.query("select id,ISBN,name,category,number,price,author from library.book where author = ?",author);
        queryShow(bookList);
    }

    public QueryBookMenu() {
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.根据书名查询");
            System.out.println("2.根据书籍类别查询");
            System.out.println("3.根据作者查询");
            System.out.println("4.返回上一级");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select) {
                    case 1:
                        queryBookByName();
                        break;
                    case 2:
                        queryBookByCategory();
                        break;
                    case 3:
                        queryBookByAuthor();
                        break;
                    case 4:
                        close = true;
                        break;
                    default:
                        System.out.println("非法输入");
                }
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("非法输入");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
