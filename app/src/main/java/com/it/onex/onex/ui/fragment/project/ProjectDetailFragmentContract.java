package com.it.onex.onex.ui.fragment.project;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.ProjectDetail;

/**
 * Created by Linsa on 2018/4/16:11:35.
 * des:
 */

public class ProjectDetailFragmentContract {
    interface View extends BaseContract.BaseView{
        void setProjectData(ProjectDetail projectDetail, int loadType);
    }

    interface Presenter extends BaseContract.BasePresenter<ProjectDetailFragmentContract.View>{
        void loadProjectInfoData(int cid);

        void refresh();

        void loadMore();
    }
}
