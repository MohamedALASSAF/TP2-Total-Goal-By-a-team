package com.java.web.tps.tp2.API;

import com.java.web.tps.tp2.entities.Match;
import com.java.web.tps.tp2.services.DataAnalysis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MatchAPI {
    private static final String  homeTeamUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=%s&team1=%s&page=%d";
    private static final String  visitingTeamUrl = "https://jsonmock.hackerrank.com/api/football_matches?year=%s&team2=%s&page=%d";



    public static List<Match> homeTeamMatchAPI(String yearParam, String teamParam){
        String url = String.format(homeTeamUrl,yearParam,teamParam,1);
        return APImatch(url,yearParam,teamParam) ;
    }
    public static List<Match> visitingTeamMatchAPI(String yearParam, String teamParam){
        String url = String.format(visitingTeamUrl,yearParam,teamParam,1);
        return APImatch(url,yearParam,teamParam) ;
    }

    public static List<Match> APImatch(String url, String yearParam, String teamParam, Integer pageParam){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<APIResponse> response = restTemplate.getForEntity(url, APIResponse.class);
        int totalPages = response.getBody().getTotal_pages() ;
        List<Match> data = response.getBody().getData();
        if (totalPages > pageParam ) {
            url = url.replace("page="+pageParam,"page="+(pageParam+1) ) ;
            data.addAll(APImatch(url,yearParam, teamParam, pageParam + 1 )) ;
            return data ;
        }

        return data ;
    }

    public static List<Match> APImatch(String url, String yearParam, String teamParam){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<APIResponse> response = restTemplate.getForEntity(url,APIResponse.class);
        List<Match> data = response.getBody().getData();
        if(response.getBody().getTotal_pages() > 1){
            url = url.replace("page=1","page=2") ;
            data.addAll(APImatch(url,yearParam, teamParam, 2)) ;
            return data ;
        }
        return data ;
    }

    
}
