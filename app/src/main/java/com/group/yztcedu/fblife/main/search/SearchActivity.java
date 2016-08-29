package com.group.yztcedu.fblife.main.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.group.yztcedu.fblife.R;
import com.group.yztcedu.fblife.main.search.URL.UrlString;
import com.group.yztcedu.fblife.main.search.bean.Searchinfobean;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

public class SearchActivity extends SwipeBackActivity implements SearchContract.View {

    private static final String TAG = "SearchActivity";
    public SearchContract.Model model;
    public SearchPresenter searchPresenter;
    public HashMap<String, String> map;
    @BindView(R.id.ptrlv_search)
    PullToRefreshListView ptrlvSearch;
    @BindView(R.id.search_rb_imformation)
    RadioButton searchRbImformation;
    @BindView(R.id.search_rb_forum)
    RadioButton searchRbForum;
    @BindView(R.id.search_rb_user)
    RadioButton searchRbUser;
    @BindView(R.id.editText_search)
    EditText editTextSearch;
    private Context context = this;
    private String name = null;
    private SearchAdapter searchAdapter;
    private List<Searchinfobean> list;
    private int page = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        model = new SearchModel();
        searchPresenter = new SearchPresenter(model, this);
        searchRbImformation.setChecked(true);
        list = new ArrayList<>();
        searchAdapter = new SearchAdapter(context, list);
        ptrlvSearch.setAdapter(searchAdapter);
        initPullToRefreshListView();
        initEditText();

    }

    private void initPullToRefreshListView() {
        ptrlvSearch.setMode(PullToRefreshBase.Mode.BOTH);
        ptrlvSearch.setOnPullEventListener(new PullToRefreshBase.OnPullEventListener<ListView>() {
            @Override
            public void onPullEvent(PullToRefreshBase<ListView> refreshView, PullToRefreshBase.State state, PullToRefreshBase.Mode direction) {
                if (state.equals(PullToRefreshBase.State.PULL_TO_REFRESH)) {
                    ILoadingLayout loadingLayoutProxy = ptrlvSearch.getLoadingLayoutProxy(true, false);
                    loadingLayoutProxy.setRefreshingLabel("刷新中");
                    loadingLayoutProxy.setReleaseLabel("刷新完成");
                    String time = DateUtils.formatDateTime(context, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME);
                    loadingLayoutProxy.setLastUpdatedLabel(time);

                }
            }
        });
        ptrlvSearch.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                initLoadData(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                page++;
                initLoadData(page);
            }
        });
    }

    private void initLoadData(int page) {
        if (searchRbUser.isChecked()) {
            searchPresenter.initSearchUserData(initParams(page));
        } else {
            searchPresenter.initSearchData(initParams(page));
        }

    }


    private HashMap<String, String> initParams(final int page) {

        map = new HashMap<>();
        if (searchRbUser.isChecked()) {
            map.put(UrlString.Key.MOD, UrlString.Value.MOD_VALUE);
            map.put(UrlString.Key.CODE, UrlString.Value.CODE_VALUE);
            map.put(UrlString.Key.FROMTYPE, UrlString.Value.FROMTYPE_USER_VALUE);
            map.put(UrlString.Key.FBTYPE, UrlString.Value.FORMATTYPE_VALUE);
            map.put(UrlString.Key.PAGESIZE, UrlString.Value.PAGESIZE_VALUE);
            map.put(UrlString.Key.PAGE, page+"");
            map.put(UrlString.Key.USERNAME, name);
        } else {
            if (searchRbImformation.isChecked()) {
                map.put(UrlString.Key.FROMTYPE, UrlString.Value.FROMTYPE_VALUE);
            }
            if (searchRbForum.isChecked()) {
                map.put(UrlString.Key.FROMTYPE, UrlString.Value.FROMTYPE_FORUM_VALUE);
            }
            map.put(UrlString.Key.PAGESIZE, UrlString.Value.PAGESIZE_VALUE);
            map.put(UrlString.Key.FORMATTYPE, UrlString.Value.FORMATTYPE_VALUE);
            map.put(UrlString.Key.CHARSET, UrlString.Value.CHARSET_VALUE);
            map.put(UrlString.Key.PAGE, page+"");
            map.put(UrlString.Key.QUERY, name);
        }
        searchAdapter.notifyDataSetChanged();
        return map;
    }

    private void initEditText() {

        if (TextUtils.isEmpty(editTextSearch.getText().toString())){
            Toast.makeText(SearchActivity.this, "数据不能为空", Toast.LENGTH_SHORT).show();
        }else {
            name = editTextSearch.getText().toString();
        }
        editTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (TextUtils.isEmpty(editTextSearch.getText().toString())){
                    Toast.makeText(SearchActivity.this, "数据不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    name = editTextSearch.getText().toString();
                    initLoadData(page);
                }

                return true;
            }
        });
    }


    @Override
    public void onSuccessGetInformation(List<Searchinfobean> list) {
        Log.i(TAG, "---onSuccessGetInformation: " + list);

        if (page == 1) {
            searchAdapter.addAll(list, true);
        }
        searchAdapter.addAll(list, false);

        searchAdapter.notifyDataSetChanged();
        ptrlvSearch.onRefreshComplete();
    }

    @Override
    public void onFailGetInforamtion(String msg) {
        Toast.makeText(SearchActivity.this, "请输入查询内容", Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.search_rb_imformation, R.id.search_rb_forum, R.id.search_rb_user})
    public void onClick(View view) {
        page = 1;
        switch (view.getId()) {
            case R.id.search_rb_imformation:
                initLoadData(page);
                break;
            case R.id.search_rb_forum:
                initLoadData(page);
                break;
            case R.id.search_rb_user:
                initLoadData(page );
                break;
        }
    }


}
