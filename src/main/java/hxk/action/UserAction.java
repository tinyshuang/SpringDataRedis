package hxk.action;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
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
}
