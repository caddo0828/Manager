package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.Manager;
import utils.DBCPUtils;

/**
 * 用户信息匹配操作类
 * @author 老腰
 */
public class ManagerDao {
	//查找用户的数据，以集合的形式存储 
	//主要用于显示所有用户时使用
	public static  ArrayList<Manager> search() {
		//创建连接对象，执行语句对象，结果集对象
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//通过调用DBCPUtils重定义连接对象
		conn = DBCPUtils.getConnection();
		try {
			stmt = conn.createStatement();
			//定义执行语句
			String sql = "select * from manager";
			//通过执行语句，得到结果集对象
			rs = stmt.executeQuery(sql);
			
			ArrayList<Manager> list = new ArrayList<Manager>();
			//遍历结果集
			while(rs.next()) {
				Manager mana = new Manager();
				mana.setId(rs.getString("id"));
				mana.setUserName(rs.getString("username"));
				mana.setPassword(rs.getString("password"));
				mana.setSex(rs.getString("sex"));
				mana.setCity(rs.getString("city"));
				list.add(mana);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.release(rs, stmt,conn);
		}
		 return null;
	}
	
	//根据指定的姓名，密码查询是否存在
	//主要用于登录判断
	public static Manager findByValue(String username,String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBCPUtils.getConnection();
		    stmt = conn.createStatement();
		    String sql = "select * from manager where username='"+username+"' and password='"+password+"' ";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	Manager mana = new Manager();
            	mana.setUserName(rs.getString("username"));
            	mana.setPassword(rs.getString("password"));
            	return mana;
            }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt,conn);
		}
		
		return null;
	}
	
	//进行注册插入
	public static boolean insert(Manager mana) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into manager(id,username,password,sex,city) values('"+mana.getId()+"','"+mana.getUserName()+"' , '"+mana.getPassword()+"', '"+mana.getSex()+"', '"+mana.getCity()+"')";
			int num = stmt.executeUpdate(sql);
			if(num>=1) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt,conn);	
		}
		return false;
	}
	
	//判断根据指定的id是否存在用户
	//主要用于注册判断用户是否已经存在
	public static Manager findById(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBCPUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from manager where id="+id;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Manager mana = new Manager();
				mana.setId(rs.getString("id"));
				mana.setUserName(rs.getString("username"));
				mana.setPassword(rs.getString("password"));
				mana.setSex(rs.getString("sex"));
				mana.setCity(rs.getString("city"));
				return mana;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, stmt,conn);
		}
		return null;
	}
	
	
}
