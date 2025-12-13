package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.SeasonData;
import br.com.alura.screenmatch.model.SeriesData;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.DataConvertion;
import br.com.alura.screenmatch.service.DataConvertionImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//"https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"
public class MainMenu {
    private Scanner reader = new Scanner(System.in);
    private final String ADRESS = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=6585022c";
    private final ConsumeApi consumeApi = new ConsumeApi();
    private final DataConvertion dataConvertion = new DataConvertionImpl();
    public void showMenu() {
        System.out.println("Digit the seri's name for searching: ");
        var serieName = reader.nextLine();
        var json = consumeApi.getDatas(ADRESS + serieName.replaceAll(" ", "+") + APIKEY);
        SeriesData seriesData = this.dataConvertion.getDatas(json, SeriesData.class);
        System.out.println(seriesData);

        List<SeasonData> seasonDataList = new ArrayList<>();

		if(seriesData.totalSeason() != null && seriesData.totalSeason() > 0) {
			for(int i = 1; i < seriesData.totalSeason(); i++) {
				json = consumeApi.getDatas(ADRESS + serieName.replaceAll(" ", "+") + "&season=" + i + APIKEY);
				SeasonData seasonData = this.dataConvertion.getDatas(json, SeasonData.class);
				seasonDataList.add(seasonData);
			}

			seasonDataList.forEach(System.out::println);
		}
    }
}