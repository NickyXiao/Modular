package modular.senble.com.modular;

import android.app.Application;
import android.util.DebugUtils;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author : Senble
 * @version 1
 * @date : 2018/8/14
 */
public class MainApplication extends Application {
    private static Application mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;
        // These two lines must be written before init,
        // otherwise these configurations will be invalid in the init process
        if (BuildConfig.DEBUG) {
            // Print log
            ARouter.openLog();
            // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode!
            // Online version needs to be closed, otherwise there is a security risk)
            ARouter.openDebug();
        }
        // As early as possible, it is recommended to initialize in the Application
        ARouter.init(mApplication);
    }
}
