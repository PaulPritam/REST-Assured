package com.bridgelabz.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssured {

    public String token = "";
    public static String userID = "";
    public static String playlistId = "";

    @BeforeTest
    public void setUp() {
        token = "Bearer BQCvpslyrXABonzzfDxjRlbEWb3EtygdB7_GKkmFRWXS9q0vn3jttA8ngAWcOSPe9Qh1hdtX9F0Eo-4Mgx6LLWG0tQBrKEvx" +
                "z8m5rIN4YrbPmoxyhsrGPuTRfhIO3mLcbmwr8qauxTPjLQnxbcRDncaVmZhEAh-jptLqmkOGSTssLI46G5eJAkafpKMm6HpoFPzaSoX" +
                "NlUlx-PEb1iUG-KiCWCNdiiqmN4dC_dH4qjMLD9J_X3P_4O0S0Ck11_kbd4R9mviIf0TOAjaFcmlxoqyM3SCWy6HVRvdMFblIcZW6";
    }

    /*
    Gets current profile data
     */
    @Test
    public void get_Current_profile() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
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
        response.prettyPrint();
    }

    /*
    Gets information on user's playlist cover image
     */
    @Test
    public void get_CurrentUsersPlaylistCoverImage() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/6kARld7la7IvgtyUOt1eQX/images");
        response.prettyPrint();
    }
}

