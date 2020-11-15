package com.acasema.wikiweeb.iu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.WikiWeebAplication;

/**
 * es una prueva para ver como de ve un unario y como es usuario tiene un user estatico
 */
public class ViewUserFragment extends Fragment {

    private TextView tvUser;

    public ViewUserFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_user, container, false);

        tvUser = v.findViewById(R.id.tvUser);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUser.setText(((WikiWeebAplication) getActivity().getApplication()).getUser().getUser());
    }
}