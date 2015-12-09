package hxk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hxk.model.User;

/**
 * @author hxk
 * @description
 *2015年12月4日  下午1:58:56
 */
@Controller
public class UserAction {
    @Resource
    private RedisTemplate<String, Object> template;
    
    
    @RequestMapping("/set")
    public @ResponseBody String set(){
	User user = User.createUser();
	template.opsForHash().put("User", "tinys", user);
	return "ok";
    }
    
    @RequestMapping("/get")
    public @ResponseBody String get(){
	User user = (User) template.opsForHash().get("User", "tinys");
	System.out.println(user);
	return "ok";
    }
    
    
    /**
     * @description 一个redis的事务操作
     * 照搬官方文档的..
     * 也可以在配置文件中的template类添加enableTransactionSupport属性来支持事务	 
     * @return
     *2015年12月9日  下午2:40:31
     *返回类型:String
     */
    @RequestMapping("/tx")
    public @ResponseBody String transactions(){
	template.execute(new SessionCallback<List<Object>>() {
	    @Override
	    public List<Object> execute(RedisOperations operations) throws DataAccessException {
		operations.multi();
		operations.opsForSet().add("key", "value1");
		
		// This will contain the results of all ops in the transaction
		return operations.exec();
	    }
	    
	});
	return "tx";
    }
    
    
}
