package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigBadVoodooDaddy on 28.10.2017.
 */
public class User {

    /**
     * идентификационный (уникальный) номер пользователя в системе
     **/
    private String id;
    /**
     * имя пользователя
     **/
    private String name;
    /**
     * фамилия пользователя
     **/
    private String surname;
    /**
     * логин пользователя
     **/
    private String login;
    /**
     * пароль пользователя
     **/
    private String password;
    /**
     * позиция пользователя
     **/
    private String position;
    /**
     * список документов, которые добавил пользователь
     **/
    List<Document> documentList;

    /**
     * конструктор 1
     **/
    public User() {
    }

    /**
     * конструктор 2
     **/
    public User(String id, String name, String surname, String login, String password, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.position = position;
    }

    /**
     * блок инициализации списка документов, которые добавил пользователь
     **/ {
        documentList = new ArrayList<>();
    }


    /**
     * getters and setters для всех полей
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    /**
     * @return возвращает пользователя
     * читает поля пользователя и создает нового пользователя с этими полями
     **/
    public static User parseUser(String s) {
        String [] strings = s.split(";");
        return new User(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
    }
}

