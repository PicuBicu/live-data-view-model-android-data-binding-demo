package pl.piotrb.viewmodeldemo.service;

import pl.piotrb.viewmodeldemo.model.Beer;
import retrofit2.Call;
import retrofit2.http.GET;

// Retrofit interface for fetching random beer data from endpoint with example data api
public interface BeerDataService {
    @GET("/api/beer/random_beer")
    Call<Beer> getRandomBeerData();
}
