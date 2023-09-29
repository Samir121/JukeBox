package com.crio.jukebox.entities;


public class User extends BaseEntity{
    // private String userId;
    private final String name;
    private Integer userId;

    

    public User(String name) {
        this.name = name;
    }

    public User(Integer id, String name) {
        this(name);
        this.userId = id;
    }

    public User(User user){
        this(user.userId, user.name);
    }

    

    // public String getUserId(){
    //     return userId;
    // }

    public String getName(){
        return name;
    }

    public Integer getUserId(){
        return userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", userId=" + userId + "]";
    }
}
