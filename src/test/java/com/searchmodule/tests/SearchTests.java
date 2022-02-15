package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTests extends BaseTests {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword) {
        SearchPage page = new SearchPage(this.driver);
        page.goTo();
        page.Search(keyword);
        page.goToVideos();
        int size = page.getResult();
        Assert.assertTrue(size > 0);
    }
}
