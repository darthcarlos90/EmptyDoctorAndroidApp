package yourteamnumber.com.seshealthdoctor.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yourteamnumber.com.seshealthdoctor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPacketFragment extends Fragment {


    public ViewPacketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_packet, container, false);
    }

}
