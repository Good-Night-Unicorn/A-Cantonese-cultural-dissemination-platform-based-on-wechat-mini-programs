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

import com.entity.DiscussyueyuyingshiEntity;
import com.entity.view.DiscussyueyuyingshiView;

import com.service.DiscussyueyuyingshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 粤语影视评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-18 12:43:21
 */
@RestController
@RequestMapping("/discussyueyuyingshi")
public class DiscussyueyuyingshiController {
    @Autowired
    private DiscussyueyuyingshiService discussyueyuyingshiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussyueyuyingshiEntity discussyueyuyingshi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussyueyuyingshiEntity> ew = new EntityWrapper<DiscussyueyuyingshiEntity>();


        //查询结果
		PageUtils page = discussyueyuyingshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyueyuyingshi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussyueyuyingshiEntity discussyueyuyingshi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussyueyuyingshiEntity> ew = new EntityWrapper<DiscussyueyuyingshiEntity>();

        //查询结果
		PageUtils page = discussyueyuyingshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyueyuyingshi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussyueyuyingshiEntity discussyueyuyingshi){
       	EntityWrapper<DiscussyueyuyingshiEntity> ew = new EntityWrapper<DiscussyueyuyingshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussyueyuyingshi, "discussyueyuyingshi")); 
        return R.ok().put("data", discussyueyuyingshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussyueyuyingshiEntity discussyueyuyingshi){
        EntityWrapper< DiscussyueyuyingshiEntity> ew = new EntityWrapper< DiscussyueyuyingshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussyueyuyingshi, "discussyueyuyingshi")); 
		DiscussyueyuyingshiView discussyueyuyingshiView =  discussyueyuyingshiService.selectView(ew);
		return R.ok("查询粤语影视评论表成功").put("data", discussyueyuyingshiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussyueyuyingshiEntity discussyueyuyingshi = discussyueyuyingshiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussyueyuyingshi,deSens);
        return R.ok().put("data", discussyueyuyingshi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussyueyuyingshiEntity discussyueyuyingshi = discussyueyuyingshiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussyueyuyingshi,deSens);
        return R.ok().put("data", discussyueyuyingshi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussyueyuyingshiEntity discussyueyuyingshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyueyuyingshi);
        discussyueyuyingshiService.insert(discussyueyuyingshi);
        return R.ok().put("data",discussyueyuyingshi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussyueyuyingshiEntity discussyueyuyingshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyueyuyingshi);
        discussyueyuyingshiService.insert(discussyueyuyingshi);
        return R.ok().put("data",discussyueyuyingshi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussyueyuyingshiEntity discussyueyuyingshi = discussyueyuyingshiService.selectOne(new EntityWrapper<DiscussyueyuyingshiEntity>().eq("", username));
        return R.ok().put("data", discussyueyuyingshi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussyueyuyingshiEntity discussyueyuyingshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussyueyuyingshi);
        //全部更新
        discussyueyuyingshiService.updateById(discussyueyuyingshi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussyueyuyingshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussyueyuyingshiEntity discussyueyuyingshi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussyueyuyingshiEntity> ew = new EntityWrapper<DiscussyueyuyingshiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussyueyuyingshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussyueyuyingshi), params), params));
        return R.ok().put("data", page);
    }








}
