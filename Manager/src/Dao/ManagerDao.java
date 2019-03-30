package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.Manager;
import utils.DBCPUtils;

/**
 * �û���Ϣƥ�������
 * @author ����
 */
public class ManagerDao {
	//�����û������ݣ��Լ��ϵ���ʽ�洢 
	//��Ҫ������ʾ�����û�ʱʹ��
	public static  ArrayList<Manager> search() {
		//�������Ӷ���ִ�������󣬽��������
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		//ͨ������DBCPUtils�ض������Ӷ���
		conn = DBCPUtils.getConnection();
		try {
			stmt = conn.createStatement();
			//����ִ�����
			String sql = "select * from manager";
			//ͨ��ִ����䣬�õ����������
			rs = stmt.executeQuery(sql);
			
			ArrayList<Manager> list = new ArrayList<Manager>();
			//���������
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
	
	//����ָ���������������ѯ�Ƿ����
	//��Ҫ���ڵ�¼�ж�
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
	
	//����ע�����
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
	
	//�жϸ���ָ����id�Ƿ�����û�
	//��Ҫ����ע���ж��û��Ƿ��Ѿ�����
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
