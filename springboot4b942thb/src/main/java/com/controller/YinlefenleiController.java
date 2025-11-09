package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YinlefenleiEntity;
import com.entity.view.YinlefenleiView;

import com.service.YinlefenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 音乐分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-18 12:43:19
 */
@RestController
@RequestMapping("/yinlefenlei")
public class YinlefenleiController {
    @Autowired
    private YinlefenleiService yinlefenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YinlefenleiEntity yinlefenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinlefenleiEntity> ew = new EntityWrapper<YinlefenleiEntity>();


        //查询结果
		PageUtils page = yinlefenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlefenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YinlefenleiEntity yinlefenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YinlefenleiEntity> ew = new EntityWrapper<YinlefenleiEntity>();

        //查询结果
		PageUtils page = yinlefenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yinlefenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YinlefenleiEntity yinlefenlei){
       	EntityWrapper<YinlefenleiEntity> ew = new EntityWrapper<YinlefenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yinlefenlei, "yinlefenlei")); 
        return R.ok().put("data", yinlefenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YinlefenleiEntity yinlefenlei){
        EntityWrapper< YinlefenleiEntity> ew = new EntityWrapper< YinlefenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yinlefenlei, "yinlefenlei")); 
		YinlefenleiView yinlefenleiView =  yinlefenleiService.selectView(ew);
		return R.ok("查询音乐分类成功").put("data", yinlefenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YinlefenleiEntity yinlefenlei = yinlefenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinlefenlei,deSens);
        return R.ok().put("data", yinlefenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YinlefenleiEntity yinlefenlei = yinlefenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yinlefenlei,deSens);
        return R.ok().put("data", yinlefenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YinlefenleiEntity yinlefenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(yinlefenleiService.selectCount(new EntityWrapper<YinlefenleiEntity>().eq("yinlefenlei", yinlefenlei.getYinlefenlei()))>0) {
            return R.error("音乐分类已存在");
        }
        //ValidatorUtils.validateEntity(yinlefenlei);
        yinlefenleiService.insert(yinlefenlei);
        return R.ok().put("data",yinlefenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YinlefenleiEntity yinlefenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(yinlefenleiService.selectCount(new EntityWrapper<YinlefenleiEntity>().eq("yinlefenlei", yinlefenlei.getYinlefenlei()))>0) {
            return R.error("音乐分类已存在");
        }
        //ValidatorUtils.validateEntity(yinlefenlei);
        yinlefenleiService.insert(yinlefenlei);
        return R.ok().put("data",yinlefenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YinlefenleiEntity yinlefenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yinlefenlei);
        //验证字段唯一性，否则返回错误信息
        if(yinlefenleiService.selectCount(new EntityWrapper<YinlefenleiEntity>().ne("id", yinlefenlei.getId()).eq("yinlefenlei", yinlefenlei.getYinlefenlei()))>0) {
            return R.error("音乐分类已存在");
        }
        //全部更新
        yinlefenleiService.updateById(yinlefenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yinlefenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
