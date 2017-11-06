package com.shamalk.webchecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebChecker {
	public static void main(String[] args) throws IOException {
		String[] url = {"https://www.freelancer.com/jobs/java/?cl=l-en", "http://google.com"};
		
		Connection connection = Jsoup.connect(url[0]);
		connection.maxBodySize(0);
		Document doc = connection.get();
		Elements jobSearchCardItems = doc.select(".JobSearchCard-primary");
		for(Element jobSearchCard: jobSearchCardItems) {
			Element headingElement = jobSearchCard.selectFirst(".JobSearchCard-primary-heading-link");
			System.out.println(headingElement.text());
			if(headingElement==null) {
				System.out.println(jobSearchCard);
			}
		}
		String content = doc.html();
//		System.out.println(content);
//		Files.write(Paths.get("test.html"), content.getBytes());
	}

}
