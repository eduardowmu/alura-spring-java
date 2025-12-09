package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SeriesData(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") Integer totalSeason,
                         @JsonAlias("imdbRating") String evaluation
//        ,
//                         @JsonProperty("imdbVotes") String votes
                        ) {}