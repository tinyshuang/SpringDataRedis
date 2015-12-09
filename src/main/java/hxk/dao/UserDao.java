package hxk.dao;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import hxk.model.User;

/**
 * @author hxk
 * @description
 *2015年12月8日  下午4:38:13
 */
@Repository
public class UserDao {
    @Resource
    private RedisTemplate<String, Object> template;
    
    
    @CachePut(value="user",key="#user.name")
    public User add(User user){
	System.out.println("add the user");
	return user;
    }
    
    @Cacheable(value="user",key="#name")
    public User get(String name){
	System.out.println("get the user");
	User user = User.createUser();
	return user;
    }
    
    @CacheEvict(value="user",key="#name")
    public void del(String name){
	System.out.println("del the user");
    }
    
}
