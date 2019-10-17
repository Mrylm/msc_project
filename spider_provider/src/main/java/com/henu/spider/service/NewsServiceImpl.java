package com.henu.spider.service;

import com.alibaba.fastjson.JSON;
import com.henu.spider.dao.NewsMapper;
import com.henu.spider.entity.News;
import com.henu.spider.entity.NewsCollection;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author shkstart
 * @create 2019-10-15 16:00
 */

@Service
public class NewsServiceImpl implements NewsService {
    @SuppressWarnings("SpringJavaAutowiringInspection")//防止IDEA对@Autowired 代码检查报错
    //注入dao层对象
    @Autowired
    public NewsMapper newsMapper;

    //注入RedisTempdate对象
    @Autowired
    public RedisTemplate redisTemplate;
    /**
     * 执行爬取数据任务，由定时器调用
     */
    public void readNewsFromWebsite() throws IOException {
        //读和不读标记 true:爬取 false:停止爬取
        boolean  startFlag=true;
        int pageNum=1;
        while(startFlag) {
            System.out.println("当前爬取第"+pageNum+"页");
            String url = "https://pacaio.match.qq.com/irs/rcd?cid=146&token=49cbb2154853ef1a74ff4e53723372ce&ext=ent&page="+pageNum+"&callback=__jp6";
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            //执行请求 user center page
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
            HttpEntity entity = closeableHttpResponse.getEntity();
            String content = EntityUtils.toString(entity, "GB2312");
            String jsonContent = StringToJson(content);
            //爬取源数据
            List<News> news = jsonToObject(jsonContent);
            //判断爬取结束
            System.out.println("爬取数据量：" + news.size());
            //List<News> cleanNews = isExistInRedis(news);
            //System.out.println("有效数据量：" + cleanNews.size());
            if(news.size()==0){//没有数据
                startFlag=false;
            }else{
                //去重之后数据
                List<News> cleanNews = isExistInRedis(news);
                System.out.println("有效数据量：" + cleanNews.size());
                if(cleanNews.size()!=0) {
                    //调用dao存储数据
                    newsMapper.batchSaveNews(cleanNews);
                }

                }

            pageNum++;
        }
    }

    /**
     * string转换成json工具方法
     * @param srcJson
     * @return
     */
    public String StringToJson(String srcJson){
        int start=srcJson.indexOf('(')+1;
        int end=srcJson.lastIndexOf(')');
        String jsonContent= srcJson.substring(start,end);
        return  jsonContent;
    }

    public  List<News> jsonToObject(String srcJson){
        //通过fastjson把json字符串转换成java对象
        NewsCollection newsCollection = JSON.parseObject(srcJson, NewsCollection.class);
        List<News> news = newsCollection.getData();
        for (News newsMessage : news) {
            System.out.println(newsMessage);
            System.out.println("---------------------------------------------------------");
        }
        return news;
    }


    //判断redis中是否存在相同地址，不存在则添加到数据库和同步到redis，否则不添加数据到数据库
    public List<News> isExistInRedis(List<News> newsList){
        //Jedis jedis = JedisPoolUtil.getJedis();
        Iterator<News> iterator = newsList.iterator();
        while(iterator.hasNext()){
            //存入redis
            News news=iterator.next();
            //通过redisTemplate判读url是否存在
            boolean isExist=redisTemplate.opsForHash().hasKey("bigdata:0715:spider:news",news.getUrl());
            if(!isExist){//不存在
                //System.out.println("不存在:"+news.getUrl());
                //保存数据到redis
                redisTemplate.opsForHash().put("bigdata:0715:spider:news",news.getUrl(),objectToJson(news));
            }else{//存在则删除
                //System.out.println("存在:"+news.getUrl());
                iterator.remove();
            }
        }
        return newsList;
    }
    //news to json
    public String objectToJson(Object obj){
        return  JSON.toJSONString(obj);
    }
}

