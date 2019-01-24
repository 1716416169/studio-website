package cn.cks.studiowebsite.controller;

import cn.cks.studiowebsite.dao.pojo.*;
import cn.cks.studiowebsite.service.LoginMapper;
import cn.cks.studiowebsite.service.GmMapper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@ApiIgnore
public class gm_controller {
    @Autowired
    GmMapper gmMapper;

    @Autowired
    LoginMapper loginMapper;

    @Value("${web.imgpath_Honor}")
    String imgpath_Honor;

    @Value("${web.imgpath_dynamic}")
    String imgpath_dynamic;

    String re = "redirect:gm_people?admin=root";

    Mult mult = new Mult();
    /*
     *
     *管理界面
     *
     */

    /*添加人员信息*/
    @PostMapping("/commit")
    @Transactional
    public String commit(People people, Model model) {
        System.out.println("将要添加的人员信息：" + people);
        gmMapper.insertPeople(people);
        System.out.println("插入完成");
        mult.mult(gmMapper, model);
        return re;
    }

    /*权限拦截*/
    @GetMapping("/gm_people")
    public String gm_people(String admin, Model model) {
        if (!admin.equals("root")) {
            System.out.println("你是谁");
            return "login";
        } else {
            mult.mult(gmMapper, model);
            return "gm_people";
        }
    }

    /*删除人员信息*/
    @PostMapping("/commitdelete")
    public String commitdelete(Peoplevo peoplevo, Model model) {
        System.out.println("将要被删除人员的id：" + peoplevo.getChecks());
        if (peoplevo.getChecks() != null) {
            gmMapper.deleteByid(peoplevo.getChecks());
            System.out.println("删除成功");
            mult.mult(gmMapper, model);
            return re;
        } else {
            mult.mult(gmMapper, model);
            return re;
        }
    }

    /*测试*/
    /*上传比赛图片*/

    @Value("${spring.tengxun.accessKey}")
    private String accessKey;
    @Value("${spring.tengxun.secretKey}")
    private String secretKey;
    @Value("${spring.tengxun.bucket}")
    private String bucket;
    @Value("${spring.tengxun.bucketName}")
    private String bucketName;
    @Value("${spring.tengxun.path}")
    private String path;
    @Value("${spring.tengxun.qianzui}")
    private String qianzui;


