package io.renren.modules.mark.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.mark.excel.ExamPaperBean;
import io.renren.modules.mark.entity.ExamPaperEntity;
import io.renren.modules.mark.service.ExamPaperService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;


/**
 * 试卷表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-21 16:44:00
 */
@RestController
@RequestMapping("dj/paper")
public class ExamPaperController {
    @Autowired
    private ExamPaperService examPaperService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("mark:exampaper:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = examPaperService.queryPage(params);

        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{paperId}")
//    @RequiresPermissions("mark:exampaper:info")
    public R info(@PathVariable("paperId") Integer paperId){
			ExamPaperEntity examPaper = examPaperService.selectById(paperId);

        return R.ok().put("examPaper", examPaper);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("mark:exampaper:save")
    public R save(@RequestBody ExamPaperEntity examPaper){
			examPaperService.insert(examPaper);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("mark:exampaper:update")
    public R update(@RequestBody ExamPaperEntity examPaper){
			examPaperService.updateById(examPaper);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("mark:exampaper:delete")
    public R delete(@RequestBody Integer[] paperIds){
			examPaperService.deleteBatchIds(Arrays.asList(paperIds));

        return R.ok();
    }

    /**
     * 导出
    */
    @RequestMapping("/export")
    @RequiresPermissions("mark:exampaper:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        LayuiPage page = examPaperService.queryPage(params);

        ExcelUtils.exportExcelToTarget(response, "试卷表", page.getData(), ExamPaperBean.class);
    }

}
