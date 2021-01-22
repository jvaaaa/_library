package exp1.view;

import exp1.bean.User;
import exp1.dao.CommonStaffDao;
import exp1.dao.CuratorDao;

import java.sql.SQLException;


/**
 * 主菜单（选择进入其他类型用户的其他菜单)
 */
public class Menu {
    public Menu(User user){
        try {
            if (CommonStaffDao.contain(user)){
                new CommonStaffMenu();
            }else if (CuratorDao.contain(user)){
                new CuratorMenu();
            }
            //需要新用户在这里添加
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
