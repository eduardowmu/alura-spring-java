package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.SeriesData;
import br.com.alura.screenmatch.service.ConsumeApi;
import br.com.alura.screenmatch.service.DataConvertion;
import br.com.alura.screenmatch.service.DataConvertionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
	@Autowired
	private DataConvertion dataConvertion;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumeApi();
		var json = consumoApi.getDatas("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
		SeriesData seriesData = this.dataConvertion.getDatas(json, SeriesData.class);
		System.out.println(seriesData);
	}
}
