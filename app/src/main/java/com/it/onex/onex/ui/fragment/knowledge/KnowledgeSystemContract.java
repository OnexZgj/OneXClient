package com.it.onex.onex.ui.fragment.knowledge;

import com.it.onex.onex.base.BaseContract;
import com.it.onex.onex.bean.KnowledgeSystem;

import java.util.List;

/**
 * Created by Linsa on 2018/4/12:22:39.
 * des:
 */

public class KnowledgeSystemContract {
    interface View extends BaseContract.BaseView{
        void setKnowledgeSystems(List<KnowledgeSystem> knowledgeSystems);
    }

    interface Presenter extends BaseContract.BasePresenter<KnowledgeSystemContract.View>{
        void loadKnowledgeSystems();

        void refresh();
    }

}
