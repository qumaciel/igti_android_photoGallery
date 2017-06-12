package br.com.igti.android.photogallery;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by maciel on 11/15/14.
 */
public abstract class SingleFragmentActivity extends Activity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.container);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, (fragment == null) ? createFragment() : fragment)
                    .commit();
        }
    }
}
