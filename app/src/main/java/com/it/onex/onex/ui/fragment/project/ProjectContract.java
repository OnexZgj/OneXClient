package com.it.onex.onex.ui.fragment.project;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.Project;

import java.util.List;

/**
 * Created by Linsa on 2018/4/17:10:31.
 * des:
 */

public class ProjectContract {

    interface View extends BaseContract.BaseView {

        void setProjectNavigationData(List<Project> projects);

    }

    interface Presenter extends BaseContract.BasePresenter<ProjectContract.View> {

        void loadProjectNavigationData();

    }
}
