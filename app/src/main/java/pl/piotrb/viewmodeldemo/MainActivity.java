package pl.piotrb.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import pl.piotrb.viewmodeldemo.databinding.ActivityMainBinding;
import pl.piotrb.viewmodeldemo.repository.BeerDataRepository;

public class MainActivity extends AppCompatActivity {

    private final BeerDataRepository repository = BeerDataRepository.getInstance();
    private Button fetchDataButton;
    private BeerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        fetchDataButton = findViewById(R.id.fetch_data);
        viewModel = new ViewModelProvider(this)
                .get(BeerViewModel.class);
        fetchDataButton.setOnClickListener(item -> {
            repository.getBeer(viewModel);
        });
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
        onBeerModelFetchError();
    }

    public void onBeerModelFetchError() {
        viewModel.getErrorMessage().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG);
        });
    }

}