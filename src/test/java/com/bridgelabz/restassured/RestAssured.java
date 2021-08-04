package com.bridgelabz.restassured;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class RestAssured {

    public String token = "";
    public static String userID ;
    public static String playlistId ;

    @BeforeTest
    public void setUp() {
        token = "Bearer BQB48QYGAZDDUBA6LWM8bScGlvF0xYw6Foa7dlxdFjCNE8iyHmGrXvt7QMG0Y_4RBFo-2c--2610e12DZmXcZ-r2_OpWJ8xy" +
                "i43r9waOvV0_5LvZnpTiewVsCEoMqB3dwq7Ng1M-g0iPfnv_ZCN8XioShnqoxpbqc3USoZJ2i2zOcw3DB81noun73ZXPovlmxjaICAG" +
                "NkN8Duq2NKvMUwvZ1rBBMW_b6FlFHexfCzq8nuLAuHH0D0hPeM0eOIFwvVEXPfd3Wt8z_p4eBK0mO-IPpA_hR78krnD8sT8X3Lx0d";
    }

    /*
    Gets current profile data
     */
    @Test
    public void get_Current_UserProfile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();

        userID = response.path("id");
        System.out.println("Data from response-->"+userID);
    }

    @Test
    public void get_UserProfile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/"+userID);
        response.prettyPrint();
    }

    /*
    Gets information on current users playlist
     */
    @Test
    public void get_CurrentUsersPlaylist() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");

        playlistId = response.path("uri");
        System.out.println("---"+playlistId);
        response.prettyPrint();
    }

    /*
    Gets information on user's playlist cover image
     */
    @Test
    public void get_APlaylistCover() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/6kARld7la7IvgtyUOt1eQX");
        response.prettyPrint();
    }
}

