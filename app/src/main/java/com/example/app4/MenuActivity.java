package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class MenuActivity extends AppCompatActivity {
    static int level;
    private SwipePlaceHolderView mSwipeView;
    static public Context mContext;
    static TextView textLeft, textRight, textLevel;
    static int heart = 3;
    static LottieAnimationView lottieHeart1, lottieHeart2, lottieHeart3;
    static LottieAnimationView lottieFail, lottieSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();
        System.out.println(" контекст контекст контекст контекст контекст контекст контекст контекст" + mContext);

        mSwipeView.getBuilder()
                .setDisplayViewCount(1)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.swipe_in_msg_view));
        //mSwipeView.addView(new TinderCard(mContext, mSwipeView));

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_view, IntentFragment.class, null)
                .commit();

        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            mSwipeView.addView(new TinderCard(mContext, profile, mSwipeView));
        }


    }

    public void init() {
        textLeft = findViewById(R.id.textLeft);
        textRight = findViewById(R.id.textRight);
        textLevel = findViewById(R.id.textViewLevel);

        lottieHeart1 = findViewById(R.id.lottieHeart1);
        lottieHeart2 = findViewById(R.id.lottieHeart2);
        lottieHeart3 = findViewById(R.id.lottieHeart3);

        lottieFail = findViewById(R.id.lottieFail);
        lottieSuccess = findViewById(R.id.lottieSuccess);
    }

    public static void setTextInMenuActivity(Profile profile){
        textLeft.setText(profile.getTextLeft());
        textLeft.setBackgroundColor(Color.parseColor(profile.getBackgroundLeft()));
        textRight.setText(profile.getTextRight());
        textRight.setBackgroundColor(Color.parseColor(profile.getBackgroundRight()));
        if (profile.getNumber() == 5 || profile.getNumber() == 6 || profile.getNumber() == 7 || profile.getNumber() == 10 || profile.getNumber() == 11) {
            textLeft.setTextColor(Color.parseColor("#FFFFFFFF"));
            textRight.setTextColor(Color.parseColor("#FFFFFFFF"));
        }else{
            textLeft.setTextColor(Color.parseColor("#F7636262"));
            textRight.setTextColor(Color.parseColor("#F7636262"));
        }
        if(profile.getNumber()==1 || profile.getNumber()==4 || profile.getNumber()==8){
            level++;
            String levelString = String.valueOf(level);
            System.out.println(" LEVEL LEVEL LEVEL LEVEL LEVEL LEVEL LEVEL LEVEL LEVEL LEVEL " + levelString);
            textLevel.setText(levelString);
        }
    }

    public static void intentNextLevel(Context context){
        Intent intent = new Intent(context  , GameActivity.class);
        context.startActivity(intent);
    }
}