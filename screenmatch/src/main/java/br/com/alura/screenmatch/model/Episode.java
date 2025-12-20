package br.com.alura.screenmatch.model;

import java.time.LocalDate;

public class Episode {
    private Integer season;
    private String title;
    private Integer episode;
    private String evaluation;
    private Double evaluationNumber;
    private LocalDate launchDate;

    public Episode(Integer season, EpisodesData episodesData) {
        this.season = season;
        this.title = episodesData.title();
        this.episode = episodesData.episode();
        this.evaluation = episodesData.evaluation();
        this.launchDate = LocalDate.parse(episodesData.launchDate());
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public Double getEvaluationNumber() {
        return evaluationNumber;
    }

    public void setEvaluationNumber(Double evaluationNumber) {
        this.evaluationNumber = evaluationNumber;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", episode=" + episode +
                ", evaluation='" + evaluation + '\'' +
                ", launchDate=" + launchDate +
                '}';
    }
}