package yourteamnumber.com.seshealthdoctor.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import yourteamnumber.com.seshealthdoctor.R;

/**
 * Class: HomeFragment
 * Extends:  {@link Fragment}
 * Author:  Carlos Tirado < Carlos.TiradoCorts@uts.edu.au>, and YOU!
 * Description:
 *  A simple home fragment to display to the user. Be creative for this fragment.
 * <p>
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.welcome_message)
    TextView welcomeMessage;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        welcomeMessage.setText("Welcome to the application");
    }
}
