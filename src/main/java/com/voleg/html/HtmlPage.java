package com.voleg.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HtmlPage {

    private String resourceURL;

    public HtmlPage() {}

    public HtmlPage(String resourceURL) {
        this.resourceURL = resourceURL;
    }

    public Document getPage() throws IOException {
        return Jsoup.connect(resourceURL).get();
    }

    public String getResourceURL() {
        return resourceURL;
    }

    public void setResourceURL(String resourceURL) {
        this.resourceURL = resourceURL;
    }
}
