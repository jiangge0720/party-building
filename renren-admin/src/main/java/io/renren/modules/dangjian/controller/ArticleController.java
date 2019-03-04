package io.renren.modules.dangjian.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import io.renren.modules.dangjian.entity.CategoryEntity;
import io.renren.modules.dangjian.entity.UserEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dangjian.excel.ArticleBean;
import io.renren.modules.dangjian.entity.ArticleEntity;
import io.renren.modules.dangjian.service.ArticleService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;

import static io.renren.common.utils.FileUitl.decoderBase64File;


/**
 * 文章表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-17 08:54:01
 */
@RestController
@RequestMapping("dj/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    private static final String IMG_LOCATION = "F:/duomeiti/renren-admin/src/main/resources/static/img/";
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dangjian:article:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){

        LayuiPage page = articleService.queryPage(params);

        return page;
    }


    @RequestMapping("/pic/img/{img}")
    public void pic(@PathVariable("img") String img, HttpServletResponse response) throws Exception
    {
        String path = IMG_LOCATION + img;
        File file = new File(path);
        response.setContentType("image/png");
        ServletOutputStream out = response.getOutputStream();
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[2048];
        int count;
        while ((count = fis.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        fis.close();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dangjian:article:info")
    public R info(@PathVariable("id") Long id){
			ArticleEntity article = articleService.selectById(id);

        return R.ok().put("article", article);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dangjian:article:save")
    public R save(@RequestBody ArticleEntity article){
//        String a = article.getImg().replace("data:image/jpeg;base64,", "");
//
//        try {
//            decoderBase64File(a, "D:/dangjian_img/sb.png");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        article.setImg("D:/dangjian_img/sb.png");
//        articleService.insert(article);

        String s = article.getImg();
        String[] ss=s.split(",sunbang;");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss_");
        String currntTime=format.format(new Date());
        String c="";
        for(int i=0;i<ss.length;i++){
            try {
            decoderBase64File(ss[i].replace("data:image/jpeg;base64,", ""), IMG_LOCATION+ currntTime+i+".png");
            String b="/img/"+currntTime+i+".png";
                c=c+b+";";
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        c=c.substring(0,c.length()-1);
        article.setImg(c);
        articleService.insert(article);
        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dangjian:article:update")
    public R update(@RequestBody ArticleEntity article){
        String s = article.getImg();
        String[] ss=s.split(",sunbang;");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss_");
        String currntTime=format.format(new Date());
        String c="";
        for(int i=0;i<ss.length;i++){
            File file=new File("F:/duomeiti/renren-admin/src/main/resources/static/"+ss[i]);
            if(!file.exists())
            {
                try {
                    decoderBase64File(ss[i].replace("data:image/jpeg;base64,", ""), "F:/duomeiti/renren-admin/src/main/resources/static/img/"+ currntTime+i+".png");
                    String b="/img/"+currntTime+i+".png";
                    c=c+b+";";

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                c=c+ss[i]+";";
            }
        }
//       c=c.substring(0,c.length()-1);
        c=c.substring(0,c.length()-1);
        article.setImg(c);
        articleService.updateArticle(article);
        return R.ok();
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:article:delete")
    public R delete(@RequestBody Long[] ids){
			articleService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 导出
    */
    @RequestMapping("/export")
    @RequiresPermissions("dangjian:article:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        LayuiPage page = articleService.queryPage(params);

        ExcelUtils.exportExcelToTarget(response, "文章表", page.getData(), ArticleBean.class);
    }

}
