package firstlook.jihad.zoornahotel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import firstlook.jihad.zoornahotel.R;
import firstlook.jihad.zoornahotel.models.Room;

public class PaymentActivity extends AppCompatActivity {
    private Button payNowButton;

    private Room selectedRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationPay);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_aboutUS:
                    startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_rooms:
                    startActivity(new Intent(getApplicationContext(), RoomActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
//                case R.id.bottom_account:
//                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    finish();
//                    return true;
            }
            return false;
        });

        // Retrieve the selected room from the intent
        selectedRoom = (Room) getIntent().getSerializableExtra("room");

        // Initialize views
        payNowButton = findViewById(R.id.payNowButton);

        // Handle pay now button click
        payNowButton.setOnClickListener(v -> processPayment());
    }

//    private void processPayment() {
//        // Perform the payment logic here
//        // You can customize this method according to your application's requirements
//        Toast.makeText(this, "Payment successful!", Toast.LENGTH_SHORT).show();
//
//        // Optionally, you can navigate to a confirmation activity or perform any additional steps
//        Intent intent = new Intent(PaymentActivity.this, ConfirmationActivity.class);
//        intent.putExtra("room", selectedRoom);
//        startActivity(intent);
//
//        finish();
//    }
private void processPayment() {
    // Perform the payment logic here
    // You can customize this method according to your application's requirements
    Toast.makeText(this, "Payment successful!", Toast.LENGTH_SHORT).show();

    // Generate the confirmation message
    String confirmationMessage = "Thank you for your payment! Your room has been booked.";

    // Create an intent to start the ConfirmationActivity
    Intent intent = new Intent(PaymentActivity.this, ConfirmationActivity.class);
    intent.putExtra("confirmationMessage", confirmationMessage);
    startActivity(intent);

    finish();
}

}
