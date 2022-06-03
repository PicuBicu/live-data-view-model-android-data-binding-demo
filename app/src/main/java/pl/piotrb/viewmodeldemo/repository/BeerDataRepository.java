package pl.piotrb.viewmodeldemo.repository;

import pl.piotrb.viewmodeldemo.BeerViewModel;
import pl.piotrb.viewmodeldemo.model.Beer;
import pl.piotrb.viewmodeldemo.service.BeerDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeerDataRepository {

    private static BeerDataRepository INSTANCE = null;
    private final BeerDataService beerService = new retrofit2.Retrofit.Builder()
            .baseUrl("https://random-data-api.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeerDataService.class);

    public static BeerDataRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BeerDataRepository();
        }
        return INSTANCE;
    }

    public void getBeer(BeerViewModel viewModel) {
        beerService.getRandomBeerData().enqueue(new Callback<Beer>() {
            @Override
            public void onResponse(Call<Beer> call, Response<Beer> response) {
                if (response.code() == 200) {
                    viewModel.setBeerData(response.body());
                } else {
                    viewModel.setErrorMessage("Nie udało się poprawnie pobrać danych");
                }
            }

            @Override
            public void onFailure(Call<Beer> call, Throwable t) {
                viewModel.setErrorMessage("Nie udało się poprawnie pobrać danych");
            }
        });
    }
}
