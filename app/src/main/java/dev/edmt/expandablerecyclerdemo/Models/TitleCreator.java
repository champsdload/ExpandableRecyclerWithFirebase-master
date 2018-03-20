package dev.edmt.expandablerecyclerdemo.Models;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Satyam on /03/2018.
 */

public class TitleCreator {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;


    public static TitleCreator _titleCreator;
    List<TitleParent> _titleParents;


    public  TitleCreator(Context context) {
        _titleParents = new ArrayList<>();


        for(int i=1;i<=5;i++)
        {

            TitleParent title = new TitleParent(String.format("News Headlines #%d",i));
            _titleParents.add(title);// This thing is done by Firebase
        }

        //This is the code i have tried
       /* myRef = database.getReference("bhai") ;
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name=dataSnapshot.getValue().toString();
                TitleParent title = new TitleParent(name);
                _titleParents.add(title);
                Log.v("data",name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); */
    }

    public static TitleCreator get(Context context)
    {
        if(_titleCreator == null)
            _titleCreator = new TitleCreator(context);
        return _titleCreator;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
