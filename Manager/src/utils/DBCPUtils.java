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
 * 数据库连接操作类
 * @author 老腰
 */
public class DBCPUtils {
	//获取资源对象
	private static DataSource ds = null;
	
	//加载配置信息，并且实现资源对象的重定义需要在静态代码块中执行，随着类的加载主动加载
	static {
		//创建配置文件对象
		Properties prop = new Properties();
		//通过类的字节码对象，调用类加载器，读取指定路径下的配置文件信息
		InputStream in = new DBCPUtils().getClass().getClassLoader().getResourceAsStream("db.properties");
		//将流读取信息，加载到配置文件对象中
		try {
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//通过资源对象获取连接对象
	public static  Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//释放资源 先释放结果集，在释放执行语句对象，最后关闭连接
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
	
	//释放资源 先释放结果集，在释放执行语句对象，最后关闭连接
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
