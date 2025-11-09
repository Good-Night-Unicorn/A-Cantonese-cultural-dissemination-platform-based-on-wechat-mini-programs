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

import com.entity.WenhuafenleiEntity;
import com.entity.view.WenhuafenleiView;

import com.service.WenhuafenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 文化分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-18 12:43:19
 */
@RestController
@RequestMapping("/wenhuafenlei")
public class WenhuafenleiController {
    @Autowired
    private WenhuafenleiService wenhuafenleiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenhuafenleiEntity wenhuafenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WenhuafenleiEntity> ew = new EntityWrapper<WenhuafenleiEntity>();


        //查询结果
		PageUtils page = wenhuafenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenhuafenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WenhuafenleiEntity wenhuafenlei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WenhuafenleiEntity> ew = new EntityWrapper<WenhuafenleiEntity>();

        //查询结果
		PageUtils page = wenhuafenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenhuafenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenhuafenleiEntity wenhuafenlei){
       	EntityWrapper<WenhuafenleiEntity> ew = new EntityWrapper<WenhuafenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenhuafenlei, "wenhuafenlei")); 
        return R.ok().put("data", wenhuafenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenhuafenleiEntity wenhuafenlei){
        EntityWrapper< WenhuafenleiEntity> ew = new EntityWrapper< WenhuafenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenhuafenlei, "wenhuafenlei")); 
		WenhuafenleiView wenhuafenleiView =  wenhuafenleiService.selectView(ew);
		return R.ok("查询文化分类成功").put("data", wenhuafenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenhuafenleiEntity wenhuafenlei = wenhuafenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wenhuafenlei,deSens);
        return R.ok().put("data", wenhuafenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenhuafenleiEntity wenhuafenlei = wenhuafenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(wenhuafenlei,deSens);
        return R.ok().put("data", wenhuafenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenhuafenleiEntity wenhuafenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(wenhuafenleiService.selectCount(new EntityWrapper<WenhuafenleiEntity>().eq("wenhuafenlei", wenhuafenlei.getWenhuafenlei()))>0) {
            return R.error("文化分类已存在");
        }
        //ValidatorUtils.validateEntity(wenhuafenlei);
        wenhuafenleiService.insert(wenhuafenlei);
        return R.ok().put("data",wenhuafenlei.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenhuafenleiEntity wenhuafenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(wenhuafenleiService.selectCount(new EntityWrapper<WenhuafenleiEntity>().eq("wenhuafenlei", wenhuafenlei.getWenhuafenlei()))>0) {
            return R.error("文化分类已存在");
        }
        //ValidatorUtils.validateEntity(wenhuafenlei);
        wenhuafenleiService.insert(wenhuafenlei);
        return R.ok().put("data",wenhuafenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenhuafenleiEntity wenhuafenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenhuafenlei);
        //验证字段唯一性，否则返回错误信息
        if(wenhuafenleiService.selectCount(new EntityWrapper<WenhuafenleiEntity>().ne("id", wenhuafenlei.getId()).eq("wenhuafenlei", wenhuafenlei.getWenhuafenlei()))>0) {
            return R.error("文化分类已存在");
        }
        //全部更新
        wenhuafenleiService.updateById(wenhuafenlei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenhuafenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
