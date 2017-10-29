package dao;

import model.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by BigBadVoodooDaddy on 28.10.2017.
 */
@Singleton
public class UserDAO {

    /**
     * путь по которому находится файл со списком пользователей
     */
    public final static String DIR = "E:\\Documents2\\Programming\\Berkunskiy-programming\\Projects\\Trainning\\courseProject(0)";

    /**
     * список пользователей приложением
     */
    public List<User> userList = new ArrayList<>();

    /**
     * @return строку - имя файла с данными пользователей
     */
    public String fileName() {return "users.csv";}

    /**
     * @return пользователя, которого прочитал
     */
    public User parse(String string) {return User.parseUser(string);}

    /**
     * данный метод срабатывает при запуске страницы
     * 1) читает информацию о всех пользователях
     * 2) помещает всю информацию в список, который был инициализирован ранее
     */
    @PostConstruct
    public void init() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(DIR, fileName()))){
            userList = reader.lines().skip(1).map(this::parse).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @User
     * возвращает пользователя, если таковой есть в списке
     */
    public User findTheUser(String login) {
        List<User> users = userList;
        return users.stream().filter(e -> e.getLogin().equals(login)).findFirst().orElse(null);
    }
}
