package science.aditya.chanelview.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CVPager extends ViewPager {

    public CVPager(Context context) {
        super(context);
    }

    public CVPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private MotionEvent swapXY(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();

        float newX = (event.getY() / height) * width;
        float newY = (event.getX() / width) * height;

        event.setLocation(newX, newY);
        return event;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(swapXY(event));
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = super.onInterceptHoverEvent(swapXY(event));
        swapXY(event);
        return intercepted;
    }

}
