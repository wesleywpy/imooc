package com.imooc.study.web;

/**
 * Created by Wesley on 2016/6/10.
 */

import com.imooc.study.dto.Exposer;
import com.imooc.study.dto.SeckillExecution;
import com.imooc.study.dto.SeckillResult;
import com.imooc.study.entity.Seckill;
import com.imooc.study.enums.SeckillStatEnum;
import com.imooc.study.exception.RepeatKillException;
import com.imooc.study.exception.SeckillCloseException;
import com.imooc.study.service.SeckillService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    private Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    SeckillService seckillService;

    /**
     * 秒杀列表
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<Seckill> seckillList =  seckillService.getSeckillList();
        model.addAttribute("seckillList", seckillList);
        return "list";
    }


    /**
     * 详情页
     * @return
     */
    @RequestMapping("/{id}/detail")
    public String detail(@PathVariable Long id, Model model){
        if(Objects.isNull(id))
            return "redirect:/seckill/list";

        Seckill seckill = seckillService.getById(id);
        if(Objects.isNull(seckill))
            return "forward:/seckill/list";

        model.addAttribute("seckill", seckill);

        return "detail";
    }


    /**
     * 暴露秒杀
     */
    @RequestMapping(value = "/{id}/exposer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable Long id){
        SeckillResult<Exposer> result = new SeckillResult<>();

        try {
            Exposer exposer = seckillService.exportSeckillUrl(id);
            result.setData(exposer);
            result.setSuccess(true);
        }catch (Exception e){
            LOG.error(e.getMessage());
            result = new SeckillResult<>(false, e.getMessage());
        }
        return result;
    }

    /**
     * 执行秒杀
     * @return
     */
    @RequestMapping(value = "/{id}/{md5}/execution", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SeckillResult execute(@PathVariable("id") Long seckillId, @PathVariable String md5, @CookieValue(value = "killPhone", required = false) Long killPhone){
        if (killPhone == null) {
            return new SeckillResult<SeckillExecution>(false, SeckillStatEnum.NOT_LOGIN.getInfo());
        }

        try {
            SeckillExecution execution =  seckillService.executeSeckill(seckillId, killPhone, md5);
//            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, killPhone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
    }


    /**
     * 系统时间
     * @return
     */
    @RequestMapping("/time/now")
    @ResponseBody
    public SeckillResult<Long> time(){
        return new SeckillResult<>(true, new Date().getTime());
    }
}
