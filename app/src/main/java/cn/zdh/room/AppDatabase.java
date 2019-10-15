package cn.zdh.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * 定义数据库
 *
 * 使用注解 @Database
 * entities对应的是 需要保存到数据库的 表类（注意每张表都需要添加进入，使用逗号分隔）
 * version 数据库的版本号
 *
 * 数据库需要继承RoomDatabase
 */
@Database(entities = {Student.class,Address.class,Person.class},version = 1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //定义个抽象方法获取表对象
    public abstract StudentDao userDao();

}
