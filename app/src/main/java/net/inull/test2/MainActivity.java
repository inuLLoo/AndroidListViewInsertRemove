package net.inull.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
  ListView listView = null;
  ArrayList<String> arrayList = null;
  ArrayAdapter<String> arrayAdapter = null;

  Button buttonInsert = null;
  Button buttonRemove = null;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // create button for insert
    buttonInsert = (Button) findViewById(R.id.buttonInsert);
    buttonInsert.setOnClickListener(onClick);
    // create button for remove
    buttonRemove = (Button) findViewById(R.id.buttonRemove);
    buttonRemove.setOnClickListener(onClick);

    // init arrayList one two  three
    arrayList = new ArrayList<String>();
    arrayList.add("One");
    arrayList.add("Two");
    arrayList.add("Three");
    arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

    // create listview
    listView = (ListView) findViewById(R.id.listview);
    listView.setAdapter(arrayAdapter);
    // set item click listener
    listView.setOnItemClickListener(onItemClick);
  }

  /**
   * item click listener
   */
  public AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener()
  {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
      Log.d("DEBUG", "item click");
    }
  };

  /**
   * view click listener
   */
  public final View.OnClickListener onClick = new View.OnClickListener()
  {
    @Override
    public void onClick(View view)
    {
      switch (view.getId())
      {
        // insert item
        case R.id.buttonInsert:
          arrayList.add("four");
          arrayAdapter.notifyDataSetChanged();
          break;

        // remove item
        case R.id.buttonRemove:
          arrayList.remove(2);
          arrayAdapter.notifyDataSetChanged();
          break;

        default:
      }
    }
  };

}