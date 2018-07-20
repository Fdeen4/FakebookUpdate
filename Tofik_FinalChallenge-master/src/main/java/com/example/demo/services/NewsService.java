package com.example.demo.services;

import com.example.demo.model.apis.newsapi.Article;
import com.example.demo.model.apis.newsapi.Articles;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {
    public Iterable<Article> articles(){
        RestTemplate fromApi = new RestTemplate();
        Articles articles = fromApi.getForObject("https://newsapi.org/v2/top-headlines?country=us&apiKey=5257f0a045ad4bc79397653e4210f74b", Articles.class);

        return articles.getArticles();
    }

    @Override
    public String toString(){//for testing
        String newsText = "";
        for (Article article : articles()){
//            System.out.println("one article: " + article.toString());
            newsText += article.toString() + "\n\n";
        }
        return newsText;
    }
}
