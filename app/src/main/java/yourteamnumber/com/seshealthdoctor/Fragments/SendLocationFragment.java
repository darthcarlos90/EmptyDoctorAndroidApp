package yourteamnumber.com.seshealthdoctor.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import yourteamnumber.com.seshealthdoctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SendLocationFragment extends Fragment {


    public SendLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
