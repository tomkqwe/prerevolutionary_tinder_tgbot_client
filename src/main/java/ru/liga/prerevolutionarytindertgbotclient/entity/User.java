package ru.liga.prerevolutionarytindertgbotclient.entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String name;
    //потом заменим на энамы, яхз как их в пост запросе передать
    private String sex;

    private Integer age;
    private String description;
    //сэты из видео, таблички он там делает в ручную
    private Set<User> whoChooseMe = new HashSet<>();
    private Set<User> whoDidIChoose = new HashSet<>();

    public Set<User> getWhoChooseMe() {
        return whoChooseMe;
    }

    public void setWhoChooseMe(Set<User> whoChooseMe) {
        this.whoChooseMe = whoChooseMe;
    }

    public Set<User> getWhoDidIChoose() {
        return whoDidIChoose;
    }

    public void setWhoDidIChoose(Set<User> whoDidIChoose) {
        this.whoDidIChoose = whoDidIChoose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", whoChooseMe=" + whoChooseMe +
                ", whoDidIChoose=" + whoDidIChoose +
                '}';
    }
}
