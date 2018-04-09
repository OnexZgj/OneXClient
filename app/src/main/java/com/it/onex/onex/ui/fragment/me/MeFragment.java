package com.it.onex.onex.ui.fragment.me;

import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.it.onex.onex.R;
import com.it.onex.onex.base.BaseFragment;
import com.it.onex.onex.bean.User;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by OnexZgj on 2018/4/2:22:08.
 * des:
 */

public class MeFragment extends BaseFragment<MePresenterImp> implements MeContract.View {


    @BindView(R.id.etUsername)
    TextInputEditText etUsername;
    @BindView(R.id.etPassword)
    TextInputEditText etPassword;
    @BindView(R.id.btn_fm_login)
    Button btnFmLogin;
    Unbinder unbinder;

    public static MeFragment getInstance() {
        return new MeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initInjector() {
        mFragmentComponent.inject(this);
    }

    @Override
    protected void initView(View view) {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_fm_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fm_login:

                String passWord = etPassword.getText().toString();
                String userName = etUsername.getText().toString();

                if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(passWord)){
                    ToastUtils.showShort(R.string.the_username_or_password_can_not_be_empty);
                    return;
                }

                mPresenter.login(userName,passWord);

                break;
        }
    }

    @Override
    public void loginSuccess(User user) {
        ToastUtils.showShort("user:" +user.getUsername() + "login success !");
    }
}
