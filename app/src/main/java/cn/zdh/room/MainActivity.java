package cn.zdh.room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注意网络操作，数据库操作需要在线程操作

        new Thread() {
            @Override
            public void run() {
                super.run();
                //操作数据库
                /**
                 * 调用系统API获取数据库
                 * 参数（上下文，数据库类，数控名称）
                 */
                AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "AaronDB").build();

                //获取dao接口类
                StudentDao studentDao = appDatabase.userDao();

                //创建数据
                Student student = new Student("张三", "1234", 100);
                Student student2 = new Student("李四", "0000", 8);
                Student student3 = new Student("王五", "888", 9);
                //调用接口 插入数据方法
                studentDao.insert(student);
                studentDao.insert(student2);
                studentDao.insert(student3);
                //调用接口 查询所有数据方法
                List<Student> all = studentDao.getAll();

                Log.e("zdh", "-------------查询所有" + all.toString());
                //通过name查询
                Student name = studentDao.findByName("王五");
                Log.e("zdh", "-------------name查询" + name.toString());
                //通过uid查询一组数据
                List<Student> allId = studentDao.getAllId(new int[]{2, 3});
                Log.e("zdh", "-------------查询一组数据" + allId.toString());

                //查询部分字段，保存到另外一个bean对象里面
                List<StudentTuple> record = studentDao.getRecord();

                Log.e("zdh", "-------------保存到另外一个bean对象里面" + record.toString());

                //更新数据库
                Migration migration1 = new Migration(1,2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        //执行SQ语句
                        database.execSQL("");
                    }
                };
                Migration migration2 = new Migration(2,3) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        //执行SQ语句
                        database.execSQL("");
                    }
                };
                Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"AaronBD" ).addMigrations(migration1,migration2).build();

            }
        }.start();



    }


}
