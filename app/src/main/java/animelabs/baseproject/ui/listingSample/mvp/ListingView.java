/*
 * *
 *  * Created by Asheesh Sharma on 13/2/19 4:27 PM
 *  * Copyright (c) 1st January 2019 . All rights reserved.
 *
 */

package animelabs.baseproject.ui.listingSample.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import animelabs.baseproject.R;
import animelabs.baseproject.ui.base.activities.views.BaseDaggerView;
import animelabs.baseproject.ui.base.activities.views.IBaseDaggerView;
import animelabs.baseproject.ui.base.listeners.EndlessRecyclerViewScrollListener;
import animelabs.baseproject.ui.listingSample.PaginatedListSampleActivity;
import animelabs.baseproject.ui.listingSample.adapters.PaginatedListingAdapter;
import butterknife.BindView;

public class ListingView extends BaseDaggerView implements IBaseDaggerView{
    @BindView(R.id.list_sample)
    RecyclerView recyclerView;

    ListingPresenter mListingPresenter;
    public  ListingView(PaginatedListSampleActivity activity, int layoutId) {
        super(activity, layoutId);

    }

    @Override
    public void initActions() {
        super.initActions();
        PaginatedListingAdapter restaurantsListAdapter = new PaginatedListingAdapter(mContext);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(restaurantsListAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

            }
        });
    }

    public void setPresenter(ListingPresenter listingPresenter) {
        this.mListingPresenter = listingPresenter;
    }
}
