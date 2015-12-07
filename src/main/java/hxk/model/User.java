package hxk.model;

import java.io.Serializable;

/**
 * @author hxk
 * @description
 *2015年12月4日  下午1:57:46
 */
public class User implements Serializable{
    private static final long serialVersionUID = -1603486732294831282L;
    
    
    private String name;
    private int age;
    private String sex;
    
    
    
    @Override
    public String toString() {
	return "User [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }
    
    public static User createUser(){
	User user = new User();
	user.setAge(25);
	user.setName("tinys");
	user.setSex("男");
	return user;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
}
