package cn.track.models.user;

import cn.track.models.base.BaseModel;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2016.6.23.
 */
@Entity
public class User extends BaseModel {
	private String name;
	private String pwd;

	public User (String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public User () {
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getPwd () {
		return pwd;
	}

	public void setPwd (String pwd) {
		this.pwd = pwd;
	}

}
