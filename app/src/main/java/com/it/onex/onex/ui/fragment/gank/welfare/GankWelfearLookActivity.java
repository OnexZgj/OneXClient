package com.it.onex.onex.ui.fragment.gank.welfare;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Linsa on 2018/8/29:19:42.
 * des:
 */
@Route(path = "/gank/GankWelfearLookActivity")
public class GankWelfearLookActivity extends BaseActivity {
    @BindView(R.id.photo_view)
    PhotoView photoView;


    @Autowired
    public String url;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_gank_welfear_look;
    }

    @Override
    protected void initInjector() {
        ARouter.getInstance().inject(this);
    }

    @Override
    protected void initView() {

        Glide.with(this).load(url)
                .into(photoView);
    }

}
