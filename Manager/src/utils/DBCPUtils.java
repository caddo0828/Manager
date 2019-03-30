package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * ���ݿ����Ӳ�����
 * @author ����
 */
public class DBCPUtils {
	//��ȡ��Դ����
	private static DataSource ds = null;
	
	//����������Ϣ������ʵ����Դ������ض�����Ҫ�ھ�̬�������ִ�У�������ļ�����������
	static {
		//���������ļ�����
		Properties prop = new Properties();
		//ͨ������ֽ�����󣬵��������������ȡָ��·���µ������ļ���Ϣ
		InputStream in = new DBCPUtils().getClass().getClassLoader().getResourceAsStream("db.properties");
		//������ȡ��Ϣ�����ص������ļ�������
		try {
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ͨ����Դ�����ȡ���Ӷ���
	public static  Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//�ͷ���Դ ���ͷŽ���������ͷ�ִ�����������ر�����
	public static void release(ResultSet rs , PreparedStatement prep , Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(prep != null) {
			try {
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//�ͷ���Դ ���ͷŽ���������ͷ�ִ�����������ر�����
		public static void release(ResultSet rs , Statement stmt , Connection conn) {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


}
