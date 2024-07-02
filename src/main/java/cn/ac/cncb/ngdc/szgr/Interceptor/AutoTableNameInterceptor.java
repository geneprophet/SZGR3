package cn.ac.cncb.ngdc.szgr.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.EmptyInterceptor;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//水平分表拦截器
@Slf4j
public class AutoTableNameInterceptor extends EmptyInterceptor {

    public static ThreadLocal<Map<String, String>> myTable = new ThreadLocal<>();

    @Override
    public String onPrepareStatement(String sql) {
//        Date nowTime = new Date();
//        System.out.println("进入拦截器"+nowTime);
        Map<String, String> map = myTable.get();
        if (map == null) {
            return sql;
        }
        String oldName = map.get("oldName");
        String newName = map.get("newName");
        if (oldName == null || oldName.trim().equals("") || newName == null || newName.trim().equals("")) {
            return sql;
        }
        sql = sql.replaceAll("into "+oldName , "into "+newName).replaceAll("from "+oldName , "from "+newName);
        return sql;
    }

    public static void setTable(String name, String toName) {
        Map<String, String> map = new HashMap<>();
        map.put("oldName", name);
        map.put("newName", toName);
        AutoTableNameInterceptor.myTable.set(map);
    }
}
