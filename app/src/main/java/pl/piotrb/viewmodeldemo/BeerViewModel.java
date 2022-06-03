package pl.piotrb.viewmodeldemo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.piotrb.viewmodeldemo.model.Beer;

public class BeerViewModel extends ViewModel {

    MutableLiveData<Beer> beerData = new MutableLiveData<>();
    MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public LiveData<Beer> getBeerData() {
        return beerData;
    }

    public void setBeerData(Beer beerData) {
        this.beerData.setValue(beerData);
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage.setValue(errorMessage);
    }


}
