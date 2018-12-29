package com.starcom.smotty;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {
    private Button q21,q22,q23,q24,q25,q26,q27,q28;

    public TwoFragment() {
        // Required empty public constructor
    }

    //    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void sendExtra(String idsoal){
//        Intent i = new Intent(getActivity(),Question.class);
//
//        i.putExtra("idsoal",idsoal);
//        startActivity(i);
    }
}
