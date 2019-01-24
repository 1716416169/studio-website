package cn.cks.studiowebsite.controller;
import cn.cks.studiowebsite.dao.pojo.*;
import cn.cks.studiowebsite.service.LoginMapper;
import cn.cks.studiowebsite.service.GmMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.LinkedList;
import java.util.List;

@Controller
public class controller {

    @Autowired
    GmMapper gmMapper;

    @Autowired
    LoginMapper loginMapper;

    @Value("${web.imgpath}")
    String pathdemo;

    Mult mult= new Mult();

    /*
     *
     *官方主页
     *
     */

    @ApiIgnore
    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @ApiIgnore
    @GetMapping("/")
    public String hello(Model model) {
        Studio_introduce studio_introduce = gmMapper.selectStudio_introduce();
        model.addAttribute("introduce",studio_introduce.getText());
        return "index";
    }

    /*团队成员介绍*/
    @ApiIgnore
    @GetMapping("/team")
    public String team(Model model){
        LinkedList<People> select = gmMapper.select();
        model.addAttribute("people",select);
        return "team";
    }

       /*团队荣誉*/
    @ApiIgnore
    @GetMapping("/honor")
    public String honor(Model model){
        List<Img> imgs = gmMapper.selectImg();
        model.addAttribute("honor",imgs);
        return "honor";
    }

    /*工作室动态*/
    @ApiIgnore
    @GetMapping("/dynamic")
    public String dynamic(Model model){
        List<Img> imgs = gmMapper.selectDynamicImg();
        model.addAttribute("dynamic",imgs);
        return "dynamic";
    }

    /*研发方向*/
    @ApiIgnore
    @GetMapping("/development")
    public String development(Model model){
        Studio_updir studio_updir = gmMapper.selectStudio_updir();
        model.addAttribute("development",studio_updir.getText());
        return "development";
    }

    /*
     *
     *登陆界面
     *
     */
    @ApiIgnore
    @RequestMapping("/gm")
    public String gm() {
        return "login";
    }

    @ApiIgnore
    @PostMapping("/login")
    @Transactional
    public String login(String admin, String password, Model model) {
        System.out.println("登陆的管理员账户：" + admin);
        System.out.println("登陆的管理员密码：" + password);
        Gm gm = new Gm();
        gm.setAdmin(admin);
        gm.setPassword(password);
        Gm gm1 = loginMapper.select(gm);
        if (gm1 != null) {
            mult.mult(gmMapper,model);
            System.out.println("用户存在，验证成功");
            return "redirect:gm_people?admin=root";
        } else {
            return "redirect:login";
        }
    }













    /*废弃接口*/

    @ApiOperation(value = "返回工作室简介", notes = "返回值为String")
    @ApiImplicitParam(paramType = "query", name = "null", value = "null", required = false, dataType = "null")
    @PostMapping(value = "/selectindex",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectindex(){
        Studio_introduce studio_introduces = gmMapper.selectStudio_introduce();
        System.out.println("工作室简介的内容："+studio_introduces);
        return studio_introduces.getText();
    }

    @ApiOperation(value = "返回实习生招聘信息", notes = "返回值为String")
    @ApiImplicitParam(paramType = "query", name = "null", value = "null", required = false, dataType = "null")
    @PostMapping(value = "/selectstu",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String selectstu(){
        Studio_stu studio_stu = gmMapper.selectStudio_stu();
        System.out.println("实习生招聘的内容："+studio_stu);
        return studio_stu.getText();
    }

    @ApiOperation(value = "返回研发方向信息", notes = "返回值为String")
    @ApiImplicitParam(paramType = "query", name = "null", value = "null", required = false, dataType = "null")
    @PostMapping(value = "/selectupdir",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectupdir(){
        Studio_updir studio_updir=gmMapper.selectStudio_updir();
        System.out.println("研发方向修的内容："+studio_updir);
        return studio_updir.getText();
    }


    @ResponseBody
    @PostMapping(value = "/dynamic",produces = "application/json; charset=utf-8")
    @ApiOperation(value = "返回图片id+图片路径+图片介绍,这是工作室动态那页的，id不用管，你就处理图片和介绍，左边图片，右边介绍，类似团队荣誉那页，**图片路径格式为http://wjf.easy.echosite.cn/studio/imgpath_dynamic/图片路径", notes = "返回值为json对象")
    @ApiImplicitParam(paramType = "query", name = "null", value = "null", required = false, dataType = "null")
    public List<Img> dynamic(){
        List<Img> list = gmMapper.selectDynamicImg();
        return list;
    }

    @ResponseBody
    @PostMapping(value = "/Honor",produces = "application/json; charset=utf-8")
    @ApiOperation(value = "返回图片id+图片路径+图片介绍,这是比赛荣誉那页的，id不用管，你就处理图片和介绍，左边图片，右边介绍，类似团队荣誉那页，**图片路径格式为http://wjf.easy.echosite.cn/studio/imgpath_dynamic/图片路径", notes = "返回值为json对象")
    @ApiImplicitParam(paramType = "query", name = "null", value = "null", required = false, dataType = "null")
    public List<Img> Honor(){
        List<Img> list = gmMapper.selectImg();
        return list;
    }

    @ResponseBody
    @PostMapping(value = "/selectPeople",produces = "application/json; charset=utf-8")
    @ApiOperation(value = "返回人员介绍，是多个json对象", notes = "返回值为json对象")
    @ApiImplicitParam(paramType = "query", name = "null", value = "null", required = false, dataType = "null")
    public List<People> selectPeople(){
        LinkedList<People> select = gmMapper.select();
        return select;
    }
}

