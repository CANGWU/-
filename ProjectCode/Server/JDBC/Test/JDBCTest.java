package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import link.Helper;

public class JDBCTest {

static String sql = null;  
static Helper db1 = null;  
static ResultSet ret = null;  

public static void main(String[] args) {  
    sql = "SELECT * FROM staffpo;";//SQL���  
    db1 = new Helper();//����DBHelper����  

    try {  
        ret = Helper.run(sql);//ִ����䣬�õ������  
        while (ret.next()) {  
            String uid = ret.getString(1);  
            String ufname = ret.getString(2);  
            String ulname = ret.getString(3);  
            String udate = ret.getString(4);  
            System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
        }//��ʾ����  
        ret.close();  
        db1.close();//�ر�����  
    } catch (SQLException e) {  
        e.printStackTrace();  
    }  
}  
}