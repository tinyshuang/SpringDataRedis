package hxk.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hxk.dao.UserDao;
import hxk.model.User;

/**
 * @author hxk spring配合redis做缓存的Demo..
 * 	使用spring的注解 :
 * 	`@CachePut,@Cacheable,@CacheEvict
 * 添加的调用链接 :	http://localhost:8080/SpringDataRedis/jsp/index.jsp
 * 获取时的链接     : http://localhost:8080/SpringDataRedis/getUser.do?name=tinys
 * 删除时的链接     : http://localhost:8080/SpringDataRedis/delUser.do?name=tinys	
 * 
 * @description
 *2015年12月9日  上午11:25:29
 */
@Controller
public class CacheAction {
    @Resource
    private UserDao userDao;
    
    
    @RequestMapping("/addUser")
    public @ResponseBody String addUser(User user,String name){
	userDao.add(user);
	return "add";
    }
    
    @RequestMapping("/getUser")
    public @ResponseBody String getUser(String name){
	User user = userDao.get(name);
	System.out.println(user);
	return "get";
    }
    
    @RequestMapping("/delUser")
    public @ResponseBody String delUser(String name){
	userDao.del(name);
	return "del";
    }
}
