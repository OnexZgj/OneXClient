package com.it.onex.onex.ui.fragment.hot;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.it.onex.onex.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by lw on 2018/1/23.
 */

public class HotAdapter<T> extends TagAdapter<T> {
    private Context mContext;
    private LayoutInflater mInflater;

    public HotAdapter(Context context, List<T> datas) {
        super(datas);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View getView(FlowLayout parent, int position, T item) {
        View view = mInflater.inflate(R.layout.item_hot, parent, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        int parseColor = 0;
        try {
            String name = "";
            Field[] fields = item.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals("name")) {
                    name = (String) field.get(item);
                    break;
                }
            }
            tvTitle.setText(name);
            String str = Integer.toHexString((int) (Math.random() * 16777215));
            parseColor = Color.parseColor("#".concat(str));
            tvTitle.setTextColor(parseColor);
        } catch (Exception e) {
            e.printStackTrace();
            parseColor = mContext.getResources().getColor(R.color.colorAccent);
        }
        tvTitle.setTextColor(parseColor);
        return view;
    }
}
