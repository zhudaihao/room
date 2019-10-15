package cn.zdh.room;

import android.database.Cursor;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Flowable;

/**
 * 这就是数据访问对象
 * 用于操作数据的API
 * <p>
 * 使用注解Dao
 * <p>
 * 写增删改查的类
 */

@Dao
public interface StudentDao {

    /**
     * 查所有数据
     *
     * @return
     */
    @Query("select * from Student")
    List<Student> getAll();

    /**
     * 插入数据
     */
    @Insert
    void insert(Student... students);

    /**
     * 根据名字查找记录
     * name要和findByName的参数名一致
     */
    @Query("select *from Student where name  like:name")
    Student findByName(String name);

    /**
     * 查询一组数据
     */
    @Query("select * from Student where uid in(:userIds)")
    List<Student> getAllId(int[] userIds);


    /**
     * 查询结果只有部分字段，用一个bean来接收-->StudentTuple
     */
    @Query("select name,password from student")
    List<StudentTuple> getRecord();


    /**
     * 返回liveData转载数据
     *
     * @return
     */
    @Query("select name,password from student")
    LiveData<List<StudentTuple>> getRecord2();


    /**
     * 返回数据支撑rxjava
     */
    @Query("select name,password from student")
    Flowable<List<StudentTuple>> getRecord3();

    /**
     * 支持游标
     */
    @Query("select name,password from student")
    Cursor getRecord4();


}
