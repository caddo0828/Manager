package Bean;

import java.util.Date;

/**
 * 用户信息类
 * @author 老腰
 *
 */
public class User {
	 private String id;
     private String name ;
     private int age;
     private String sex;
     private String email;
     private String date;
     
	 public User() {}

	 public User(String id, String name, int age, String sex, String email, String date) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.email = email;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	
	 
	 
     
     
}
