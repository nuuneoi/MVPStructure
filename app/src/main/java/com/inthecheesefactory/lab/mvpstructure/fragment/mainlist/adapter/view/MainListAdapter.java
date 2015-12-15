package com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inthecheesefactory.lab.mvpstructure.R;
import com.inthecheesefactory.lab.mvpstructure.dao.DessertItemCollectionDao;
import com.inthecheesefactory.lab.mvpstructure.fragment.mainlist.adapter.presenter.IMainListAdapterPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nuuneoi on 12/15/2015.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> implements IMainListAdapterView {

    private DessertItemCollectionDao dao;

    public MainListAdapter() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(dao.getData().get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (dao == null)
            return 0;
        if (dao.getData() == null)
            return 0;
        return dao.getData().size();
    }

    @Override
    public void showDessertList(DessertItemCollectionDao dao) {
        this.dao = dao;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tvName)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
