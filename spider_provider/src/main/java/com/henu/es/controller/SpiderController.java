package com.henu.es.controller;

import com.henu.es.bean.EsPage;
import com.henu.es.util.ElasticsearchUtil;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2019-10-16 11:11
 */
@Controller
public class SpiderController {
    @RequestMapping("/search")
    @ResponseBody
    public EsPage search(String keyword, @RequestParam(value="currentPage",defaultValue = "1") int currentPage, @RequestParam(value="pageSize",defaultValue = "10") int pageSize){
        System.out.println("好好学习,天天向上:"+keyword);
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("intro", keyword);
        EsPage esPage = ElasticsearchUtil.searchDataPage("spider", currentPage, pageSize, queryBuilder, "id,app_id,title,intro,url,source,update_time", "id", "intro");
        return esPage;
    }
}


