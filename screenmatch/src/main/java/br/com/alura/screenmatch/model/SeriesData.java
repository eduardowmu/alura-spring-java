package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//notação que ignora todos os atributos de um body que não são atribuídos a esta classe
@JsonIgnoreProperties(ignoreUnknown = true)
public record SeriesData(@JsonAlias("Title") String title,
                         @JsonAlias("totalSeasons") Integer totalSeason,
                         @JsonAlias("imdbRating") String evaluation
//        ,
//                         @JsonProperty("imdbVotes") String votes
                        ) {}