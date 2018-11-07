package science.aditya.chanelview.sample;

import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainActivity extends AppCompatActivity {

    private CVPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);

        float density = getResources().getDisplayMetrics().density;
        float pagerMargin = 40*density;

        Point screen = new Point();
        getWindowManager().getDefaultDisplay().getSize(screen);

//        float pagerDrawOffset = (pagerMargin)/(screen.x - pagerMargin);

//        CVPagerTransformer transformer = new CVPagerTransformer(pagerDrawOffset);
        CVPagerTransformer transformer = new CVPagerTransformer();
        mViewPager.setPageTransformer(false, transformer);

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    public static class PlaceholderFragment extends Fragment {

        private static final String EXTRA_POSITION = "EXTRA_POSITION";
        private static final int[] COLORS = new int[] { 0xFF33B5E5, 0xFFAA66CC, 0xFF99CC00, 0xFFFFBB33, 0xFFFF4444, 0xFFFF7777 };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final int position = getArguments().getInt(EXTRA_POSITION);
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.textView);
            textView.setText(Integer.toString(position));
            textView.setBackgroundColor(COLORS[position - 1]);
            return rootView;
        }

    }

    private static final class PageAdapter extends FragmentStatePagerAdapter {

        public PageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            final Bundle bundle = new Bundle();
            bundle.putInt(PlaceholderFragment.EXTRA_POSITION, position + 1);

            final PlaceholderFragment fragment = new PlaceholderFragment();
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public int getCount() {
            return 6;
        }

    }

}