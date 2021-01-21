package exp1.view;

import exp1.bean.Book;
import exp1.dao.BookDao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RevertBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public RevertBookMenu(){
        try {
            Book book = new Book();
            System.out.print("请输入归还的书本id:");
            int id = scanner.nextInt();
            scanner.nextLine();
            book.setId(id);
            if(BookDao.revert(book)){
                System.out.println("归还成功");
            }else {
                System.out.println("归还失败");
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入,已返回上一步");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
