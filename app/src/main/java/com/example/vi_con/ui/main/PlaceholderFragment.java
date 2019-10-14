package com.example.vi_con.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.vi_con.MainActivity;
import com.example.vi_con.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    public int position;

    private static final String ARG_SECTION_NUMBER = "section_number";
    private Button login_btn;
    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);



    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                position=Integer.parseInt(s);
                if(position==1)
                {
                    textView.setText("FACULTY LOGIN");
                }
                else
                {
                    textView.setText("ADMIN LOGIN");
                }
            }
        });

        login_btn=(Button)root.findViewById(R.id.login_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position==1)
                {
                    Snackbar.make(view, "Logging in as Faculty Member", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                   Intent i=new Intent(PlaceholderFragment.this.getActivity(),Navigate.class);
                   startActivity(i);
                }

                else
                {

                    Snackbar.make(view, "Logging in as Admin", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }


            }
        });


        return root;
    }

}