package com.robots2.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;

    
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_demo);

   
        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
    }

    
    public static class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

        public DemoCollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DemoObjectFragment();
            
            switch(i)
            {
            case 1:
            	fragment = new FacebookObjectFragment();
            	break;
            case 2:
            	fragment = new TwitterObjectFragment();
            	break;
            case 3:
            	fragment = new GithubObjectFragment();
            	break;
            case 4:
            	fragment = new PinterestObjectFragment();
            	break;
            case 5:
            	fragment = new WordPressObjectFragment();
            	break;
            case 6:
            	fragment = new TumblrObjectFragment();
            	break;
            case 7:
            	fragment = new LinkedInObjectFragment();
            	break;
            case 8:
            	fragment = new GooglePlusObjectFragment();
            	break;
            case 9:
            	fragment = new InstagramObjectFragment();
            	break;
            }
            
            Bundle args = new Bundle();
            args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	switch(position)
        	{
        	case 0:
        		return "Welcome";
        	case 1:
        		return "Facebook";
        	case 2:
        		return "Twitter";
        	case 3:
        		return "Github";
        	case 4:
        		return "Pinterest";
        	case 5:
        		return "WordPress";
        	case 6:
        		return "Tumblr";
        	case 7:
        		return "LinkedIn";
        	case 8:
        		return "Google+";
        	case 9:
        		return "Instagram";
        	}
            return "OBJECT " + (position + 1);
        }
    }


    public static class DemoObjectFragment extends Fragment {

        public static final String ARG_OBJECT = "object";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            //Bundle args = getArguments();
            ((TextView) rootView.findViewById(android.R.id.text1)).setText("Swipe to the right");
                    //Integer.toString(args.getInt(ARG_OBJECT)));
            return rootView;
        }
    }
}
