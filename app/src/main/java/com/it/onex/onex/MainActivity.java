package com.it.onex.onex;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.it.onex.onex.base.BaseActivity;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.ui.fragment.gank.GankFragment;
import com.it.onex.onex.ui.fragment.home.HomeFragment;
import com.it.onex.onex.ui.fragment.hot.HotFragment;
import com.it.onex.onex.ui.fragment.knowledge.KnowLedgeFragment;
import com.it.onex.onex.ui.fragment.project.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    private List<BaseFragment> mFragments = new ArrayList<>();

    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;

    /**
     * 上一次的Fragment实例的索引
     */
    private int mLastFgIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initView() {
        mNavigation.setOnNavigationItemSelectedListener(this);
        getPersimmions();
        initFragment();
        switchFragment(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menuHot) {
            mToolbar.setTitle(R.string.hot_title);

            //TODO 实现热门的Fragment
            switchFragment(4);
        } else if (item.getItemId() == R.id.menuSearch) {
            ARouter.getInstance().build("/hotsearch/SearchActivity").navigation();
        }

        return super.onOptionsItemSelected(item);

    }

    private void initFragment() {
        mFragments.add(HomeFragment.getInstance());
        mFragments.add(KnowLedgeFragment.getInstance());
        mFragments.add(ProjectFragment.getInstance());
        mFragments.add(GankFragment.getInstance());
//        mFragments.add(GankWelFareFragment.getInstance());
        mFragments.add(HotFragment.getInstance());
    }


    private void switchFragment(int position) {
        if (position >= mFragments.size()) {
            return;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        BaseFragment targetFg = mFragments.get(position);

        Slide slideTransition;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Gravity.START部分机型崩溃java.lang.IllegalArgumentException: Invalid slide direction
            slideTransition = new Slide(Gravity.LEFT);
            slideTransition.setDuration(700);
            targetFg.setEnterTransition(slideTransition);
            targetFg.setExitTransition(slideTransition);
        }


        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded())
            ft.add(R.id.layout_fragment, targetFg);

        ft.show(targetFg);

        //TODO HOW AND WHY?
        ft.commitAllowingStateLoss();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navigation_home:
                mToolbar.setTitle(R.string.app_name);
                mToolbar.setVisibility(View.VISIBLE);
                switchFragment(0);
                break;
            case R.id.navigation_knowledgesystem:
                mToolbar.setTitle(R.string.knowledgesystem);
                mToolbar.setVisibility(View.VISIBLE);
                switchFragment(1);
                break;
            case R.id.navigation_navigation:
                mToolbar.setTitle(R.string.navigation);
                mToolbar.setVisibility(View.VISIBLE);
                switchFragment(2);
                break;
            case R.id.navigation_gank:
                mToolbar.setTitle(R.string.gank_io);
                mToolbar.setVisibility(View.GONE);
                switchFragment(3);
                break;
        }

        return true;
    }


    public void onClick(View view) {
        if (view instanceof TextView) {
            String title = ((TextView) view).getText().toString();
            Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
            ARouter.getInstance().build("/map/LocationActivity").navigation();
        }
    }


    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
			/*
			 * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
    }


//    @RequiresApi(api = Build.VERSION_CODES.M)
    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)){
                return true;
            }else{
                permissionsList.add(permission);
                return false;
            }

        }else{
            return true;
        }
    }

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // TODO Auto-generated method stub
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }


}
