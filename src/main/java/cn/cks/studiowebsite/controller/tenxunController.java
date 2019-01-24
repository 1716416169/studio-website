package cn.cks.studiowebsite.controller;

import cn.cks.studiowebsite.dao.pojo.Img;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@Configuration
public class tenxunController {


    private class UploadMsg{
        public int status;
        public String msg;
        public String path;

        public UploadMsg() {
            super();
        }

        public UploadMsg(int status,String msg,String path){

            this.status = status;
            this.msg = msg;
            this.path = path;

        }
    }

}
