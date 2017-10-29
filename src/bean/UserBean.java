package bean;

import dao.UserDAO;
import model.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;

/**
 * Created by BigBadVoodooDaddy on 28.10.2017.
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    UserDAO userDAO;
    /**
     * пользователь из списка (существующий)
     */
    User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * пользователь до аутентификации
     */
    User tmpUser = new User();

    public User getTmpUser() {
        return tmpUser;
    }

    public void setTmpUser(User tmpUser) {
        this.tmpUser = tmpUser;
    }

    /**
     * @return String - имя страницы для перехода
     * 1) проверяет наличие пользователя в файле пользователей по id
     * 2)
     */
    public String checkOfTheUser() {
        User theUser = userDAO.findTheUser(user.getLogin());
        if (theUser == null || !theUser.getPassword().equals(user.getPassword()) || !theUser.getLogin().equals(user.getLogin())){
//            System.out.println(theUser); // проверка правильности работы
            return "error";
        }
        else {
            user = theUser;
        }
        return "database";
    }

}
