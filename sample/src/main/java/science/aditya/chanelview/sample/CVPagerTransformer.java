package science.aditya.chanelview.sample;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class CVPagerTransformer implements ViewPager.PageTransformer {

//    private float pagerDrawOffset;

//    public CVPagerTransformer(float pagerDrawOffset) {
//        this.pagerDrawOffset = pagerDrawOffset;
//    }

    @Override
    public void transformPage(@NonNull View page, float position) {
//        float absPosition = Math.abs(position - pagerDrawOffset);
        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 1) {
            page.setAlpha(1);
            page.setTranslationX(page.getWidth() * -position);
            float yPosition = position * page.getHeight();
            page.setTranslationY(yPosition);
        } else {
            page.setAlpha(0);
        }
    }

}
