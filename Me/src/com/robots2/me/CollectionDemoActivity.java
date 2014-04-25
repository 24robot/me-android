/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.robots2.me;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CollectionDemoActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments representing
     * each object in a collection. We use a {@link android.support.v4.app.FragmentStatePagerAdapter}
     * derivative, which will destroy and re-create fragments as needed, saving and restoring their
     * state in the process. This is important to conserve memory and is a best practice when
     * allowing navigation between objects in a potentially large collection.
     */
    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;

    /**
     * The {@link android.support.v4.view.ViewPager} that will display the object collection.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_demo);

        // Create an adapter that when requested, will return a fragment representing an object in
        // the collection.
        // 
        // ViewPager and its adapters use support library fragments, so we must use
        // getSupportFragmentManager.
        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager, attaching the adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
    }

    /**
     * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
     * representing an object in the collection.
     */
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
            args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1); // Our object is just an integer :-P
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            // For this contrived example, we have a 100-object collection.
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

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
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
    
    public static class FacebookObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            rootView.setBackgroundColor(Color.argb(255, 59, 85, 159));
            TextView tv = (TextView) rootView.findViewById(android.R.id.text1);
            tv.setText("Facebook");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.facebook_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF3B559F, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class TwitterObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            rootView.setBackgroundColor(Color.argb(255, 0, 171, 240));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("Twitter");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.twitter_logo);
           
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF00ABF0, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class GithubObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);

            rootView.setBackgroundColor(Color.argb(255, 0, 0, 0));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("Github");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.github_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF202020, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class PinterestObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);

            rootView.setBackgroundColor(Color.argb(255, 203, 32, 39));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("Pinterest");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.pinterest_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFFCB2027, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class WordPressObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);

            rootView.setBackgroundColor(Color.argb(255, 30, 140, 190));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("WordPress");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.wordpress_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF1E8CBE, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class TumblrObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            
            rootView.setBackgroundColor(Color.argb(255, 50, 79, 109));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("Tumblr");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.tumblr_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF324F6D, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class LinkedInObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            
            rootView.setBackgroundColor(Color.argb(255, 2, 116, 179));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("LinkedIn");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.linkedin_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF0274B3, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class GooglePlusObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);

            rootView.setBackgroundColor(Color.argb(255, 221, 76, 57));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("Google+");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.googleplus_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFFDD4C39, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
    
    public static class InstagramObjectFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);

            rootView.setBackgroundColor(Color.argb(255, 71, 117, 155));
            TextView tv = ((TextView) rootView.findViewById(android.R.id.text1));
            tv.setText("Instagram");
            tv.setTextColor(Color.WHITE);
            
            ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
            logo.setImageResource(R.drawable.instagram_logo);
            
            Button loginButton = (Button) rootView.findViewById(R.id.loginButton);
            loginButton.getBackground().setColorFilter(0xFF47759B, PorterDuff.Mode.MULTIPLY);
            
            return rootView;
        }
    }
}
