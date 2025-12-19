package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.Episode;
import br.com.alura.screenmatch.model.EpisodesData;
import br.com.alura.screenmatch.model.SeasonData;
import br.com.alura.screenmatch.model.SeriesData;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.DataConvertion;
import br.com.alura.screenmatch.service.DataConvertionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//"https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"
@Service
public class MainMenu {
    private Scanner reader = new Scanner(System.in);
    private final String ADRESS = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=6585022c";
    @Autowired
    private ConsumeApi consumeApi;
    @Autowired
    private DataConvertion dataConvertion;
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
            List<String> episodes = new ArrayList<>();
            seasonDataList.forEach(s -> s.episodes().forEach(e -> episodes.add(e.title())));
            //exibindo nomes de episodeos em ordem alfabetica limitado a 10
            episodes.stream()
                    .sorted()
                    .limit(10)
                    //criando um filtro
                    .filter(n -> n.contains("Ikki"))
                    //transformando
                    .map(n -> n.toUpperCase())
                    .forEach(System.out::println);

            //exibindo lista dos top 5 episodeos de todas as temporadas
            List<EpisodesData> episodesData = seasonDataList.stream()
                    .flatMap(t -> t.episodes().stream())
                    //.collect(Collectors.toList()); //ou pode ser também, porém será
                    .toList();//uma lista imutável, não poderemos add mais este tipo

            episodesData.stream()
                    .filter(e -> !e.evaluation().equals("N/A"))
                    //Essa função nos permite observar o que está acontecendo em cada etapa da nossa stream.
//                    .peek(e -> System.out.println("Primeiro filtro(N/A): " + e))
                    .sorted(Comparator.comparing(EpisodesData::evaluation).reversed())
//                    .peek(e -> System.out.println("Ordenação: " + e))
                    .limit(5)
//                    .peek(e -> System.out.println("Limit: " + e))
                    .map(e -> e.title().toUpperCase())
                    .peek(e -> System.out.println("Mapeamento: " + e))
                    .forEach(System.out::println);

            List<Episode> episodeList = seasonDataList.stream()
                    .flatMap(s -> s.episodes().stream().map(e -> new Episode(s.season(), e)))
                    .collect(Collectors.toList());

            //desde que a classe tenha o método toString(), isso escreve o objeto da maneira
            episodeList.stream()
                    .filter(e -> e.getLaunchDate() != null && e.getLaunchDate().isAfter(
                            LocalDate.of(1985, 1, 1)))
                    .forEach(System.out::println);
            //encontra o(s) episódio(s)
            episodeList.stream()
                    .filter(e -> e.getTitle().contains("Ikki"))
                    //.findFirst()
                    .findAny()
                    .stream().forEach(System.out::println);
		}
    }
}