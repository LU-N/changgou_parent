package com.changgou.search.controller;


import com.changgou.entity.Page;
import com.changgou.search.pojo.SkuInfo;
import com.changgou.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

/**
 * @author JinLu
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    /**
     * 搜索功能，由于页面是thymeleaf 完成的 属于服务器内页面渲染 跳转页面
     *
     * @param searchMap
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String search(@RequestParam Map<String, String> searchMap, Model model) {

        //特殊符号处理
        this.handleSearchMap(searchMap);

        //获取查询结果
        Map resultMap = searchService.search(searchMap);
        model.addAttribute("result", resultMap);
        model.addAttribute("searchMap", searchMap);

        //分页计算
        Page<SkuInfo> skuInfoPage = new Page<>(
                Long.parseLong(String.valueOf(resultMap.get("total"))),
                Integer.parseInt(String.valueOf(resultMap.get("pageNum"))),
                Page.pageSize
        );
        model.addAttribute("page", skuInfoPage);


        //拼装url
        StringBuilder url = new StringBuilder("/search/list");
        if (searchMap != null && searchMap.size() > 0) {
            url.append("?");
            for (String paramKey : searchMap.keySet()) {
                if (!"sortRule".equals(paramKey) && !"sortField".equals(paramKey) && !"pageNum".equals(paramKey)) {
                    url.append(paramKey).append("=").append(searchMap.get(paramKey)).append("&");
                }
            }
            //http://localhost:9009/search/list?keywords=手机&spec_网络制式=4G&
            String urlString = url.toString();
            //去除路径上的最后一个&
            urlString = urlString.substring(0, urlString.length() - 1);
            model.addAttribute("url", urlString);
        } else {
            model.addAttribute("url", url);
        }
        return "search";
    }

    @GetMapping
    @ResponseBody
    public Map search(@RequestParam Map<String, String> searchMap) {
        //特殊符号处理
        this.handleSearchMap(searchMap);
        Map searchResult = searchService.search(searchMap);
        return searchResult;
    }

    private void handleSearchMap(Map<String, String> searchMap) {
        Set<Map.Entry<String, String>> entries = searchMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            if (entry.getKey().startsWith("spec_")) {
                searchMap.put(entry.getKey(), entry.getValue().replace("+", "%2B"));
            }
        }
    }
}
