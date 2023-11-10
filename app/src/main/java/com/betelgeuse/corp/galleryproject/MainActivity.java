package com.betelgeuse.corp.galleryproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    Integer[] images = {
            R.drawable.bugatti, R.drawable.ferrari, R.drawable.lamborghini,
            R.drawable.koenigsegg, R.drawable.heart, R.drawable.heart3d
    };
    String[] textItem = {
            "bugatti", "ferrari", "lamborghini",
            "koenigsegg", "heart", "heart3d"
    };
    Gallery gallery;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = findViewById(R.id.galleryMy);
        imageView = findViewById(R.id.imageMy);

        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(images[position]);
                Toast.makeText(MainActivity.this, textItem[position] ,Toast.LENGTH_SHORT).show();
            }
        });

//        ViewPager vp = findViewById(R.id.pagerView);
//
//        ImagePageAdapter imagePageAdapter = new ImagePageAdapter(this);
//        vp.setAdapter(imagePageAdapter);
    }

//    public class ImagePageAdapter extends PagerAdapter {
//
//        Context context;
//        public ImagePageAdapter(Context context) {
//            this.context = context;
//        }
//
//        int[] images = {R.drawable.heart3d, R.drawable.heart, R.drawable.koenigsegg, R.drawable.bugatti, R.drawable.ferrari, R.drawable.lamborghini };
//
//        @Override
//        public int getCount() {
//            return images.length;
//        }
//
//        @Override
//        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//            return view == object;
//        }
//
//        @Override
//        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            container.removeView((View) object);
//        }
//
//        @NonNull
//        @Override
//        public Object instantiateItem(@NonNull ViewGroup container, int position) {
//            ImageView imageView = new ImageView(context);
//            imageView.setPadding(20,20,20,20);
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setImageResource(images[position]);
//            container.addView(imageView);
//            return imageView;
//        }
//    }

    class ImageAdapter extends BaseAdapter {
        private Context context;
        private int backgroundItem;

        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray array = obtainStyledAttributes(R.styleable.my_gallery);
            backgroundItem = array.getResourceId(R.styleable.my_gallery_android_galleryItemBackground, 0);
            array.recycle();
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView1 = new ImageView(context);
            imageView1.setImageResource(images[position]);
            imageView1.setLayoutParams(new Gallery.LayoutParams(500,500));
            imageView1.setBackgroundResource(backgroundItem);
            return imageView1;
        }
    }
}