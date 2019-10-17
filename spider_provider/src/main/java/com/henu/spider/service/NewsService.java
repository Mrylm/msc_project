package com.henu.spider.service;

import java.io.IOException;

/**爬虫业务层接口
 * @author shkstart
 * @create 2019-10-15 15:44
 */
public interface NewsService {
    /**
     * 执行爬取数据任务，由定时器调用
     */
    public void readNewsFromWebsite()throws IOException;

}

