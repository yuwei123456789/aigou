package cn.itsource.aigou.web.controller;

import cn.itsource.aigou.commom.AjaxResult;
import cn.itsource.plat.domain.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plat")
public class UserController {

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){
        //调用service和mapper：
        // 用前台的用户名和密码作为查询条件从数据库查询，如果有数据就是对的，否则就是错误的：
        if(user!=null&& !StringUtils.isEmpty(user.getName())&&!StringUtils.isEmpty(user.getPassword())){
          if("admin".equals(user.getName())&&"admin".equals(user.getPassword())){
              return AjaxResult.me().setMsg("登录成功");
          } else {
              return AjaxResult.me().setSuccess(false).setMsg("登录失败");
          }
        }
        return AjaxResult.me().setSuccess(false).setMsg("登录失败");
    }
}
