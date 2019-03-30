package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbutils.DbUtils;

import Bean.User;
import utils.DBCPUtils;

public class UserDao {
	private static  Connection conn = null;
	private static  PreparedStatement prep = null;
	private static  ResultSet rs = null;
	
    //��ѯ�����е��û�
	public static  ArrayList<User> search() {
		conn = DBCPUtils.getConnection();
		String sql = "select * from User";
		try {
			//���ִ��sql����Ԥ�������
			prep = conn.prepareStatement(sql);
			//��ȡ���������
			rs = prep.executeQuery();
			//�жϽ�������ҽ����������ArrayList��
			ArrayList<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setDate(rs.getString("date"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.release(rs,prep,conn);
		}	
		return null;
	}
	
	//�����û�id�Ų�ѯ�û�
	public static boolean searchById(String id) {
		conn = DBCPUtils.getConnection();
		String sql = "select * from User where id=?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, id);
			rs = prep.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//�����û�id��������ѯ�û�
	public static User findByIdName(String id,String userName) {
		conn = DBCPUtils.getConnection();
		String sql = "select * from User where id=? and name=?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, id);
			prep.setString(2, userName);
			rs = prep.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setEmail(rs.getString("email"));
				user.setDate(rs.getString("date"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCPUtils.release(rs, prep, conn);
		}
		return null;
	
	}
	
	//����û�
	public static boolean insert(User user) {
		conn = DBCPUtils.getConnection();
		try {
			//�������
			String sql = "insert into user values(?,?,?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setString(1, user.getId());
			prep.setString(2, user.getName());
			prep.setInt(3, user.getAge());
			prep.setString(4, user.getSex());
			prep.setString(5, user.getEmail());
			prep.setString(6, user.getDate());
			
		    int num = prep.executeUpdate();
		    if(num>=1) {
		    	return true;
		    }
		    return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPUtils.release(rs, prep, conn);
		}
		return false;
	}
	
	//ɾ���û�(�����û���id������ɾ���û�)
	public static boolean delete(String id,String userName) {
		conn = DBCPUtils.getConnection();
		try {
			String sql = "delete from user where id='"+id+"' and name='"+userName+"'";
		    prep = conn.prepareStatement(sql);
		    int num = prep.executeUpdate();
		    if(num>=0) {
		    	return true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCPUtils.release(rs, prep,conn);
		}
		return false;
	}
	
	//�����û���id���޸��û�����Ϣ
	public static boolean update(User user) {
		conn = DBCPUtils.getConnection();
		String sql ="update user set name=?,age=?,sex=?,email=?,date=? where id=?";
		try {
			prep = conn.prepareStatement(sql);
			prep.setString(1, user.getName());
			prep.setInt(2, user.getAge());
			prep.setString(3, user.getSex());
			prep.setString(4, user.getEmail());
			prep.setString(5, user.getDate());
			prep.setString(6, user.getId());
			int num = prep.executeUpdate();
		    if(num>=1) {
		    	return true;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBCPUtils.release(rs, prep,conn);
		}
		return false;
	}
	
	
}
