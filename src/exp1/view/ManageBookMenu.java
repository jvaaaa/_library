package exp1.view;

import exp1.bean.Book;
import exp1.dao.BookDao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageBookMenu {
    private static final Scanner scanner = new Scanner(System.in);

    private void bookAdd(){
        try {
            Book book = new Book();
            System.out.println("请输入以下信息:");
            System.out.print("id(id需要大于0):");
            int id = scanner.nextInt();
            book.setId(id);
            if (id <= 0){
                throw new InputMismatchException();
            }
            scanner.nextLine();
            System.out.print("ISBN:");
            book.setISBN(scanner.nextLine());
            System.out.print("name:");
            book.setName(scanner.nextLine());
            System.out.print("category:");
            book.setCategory(scanner.nextLine());
            System.out.print("number:");
            int number = scanner.nextInt();
            if (number < 0){
                throw new InputMismatchException();
            }
            scanner.nextLine();
            book.setNumber(number);
            System.out.print("price:");
            double price = scanner.nextDouble();
            if (price < 0){
                throw new InputMismatchException();
            }
            scanner.nextLine();
            book.setPrice(price);
            System.out.print("author:");
            book.setAuthor(scanner.nextLine());
            if (BookDao.add(book)){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入,已返回上一步");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void bookDelete(){
        Book book = new Book();
        try {
            System.out.print("请输入你要删除的书籍ID(输入0返回上一步):");
            int id = scanner.nextInt();
            book.setId(id);
            if (id < 0){
                throw new InputMismatchException();
            } else if (id == 0){
                throw new RuntimeException();
            }else {
                scanner.nextLine();
                if(BookDao.delete(book)){
                    System.out.println("删除成功");
                }else {
                    System.out.println("删除失败");
                }
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("非法输入,已返回上一步");
        } catch (RuntimeException e){
            scanner.nextLine();
            System.out.println("已返回上一步");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void bookModify(){
        try {
            Book book = new Book();
            System.out.print("请输入你要修改的书籍ID(输入0返回上一步):");
            int id = scanner.nextInt();
            book.setId(id);
            if (id == 0) {
                throw new RuntimeException();
            } else if (id < 0){
               throw new InputMismatchException();
            } else{
                scanner.nextLine();
                System.out.println("可修改的内容为:");
                System.out.println("1.id");
                System.out.println("2.ISBN");
                System.out.println("3.name");
                System.out.println("4.category");
                System.out.println("5.number");
                System.out.println("6.price");
                System.out.println("7.author");
                System.out.print("请输入你要修改的内容(输入命令前的编号):");
                int select = scanner.nextInt();
                scanner.nextLine();
                System.out.print("修改为:");
                String modify = scanner.nextLine();
                boolean success = false;
                switch (select){
                    case 1:
                        success=BookDao.modify(book,"id",modify);
                        break;
                    case 2:
                        success=BookDao.modify(book,"ISBN",modify);
                        break;
                    case 3:
                        success=BookDao.modify(book,"name",modify);
                        break;
                    case 4:
                        success=BookDao.modify(book,"category",modify);
                        break;
                    case 5:
                        success=BookDao.modify(book,"number",modify);
                        break;
                    case 6:
                        success=BookDao.modify(book,"price",modify);
                        break;
                    case 7:
                        success=BookDao.modify(book,"author",modify);
                        break;
                    default:
                        System.out.println("非法输入,已返回上一步");
                }
                if (!success){
                    System.out.println("修改失败");
                }else {
                    System.out.println("修改成功");
                }

            }
        }catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("非法输入,已返回上一步");
        }catch (RuntimeException e){
            scanner.nextLine();
            System.out.println("已返回上一步");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ManageBookMenu(){
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.增加图书信息");
            System.out.println("2.删除图书信息");
            System.out.println("3.修改图书信息");
            System.out.println("4.返回上一级");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();//消化回车
                switch (select){
                    case 1:
                        bookAdd();
                        break;
                    case 2:
                        bookDelete();
                        break;
                    case 3:
                        bookModify();
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
            }
        }
    }
}
