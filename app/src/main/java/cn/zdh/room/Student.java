package cn.zdh.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * 注解entity 建表
 * <p>
 * 这就相当表的结构信息
 * <p>
 * 如果我使用Address表的addressId作为student表的外键 ；就需要在Entity中使用foreignKeys
 * foreignKeys = @ForeignKey(entity = Address.class, parentColumns = "tag", childColumns = "addressId")
 */

@Entity
public class Student {
    /**
     * 注意一张表必须有主键注解Primarykey 字段类型为int
     */
    @PrimaryKey(autoGenerate = true)
    public int uid;

    //列的信息 columnInfo
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "addressId")
    private int addressId;

    /**
     * 使用Ignore注解说明这个字段不是数据库字段
     */
    @Ignore
    private int i;

    /**
     * 注意字段必须有get set方法
     */

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Student(String name, String password, int addressId) {
        this.name = name;
        this.password = password;
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
