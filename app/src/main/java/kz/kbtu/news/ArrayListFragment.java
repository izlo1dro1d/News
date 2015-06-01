package kz.kbtu.news;


import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kaisabekov on 25.05.2015.
 */
public class ArrayListFragment extends ListFragment {
    private int mNum;
    public static int newsA;
    public static int cat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNum = getArguments().getInt("num");
        } else {
            mNum = 1;
        }

    }

    static ArrayListFragment createNewFragmentToDisplay(int num) {
        ArrayListFragment displayFragment = new ArrayListFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        displayFragment.setArguments(args);
        return displayFragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, getMyListArray()));
    }

    private String[] getMyListArray() {
        String[] returnArray = {"no lists"};
        switch (mNum) {
            case 0:
                returnArray = News.Clubs;
                break;
            case 1:
                returnArray = News.Restorans;
                break;
            case 2:
                returnArray = News.Sushi;
                break;
            case 3:
                returnArray = News.Other;
                break;
        }
        return returnArray;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), "List " + (mNum + 1) + " selected item: " + (position + 1), Toast.LENGTH_SHORT).show();
        cat=mNum;
        newsA=position;
        startActivity(new Intent(getActivity(),Details.class));
    }
}