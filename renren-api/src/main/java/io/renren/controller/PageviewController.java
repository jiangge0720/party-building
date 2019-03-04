package io.renren.controller;

import io.renren.common.utils.R;
import io.renren.entity.Pageview;
import io.renren.service.PageviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1910:05
 */
@RestController
@RequestMapping("/api/pageview")
public class PageviewController {

    @Autowired
    private PageviewService pageviewService;


    @Autowired
    private HttpServletRequest request;


    /**
     * 历史访问量
     */
    @RequestMapping("/count")
    public Integer count(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();

            if(ip.equals("127.0.0.1")){


                InetAddress inet=null;

                try {

                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {

                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }


        if(ip != null && ip.length() > 15){

            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }

        List<Pageview> list = pageviewService.selectIp(ip);

        Integer size = 0;

        if(null == list || list.size() ==0 ){
            Pageview pageview1 = new Pageview();
            pageview1.setIp(ip);
            pageviewService.insertPageview(pageview1);
        }
        else{

            for(Pageview pageview : list){

                Date time1 = pageview.getCreateTime();
                Date time2 = new Date();
                Long day = (time2.getTime() - time1.getTime())/86400000;
                if(day>1){
                    size++;
                }
            }
            if(size>0) {
                Pageview pageview1 = new Pageview();
                pageview1.setIp(ip);
                pageviewService.insertPageview(pageview1);
            }
        }
        Integer count = pageviewService.count();

        return count;

    }

    /**
     * 本周访问量
     */
    @RequestMapping("/weekcount")
    public R count(){

         Integer weekcount = 0;

        List<Pageview> pageviewList = pageviewService.selectAll();

        for(Pageview pageview : pageviewList){

            Date time1 = pageview.getCreateTime();
            Date time2 = new Date();
            Long day = (time2.getTime() - time1.getTime())/86400000;

            if(day<7){
                weekcount++;
            }
        }

        return R.ok().put("weekcount",weekcount);

    }

    /**
     * 话题总数量
     */
    @RequestMapping("/topiccount")
    public R topiccount(){

       Integer topiccount = pageviewService.topiccount();

       return R.ok().put("topiccount",topiccount);
    }

}