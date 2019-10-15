package cn.zdh.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Address {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "tag")
    public int tag;

    @ColumnInfo(name = "addressName")
    public String name;

    public int getId() {
        return id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Address(int tag, String name) {
        this.tag = tag;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
