package com.twu.refactor;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HtmlStatementTest {

    @Test
    public void getHTMLHeaderGetsTheHTMLHeader() {
        HtmlStatement hs = new HtmlStatement();
        Customer customer = new Customer("Dinsdale Pirhane");
        String statement = hs.getHTMLHeader(customer);
        String expectedStatement = "<H1>Rentals for<EM>Dinsdale Pirhane</EM></H1><P>";
        assertTrue(expectedStatement.equals(statement));
    }

    @Test
    public void getHTMLFooterGetsFooterForEachCustomer() {
        HtmlStatement hs = new HtmlStatement();
        String statement = hs.getHTMLFooter(20.4, 3);
        String expectedStatement = "<P>You owe<EM>20.4</EM>" +
                "<P>On this rental you earned<EM>3</EM>frequent renter points<P>";
        assertTrue(expectedStatement.equals(statement));
    }
}