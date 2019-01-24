package cn.cks.studiowebsite.controller;

import cn.cks.studiowebsite.dao.pojo.Img;
import cn.cks.studiowebsite.dao.pojo.People;
import cn.cks.studiowebsite.service.GmMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.LinkedList;
import java.util.List;

@Service
public class Mult {
    void mult(GmMapper gmMapper, Model model){
        LinkedList<People> people1 = gmMapper.select();
        model.addAttribute("people", people1);
        List<Img> listimg=gmMapper.selectImg();
        model.addAttribute("listimg",listimg);
        List<Img> list=gmMapper.selectDynamicImg();
        model.addAttribute("listimg2",list);
    }
}
