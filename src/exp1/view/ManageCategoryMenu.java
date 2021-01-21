package exp1.view;

import exp1.bean.Category;
import exp1.dao.CategoryDao;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageCategoryMenu {
    private static final Scanner scanner = new Scanner(System.in);

    private static void categoryAdd(){
        try {
            Category category = new Category();
            System.out.println("请输入以下信息:");
            System.out.print("id(id需要大于0):");
            int id = scanner.nextInt();
            if (id <= 0){
                throw new InputMismatchException();
            }
            scanner.nextLine();
            category.setId(id);
            System.out.print("name:");
            String name = scanner.nextLine();
            category.setName(name);
            if (CategoryDao.add(category)){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("输入非法,已返回上一步");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void categoryDelete(){
        try {
            Category category = new Category();
            System.out.print("请输入需要删除的书籍类型id:");
            int id = scanner.nextInt();
            scanner.nextLine();
            category.setId(id);
            if (CategoryDao.delete(category)){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }catch (InputMismatchException e){
            scanner.nextLine();
            System.out.println("输入非法");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ManageCategoryMenu(){
        boolean close = false;
        while (!close) {
            System.out.println("你可以执行的操作有:");
            System.out.println("1.添加书籍类型");
            System.out.println("2.删除书籍类型");
            System.out.println("3.返回上一步");
            System.out.print("你要执行的命令为(输入命令前的编号):");
            try {
                int select = scanner.nextInt();
                scanner.nextLine();
                switch (select) {
                    case 1:
                        categoryAdd();
                        break;
                    case 2:
                        categoryDelete();
                        break;
                    case 3:
                        close = true;
                        break;
                    default:
                        System.out.println("输入非法");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("输入非法");
            }
        }
    }
}
