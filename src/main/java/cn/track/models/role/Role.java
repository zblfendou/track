package cn.track.models.role;

import cn.track.models.base.BaseModel;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2016.6.23.
 */
@Entity
public class Role extends BaseModel{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
