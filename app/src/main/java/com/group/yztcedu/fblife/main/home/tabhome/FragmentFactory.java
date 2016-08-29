package com.group.yztcedu.fblife.main.home.tabhome;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.group.yztcedu.fblife.main.home.tabatlas.TabAtlasFragment;
import com.group.yztcedu.fblife.main.home.tabnewcar.TabNewCarFragment;

public class FragmentFactory {
    public static SparseArray<Fragment> fragments = new SparseArray<>();
    private static final int TAB_HOME = 0;
    private static final int TAB_NEWCAR = 1;
    private static final int TAB_GUIDE = 2;
    private static final int TAB_DRIVE= 3;
    private static final int TAB_ATLAS = 4;
    private static final int TAB_DEPRECIATE = 5;
    private static final int TAB_CULTURE = 6;
    private static final int TAB_RESTYLE = 7;
    private static final int TAB_TOUR = 8;
    private static final int TAB_NEWS = 9;
    private static final int TAB_RV = 10;
    private static final int TAB_TIEQI = 11;
    private static final int TAB_EVENT = 12;
    private static final int TAB_USE = 13;
    private static final int TAB_SPORTS = 14;

    public static Fragment createFragment(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment == null) {
            switch (position) {
                case TAB_HOME:
                    fragment = new TabHomeFragment();
                    break;
                case TAB_NEWCAR:
                case TAB_GUIDE:
                case TAB_DRIVE:
                case TAB_DEPRECIATE:
                case TAB_CULTURE:
                case TAB_RESTYLE:
                case TAB_TOUR:
                case TAB_NEWS:
                case TAB_RV:
                case TAB_TIEQI:
                case TAB_EVENT:
                case TAB_USE:
                case TAB_SPORTS:
                    fragment = new TabNewCarFragment();
                    break;
                case TAB_ATLAS:
                    fragment = new TabAtlasFragment();
                    break;
            }
            fragments.put(position,fragment);
        }
        return fragment;
    }
}