    @RequestMapping(value = "/Uploadhonor", method = RequestMethod.POST)
    @ResponseBody
    public Object Uploadhonor(@RequestParam(value = "file") MultipartFile file) {
        if (file == null) {
            return "木有文件";
        }
        String oldFileName = file.getOriginalFilename();
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + eName;
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(bucket));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = this.bucketName;
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = null;
        try {
            localFile = File.createTempFile("temp", null);
            System.out.println(localFile);
            file.transferTo(localFile);
            // 指定要上传到 COS 上的路径
            String key = "/" + this.qianzui + "/" + newFileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            cosclient.putObject(putObjectRequest);
            String newpath = this.path + putObjectRequest.getKey();
            Img img = new Img();
            img.setPath(newpath);
            img.setK(key);
            gmMapper.insertImg(img);
            System.out.println("插入的图片：" + img);
            return img;
        } catch (IOException e) {
            return "出错了";
        } finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }

    /*修改人员信息*/
    @PostMapping("/updata")
    public String updata(People people, Model model) {
        System.out.println("将要更新的人员信息：" + people);
        gmMapper.updata(people);
        System.out.println("修改完成");
        mult.mult(gmMapper, model);
        return re;
    }

    /*上传图片介绍*/
    @PostMapping("/text")
    public String text(Model model, @RequestBody Img img) {
        System.out.println("更新的img对象：" + img);
        gmMapper.updateImg(img);
        mult.mult(gmMapper, model);
        return re;
    }

    /*删除图片*/
    @Transactional
    @PostMapping("/matchupdata")
    public String matchupdata(Imgvo imgvo, Model model, HttpServletRequest request) {
        try {
            System.out.println("选中删除的图片id：" + imgvo.getChecks());
            List<Img> imgs = gmMapper.selectImgsById(imgvo.getChecks());
            gmMapper.deleteimgById(imgvo.getChecks());
            System.out.println(imgs);
            for (Img img : imgs) {
                if (img == null) {
                    break;
                } else {
                    // 1 初始化用户身份信息(secretId, secretKey)
                    COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
                    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
                    ClientConfig clientConfig = new ClientConfig(new Region(bucket));
                    // 3 生成cos客户端
                    COSClient cosclient = new COSClient(cred, clientConfig);
                    cosclient.deleteObject(bucketName, img.getK());
                    System.out.println("删除图片路径：" + img.getPath());
                    cosclient.shutdown();
                }
            }
        } catch (Exception e) {
            return "";
        }

        mult.mult(gmMapper, model);
        return re;
    }

    /*上传工作室动态图片*/
    @RequestMapping(value = "/Uploaddynamic", method = RequestMethod.POST)
    @ResponseBody
    public Object Uploaddynamic(@RequestParam(value = "file") MultipartFile file) {
        if (file == null) {
            return "木有文件";
        }
        String oldFileName = file.getOriginalFilename();
        String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + eName;

        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(bucket));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String bucketName = this.bucketName;

        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = null;
        try {
            localFile = File.createTempFile("temp", null);
            System.out.println(localFile);
            file.transferTo(localFile);
            // 指定要上传到 COS 上的路径
            String key = "/" + this.qianzui + "/" + newFileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            cosclient.putObject(putObjectRequest);
            String newpath = this.path + putObjectRequest.getKey();
            Img img = new Img();
            img.setPath(newpath);
            img.setK(key);
            gmMapper.insertDynamicImg(img);
            System.out.println("插入的图片：" + img);
            return img;
        } catch (IOException e) {
            return "出错了";
        } finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
    }

    /*上传动态图片介绍*/
    @PostMapping("/text2")
    public String text2(Model model, @RequestBody Img img) {
        System.out.println("更新的img对象：" + img);
        gmMapper.updateDynamicImgImg(img);
        mult.mult(gmMapper, model);
        System.out.println(gmMapper.selectDynamicImg());
        return re;
    }

    /*删除动态图片*/
    @Transactional
    @PostMapping("/selectdynamicup")
    public String selectdynamicup(Imgvo imgvo, Model model, HttpServletRequest request) {
        System.out.println("选中删除的图片id：" + imgvo.getChecks());
        List<Img> imgs = gmMapper.selectDynamicimgById(imgvo.getChecks());
        System.out.println("删除的图片：" + imgs);
        gmMapper.deleteDynamicimgById(imgvo.getChecks());
        System.out.println(imgs);
        for (Img img : imgs) {
            if (img == null) {
                break;
            } else {
                // 1 初始化用户身份信息(secretId, secretKey)
                COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
                // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
                ClientConfig clientConfig = new ClientConfig(new Region(bucket));
                // 3 生成cos客户端
                COSClient cosclient = new COSClient(cred, clientConfig);
                cosclient.deleteObject(bucketName, img.getK());
                System.out.println("删除图片路径：" + img.getPath());
                cosclient.shutdown();
            }
        }
        mult.mult(gmMapper, model);
        return re;
    }

    /*上传实习生招聘信息*/
    @PostMapping("/upstu")
    public String upstu(String text, Model model) {
        System.out.println("要修改的实习生招聘信息：" + text);
        Studio_stu studio_stu = new Studio_stu();
        studio_stu.setText(text);
        gmMapper.updatestudio_Studio_stu(studio_stu);
        System.out.println("更新完成");
        mult.mult(gmMapper, model);
        return re;
    }

    /*上传研发方向信息*/
    @PostMapping("/updir")
    public String updir(String text, Model model) {
        System.out.println("要修改的研发方向信息：" + text);
        Studio_updir studio_updir = new Studio_updir();
        studio_updir.setText(text);
        gmMapper.updatestudio_studio_updir(studio_updir);
        System.out.println("更新完成");
        mult.mult(gmMapper, model);
        return re;
    }


    /*上传修改工作室简介*/
    @PostMapping("/upindex")
    public String upindex(String text, Model model) {
        System.out.println("要修改的工作室简介：" + text);
        Studio_introduce studio_introduce = new Studio_introduce();
        studio_introduce.setText(text);
        gmMapper.updatestudio_introduce(studio_introduce);
        System.out.println("更新完成");
        mult.mult(gmMapper, model);
        return re;
    }


}


