package com.evkost.weatherapp.ui.feature.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.evkost.weatherapp.databinding.FragmentWelcomeBinding;

public class StaticWelcomePagerFragment extends Fragment {
    private static final String FRAGMENT_LAYOUT_ID_KEY = "layoutId";
    public static StaticWelcomePagerFragment newInstance(@IdRes int layoutId) {
        Bundle args = new Bundle();
        args.putInt(FRAGMENT_LAYOUT_ID_KEY, layoutId);

        StaticWelcomePagerFragment fragment = new StaticWelcomePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = getArguments().getInt(FRAGMENT_LAYOUT_ID_KEY);
        return inflater.inflate(layoutId, container, false);
    }
}
