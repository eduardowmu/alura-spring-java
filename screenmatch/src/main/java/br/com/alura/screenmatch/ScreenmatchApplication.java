package br.com.alura.screenmatch;

import br.com.alura.screenmatch.main.MainMenu;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.DataConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
//	@Autowired
//	private DataConvertion dataConvertion;
//	@Autowired
//	private ConsumeApi consumeApi;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var json = consumeApi.getDatas("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
//		System.out.println(json);
//		SeriesData seriesData = this.dataConvertion.getDatas(json, SeriesData.class);
//		System.out.println(seriesData);
//		json = consumeApi.getDatas("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//		EpisodesData episodesData = this.dataConvertion.getDatas(json, EpisodesData.class);
//		System.out.println(episodesData);

//		List<SeasonData> seasonDataList = new ArrayList<>();
//
//		if(seriesData.totalSeason() != null && seriesData.totalSeason() > 0) {
//			for(int i = 1; i < seriesData.totalSeason(); i++) {
//				json = consumeApi.getDatas("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
//				SeasonData seasonData = this.dataConvertion.getDatas(json, SeasonData.class);
//				seasonDataList.add(seasonData);
//			}
//
//			seasonDataList.forEach(System.out::println);
//		}

		MainMenu mainMenu = new MainMenu();
		mainMenu.showMenu();
	}
}
