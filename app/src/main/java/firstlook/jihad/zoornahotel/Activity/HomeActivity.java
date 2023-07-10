//package firstlook.jihad.zoornahotel.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//import firstlook.jihad.zoornahotel.R;
//
//public class HomeActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
//        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.bottom_home:
//                    return true;
//                case R.id.bottom_aboutUS:
//                    startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
//                case R.id.bottom_rooms:
//                    startActivity(new Intent(getApplicationContext(), RoomActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
////                case R.id.bottom_account:
////                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
////                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
////                    finish();
////                    return true;
//            }
//            return false;
//        });
//    }
//}


package firstlook.jihad.zoornahotel.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import firstlook.jihad.zoornahotel.R;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView imageRecyclerView;
    private List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize RecyclerView and set layout manager
        imageRecyclerView = findViewById(R.id.imageRecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        imageRecyclerView.setLayoutManager(layoutManager);

        // Create image list with your image resources
        imageList = new ArrayList<>();
        imageList.add(R.drawable.image_1);
        imageList.add(R.drawable.image_2);
        imageList.add(R.drawable.image_3);
        imageList.add(R.drawable.image_4);

        // Set the images to the RecyclerView
        ImageAdapter imageAdapter = new ImageAdapter(imageList);
        imageRecyclerView.setAdapter(imageAdapter);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    return true;
                case R.id.bottom_aboutUS:
                    startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
                    finish();
                    return true;
                case R.id.bottom_rooms:
                    startActivity(new Intent(getApplicationContext(), RoomActivity.class));
                    finish();
                    return true;
            }
            return false;
        });
    }
}
