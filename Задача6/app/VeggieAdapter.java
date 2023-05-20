import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VeggieAdapter extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        // Add initial items to the itemList if needed

        adapter = new ItemAdapter(itemList, this);
        recyclerView.setAdapter(adapter);

        // Example code to add a new item
        addItemToList("New Item");
    }

    private void addItemToList(String item) {
        itemList.add(item);
        adapter.notifyItemInserted(itemList.size() - 1);
    }
}