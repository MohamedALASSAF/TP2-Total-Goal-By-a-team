package com.java.web.tps.tp2.services;

import com.java.web.tps.tp2.API.MatchAPI;
import com.java.web.tps.tp2.entities.Match;

import java.util.ArrayList;
import java.util.List;

public  class DataAnalysis {

    public static List<Match> getAllMatch(String yearParam, String teamParam){

        List<Match> allMatch =  MatchAPI.homeTeamMatchAPI(yearParam,teamParam) ;
        allMatch.addAll(MatchAPI.visitingTeamMatchAPI(yearParam,teamParam)) ;
        return allMatch;
    }

    public static  int totalGoals(String yearParam, String teamParam){
        List<Match> allMatch = getAllMatch(yearParam,teamParam) ;
        int nbGoal = 0;
        for(Match m : allMatch){
            if(m.getTeam1().equals(teamParam)){
                nbGoal += m.getTeam1goals() ;
            }
            else{
                nbGoal += m.getTeam2goals() ;
            }
        }
        return nbGoal ;
    }

}
