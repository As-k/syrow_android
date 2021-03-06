package in.cioc.syrow.model;

/**
 * Created by Lincoln on 14/10/15.
 */

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import in.cioc.syrow.activity.ChatRoomActivity;
import in.cioc.syrow.helper.MyPreferenceManager;

/**
 * Created by Ravi on 13/05/15.
 */

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class
            .getSimpleName();

    private RequestQueue mRequestQueue;

    private static MyApplication mInstance;
    private static Context sContext;

    private MyPreferenceManager pref;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        sContext = getApplicationContext();
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public MyPreferenceManager getPrefManager() {
        if (pref == null) {
            pref = new MyPreferenceManager(this);
        }

        return pref;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public static Context getContext() {
        return sContext;
    }


}
