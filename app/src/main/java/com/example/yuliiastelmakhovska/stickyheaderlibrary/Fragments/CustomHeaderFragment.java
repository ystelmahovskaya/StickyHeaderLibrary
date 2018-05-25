package com.example.yuliiastelmakhovska.stickyheaderlibrary.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.headerslibrary.HeaderDecorator;

import com.example.headerslibrary.SectionCallback;
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Adapters.NameAdapter;
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Person;
import com.example.yuliiastelmakhovska.stickyheaderlibrary.R;
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Helpers.*;

import java.util.Collections;
import java.util.List;


/**
 * Created by ystelmak on 2018-04-25.
 */

public class CustomHeaderFragment extends Fragment {
    View.OnClickListener listener;
    private List<Person> getPeople() {
        Repo personRepo = new Repo();
        List<Person> people = personRepo.getPeople();
        Collections.sort(people);
        return people;
    }
    private SectionCallback getSectionCallback(final List<Person> people) {

        return new SectionCallback() {

            @Override
            public boolean isSection(int position) {
                return position == 0
                        || (people.get(position).getLastName().charAt(0)
                        != people.get(position - 1).getLastName().charAt(0));
            }

            @Override
            public String getSectionHeader(int position) {
                return people.get(position)
                        .getLastName()
                        .subSequence(0, 1).toString();
            }

            @Override
            public String getSectionSubHeader(int position) {

return isSection(position)? position+"":null;
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        int orientation = LinearLayoutManager.VERTICAL;
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), orientation,false);
        recyclerView.setLayoutManager(layoutManager);

        final List<Person> people = getPeople();

//        HeaderDecorator sectionItemDecoration = new HeaderDecorator(R.layout.custom_header, R.id.list_item_section_text,
//                R.id.list_item_section_subtext,getResources().getDimensionPixelSize(R.dimen.recycler_test60),true,getSectionCallback(people));
        HeaderDecorator sectionItemDecoration = new HeaderDecorator(getResources().getDimensionPixelSize(R.dimen.recycler_test), 20f, true, getSectionCallback(people));
        recyclerView.addItemDecoration(sectionItemDecoration);


        recyclerView.setAdapter(new NameAdapter(getLayoutInflater(), people,  R.layout.recycler_row));
        return view;
    }

public void delete(){

}


}
