package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class);

    InputStream retrieve(String city) throws Exception {
        log.info("Retrieving Weather Data");
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20" +
                "where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20" +
                "where%20text%3D%22" + city.trim().replaceAll("\\s+", "%20") + "%22)&format=xml&env=" +
                "store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
