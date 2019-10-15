package cn.zdh.room;

import androidx.room.ColumnInfo;

/**
 * 假设我查Student表，只查询name password，那我们可以创建一个类来接受 这两个字段。
 * <p>
 * 注意这个类不用Entity注解，不需要添加到AppDatabase里面；也不需要主键
 */
public class StudentTuple {

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "password")
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StudentTuple(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "StudentTuple{" +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
