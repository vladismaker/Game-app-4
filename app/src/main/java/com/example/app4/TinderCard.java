package com.example.app4;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

@Layout(R.layout.card_view)
public class TinderCard {
    @View(R.id.textQuestion)
    private TextView textViewQuestion;

    @View(R.id.lottieColorCard)
    private LottieAnimationView lottieColorCard;

    @View(R.id.lottieTextCard)
    private LottieAnimationView lottieTextCard;

    @View(R.id.lottieNextLevelCard)
    private LottieAnimationView lottieNextLevelCard;

    private Context mContext;
    private Profile mProfile;
    private SwipePlaceHolderView mSwipeView;
    boolean answerColor;


    public TinderCard(Context context, Profile profile, SwipePlaceHolderView swipeView) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        //Glide.with(mContext);
        randomSelectAnswer();
        textViewQuestion.setText(mProfile.getQuestion());
        MenuActivity.setTextInMenuActivity(mProfile);
        //lottieColorCard.setVisibility(android.view.View.GONE);
        System.out.println(" НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР НОМЕР  " + mProfile.getNumber());
        if (mProfile.getNumber()==4 || mProfile.getNumber()==8 || mProfile.getNumber()==12) {
            System.out.println("НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8 НОМЕР 4 ИЛИ 8");
            lottieColorCard.setVisibility(android.view.View.GONE);
            lottieNextLevelCard.setVisibility(android.view.View.VISIBLE);
        }else{
            lottieNextLevelCard.setVisibility(android.view.View.GONE);
            if(answerColor){  //Если по цвету
                lottieColorCard.setVisibility(android.view.View.VISIBLE);
                lottieTextCard.setVisibility(android.view.View.GONE);
            }else {
                lottieTextCard.setVisibility(android.view.View.VISIBLE);
                lottieColorCard.setVisibility(android.view.View.GONE);
            }
        }

    }


    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
        //mSwipeView.addView(this);
        System.out.println("ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО ВПРАВО");

        if(mProfile.getNumber()==12){
            //Вы прошли игру
            MenuActivity.level = 0;
            Intent intent = new Intent(MenuActivity.mContext, GameActivity.class);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            MenuActivity.mContext.startActivity(intent);
        }

        if(mProfile.getNumber()==1 || mProfile.getNumber()==2 || mProfile.getNumber()==3 || mProfile.getNumber()==5 || mProfile.getNumber()==6 || mProfile.getNumber()==7 || mProfile.getNumber()==9 || mProfile.getNumber()==10 || mProfile.getNumber()==11){
            checkResult("вправо");
        }
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        //mSwipeView.addView(this);
        System.out.println("ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО ВЛЕВО");
        if(mProfile.getNumber()==12){
            //Вы прошли игру
            Intent intent = new Intent(MenuActivity.mContext, ResultActivity.class);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            MenuActivity.mContext.startActivity(intent);
        }

        if(mProfile.getNumber()==1 || mProfile.getNumber()==2 || mProfile.getNumber()==3 || mProfile.getNumber()==5 || mProfile.getNumber()==6 || mProfile.getNumber()==7 || mProfile.getNumber()==9 || mProfile.getNumber()==10 || mProfile.getNumber()==11){
            checkResult("влево");
        }

    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

    public void checkResult(String result) {
        String answer;
        //Если по цвету то так, если по тексту то иначе
        if (answerColor){
            answer = mProfile.getColorAnswer();
        }else {
            answer = mProfile.getTextAnswer();
        }

        if (!answer.equals(result)){
            System.out.println(" КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ КОЛИЧЕСТВО ЖИЗНЕЙ" + MenuActivity.heart );
            MenuActivity.heart--;
            switch (MenuActivity.heart){
                case(0):
                    //Не показывать жизни
                    MenuActivity.lottieHeart1.setVisibility(android.view.View.GONE);
                    MenuActivity.lottieHeart2.setVisibility(android.view.View.GONE);
                    MenuActivity.lottieHeart3.setVisibility(android.view.View.GONE);
                    //Конец игры
                    System.out.println(" контекст контекст контекст контекст контекст контекст контекст контекст" + mContext);
                    Intent intent = new Intent(MenuActivity.mContext, ResultActivity.class);
                    intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                    MenuActivity.mContext.startActivity(intent);
                    break;
                case(1):
                    //Показать только 1 жизнь
                    MenuActivity.lottieHeart2.setVisibility(android.view.View.GONE);
                    MenuActivity.lottieHeart3.setVisibility(android.view.View.GONE);
                    break;
                case(2):
                    //Показать только 2 жизнь
                    MenuActivity.lottieHeart3.setVisibility(android.view.View.GONE);
                    break;
            }
            //Запустить lottie фэйл
            MenuActivity.lottieFail.setVisibility(android.view.View.VISIBLE);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    MenuActivity.lottieFail.setVisibility(android.view.View.GONE);
                }
            }, 1000);
        }else{
            //Запустить фрагмент почти на весь экран и показать lottie на один раз или переход на новый уровень
            MenuActivity.lottieSuccess.setVisibility(android.view.View.VISIBLE);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    MenuActivity.lottieSuccess.setVisibility(android.view.View.GONE);
                }
            }, 1000);

        }
    }

    public void randomSelectAnswer(){
        int min = 1;
        int max = 2;
        int randomNumber = (int) (Math.random() * (max + 1 - min) + min);
        //1-по цвету, 2 - по тексту
        if(randomNumber==1){
            answerColor = true;
        }
        if (randomNumber==2){
            answerColor = false;
        }
    }
}
