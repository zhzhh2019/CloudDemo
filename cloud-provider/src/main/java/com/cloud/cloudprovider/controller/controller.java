package com.cloud.cloudprovider.controller;


import com.cloud.cloudprovider.client.LabelClient;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController//@RestController 不走视图解析器 ，会返回 字符串 如果用的是@Controller 会走视图解析器 ，如果不走，可以在方法上加上 注解@ResponseBody
@Api(tags="对请求类的说明 如：Controller类接口测试 ",value="该参数没什么意义，所以不需要配置")
public class controller {

    @ApiOperation(value = "方法的说明")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        return "Hello SMS !";
    }
    /**
     * @ApiImplicitParams：用在请求的方法上，包含一组参数说明
     *        @ApiImplicitParam：对单个参数的说明
     *          name：参数名
     * 	        value：参数的说明、描述
     * 	        required：参数是否必须必填
     * 	        paramType：参数放在哪个地方
     * 	        · query --> 请求参数的获取：@RequestParam
     * 	        · header --> 请求参数的获取：@RequestHeader
     * 	        · path（用于restful接口）--> 请求参数的获取：@PathVariable
     * 	        · body（请求体）-->  @RequestBody User user
     * 	        · form（普通表单提交）
     * 	    dataType：参数类型，默认String，其它值dataType="Integer"
     * 	    defaultValue：参数的默认值
     *
     * */


    @ApiOperation(value="用户登录",notes="随边说点啥")
    @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
            @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
    })
    @PostMapping("/login")
    public String login(@RequestParam String mobile, @RequestParam String password,
                        @RequestParam Integer age){
        return "login";
    }
    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name="userId", dataType="String", required=true, value="用户Id")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam String userId) {
        return "user";
    }



    @Autowired
    private LabelClient labelClient;

    @RequestMapping("/test1")
    public String findAll(){
        System.err.println("访问到了 "+labelClient.findAll());
        return labelClient.findAll();
    }











}
