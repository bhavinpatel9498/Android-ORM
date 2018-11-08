package m.com.orm_demo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class ApplicationInit extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}