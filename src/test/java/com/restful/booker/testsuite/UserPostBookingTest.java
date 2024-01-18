package com.restful.booker.testsuite;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserPostBookingTest extends TestBase {
    @Test
    public void verifyUserCreateSuccessfully() {


        HashMap<String, String> checkInOutDatesData = new HashMap<String, String>();
        checkInOutDatesData.put("checkin", "2018-01-01");
        checkInOutDatesData.put("checkout", "2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jim");
        bookingPojo.setLastname("Black");
        bookingPojo.setTotalprice(120);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setBookingdates(checkInOutDatesData);
        bookingPojo.setAdditionalneeds("Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(bookingPojo)
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
