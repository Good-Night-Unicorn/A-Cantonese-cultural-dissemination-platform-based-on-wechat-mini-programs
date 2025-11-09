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

import com.entity.YueyushangpinEntity;
import com.entity.view.YueyushangpinView;

import com.service.YueyushangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 粤语商品
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-18 12:43:20
 */
@RestController
@RequestMapping("/yueyushangpin")
public class YueyushangpinController {
    @Autowired
    private YueyushangpinService yueyushangpinService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YueyushangpinEntity yueyushangpin,
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YueyushangpinEntity> ew = new EntityWrapper<YueyushangpinEntity>();
        if(pricestart!=null) ew.ge("price", pricestart);
        if(priceend!=null) ew.le("price", priceend);


        //查询结果
		PageUtils page = yueyushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yueyushangpin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YueyushangpinEntity yueyushangpin, 
                @RequestParam(required = false) Double pricestart,
                @RequestParam(required = false) Double priceend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YueyushangpinEntity> ew = new EntityWrapper<YueyushangpinEntity>();
        if(pricestart!=null) ew.ge("price", pricestart);
        if(priceend!=null) ew.le("price", priceend);

        //查询结果
		PageUtils page = yueyushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yueyushangpin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YueyushangpinEntity yueyushangpin){
       	EntityWrapper<YueyushangpinEntity> ew = new EntityWrapper<YueyushangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yueyushangpin, "yueyushangpin")); 
        return R.ok().put("data", yueyushangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YueyushangpinEntity yueyushangpin){
        EntityWrapper< YueyushangpinEntity> ew = new EntityWrapper< YueyushangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yueyushangpin, "yueyushangpin")); 
		YueyushangpinView yueyushangpinView =  yueyushangpinService.selectView(ew);
		return R.ok("查询粤语商品成功").put("data", yueyushangpinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YueyushangpinEntity yueyushangpin = yueyushangpinService.selectById(id);
		yueyushangpin.setClicknum(yueyushangpin.getClicknum()+1);
		yueyushangpin.setClicktime(new Date());
		yueyushangpinService.updateById(yueyushangpin);
        yueyushangpin = yueyushangpinService.selectView(new EntityWrapper<YueyushangpinEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yueyushangpin,deSens);
        return R.ok().put("data", yueyushangpin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YueyushangpinEntity yueyushangpin = yueyushangpinService.selectById(id);
		yueyushangpin.setClicknum(yueyushangpin.getClicknum()+1);
		yueyushangpin.setClicktime(new Date());
		yueyushangpinService.updateById(yueyushangpin);
        yueyushangpin = yueyushangpinService.selectView(new EntityWrapper<YueyushangpinEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yueyushangpin,deSens);
        return R.ok().put("data", yueyushangpin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YueyushangpinEntity yueyushangpin = yueyushangpinService.selectById(id);
        if(type.equals("1")) {
        	yueyushangpin.setThumbsupnum(yueyushangpin.getThumbsupnum()+1);
        } else {
        	yueyushangpin.setCrazilynum(yueyushangpin.getCrazilynum()+1);
        }
        yueyushangpinService.updateById(yueyushangpin);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YueyushangpinEntity yueyushangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yueyushangpin);
        yueyushangpinService.insert(yueyushangpin);
        return R.ok().put("data",yueyushangpin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YueyushangpinEntity yueyushangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yueyushangpin);
        yueyushangpinService.insert(yueyushangpin);
        return R.ok().put("data",yueyushangpin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YueyushangpinEntity yueyushangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yueyushangpin);
        //全部更新
        yueyushangpinService.updateById(yueyushangpin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yueyushangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,YueyushangpinEntity yueyushangpin, HttpServletRequest request,String pre){
        EntityWrapper<YueyushangpinEntity> ew = new EntityWrapper<YueyushangpinEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = yueyushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yueyushangpin), params), params));
        return R.ok().put("data", page);
    }








}
