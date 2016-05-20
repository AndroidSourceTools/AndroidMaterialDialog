/*
 * Copyright 2014 - 2016 Michael Rapp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package de.mrapp.android.dialog.model;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import de.mrapp.android.dialog.WizardDialog.TabPosition;

/**
 * Defines the interface a decorator, which allows to modify the view hierary of a dialog, which is
 * designed according to Android 5's Material Design guidelines even on pre-Lollipop devices and
 * provides a navigation for switching between multiple fragments, must implement.
 *
 * @author Michael Rapp
 * @since 3.2.0
 */
public interface WizardDialogDecorator {

    /**
     * Returns the view pager, which is contained by the dialog.
     *
     * @return The view pager, which is contained by the dialog, as an instance of the class {@link
     * ViewPager} or null, if the dialog does not show any fragments or has not been shown yet
     */
    ViewPager getViewPager();

    /**
     * Returns the tab layout, which is contained by the dialog.
     *
     * @return The tab layout, which is contained by the dialog, as an instance of the class {@link
     * TabLayout} or null, if the dialog does not show any fragments or has not been shown yet
     */
    TabLayout getTabLayout();

    /**
     * Adds a new fragment to the dialog.
     *
     * @param fragmentClass
     *         The class of the fragment, which should be added, as an instance of the class {@link
     *         Class}. The class may not be null
     */
    void addFragment(@NonNull Class<? extends Fragment> fragmentClass);

    /**
     * Adds a new fragment to the dialog.
     *
     * @param fragmentClass
     *         The class of the fragment, which should be added, as an instance of the class {@link
     *         Class}. The class may not be null
     * @param arguments
     *         A bundle, which should be passed to the fragment, when it is shown, as an instance of
     *         the class {@link Bundle} or null, if no arguments should be passed to the fragment
     */
    void addFragment(@NonNull Class<? extends Fragment> fragmentClass, @Nullable Bundle arguments);

    /**
     * Adds a new fragment to the dialog.
     *
     * @param resourceId
     *         The resource id of the title of the fragment, which should be added, as an {@link
     *         Integer}  value. The resource id must correspond to a valid string resource
     * @param fragmentClass
     *         The class of the fragment, which should be added, as an instance of the class {@link
     *         Class}. The class may not be null
     */
    void addFragment(@StringRes int resourceId, @NonNull Class<? extends Fragment> fragmentClass);

    /**
     * Adds a new fragment to the dialog.
     *
     * @param resourceId
     *         The resource id of the title of the fragment, which should be added, as an {@link
     *         Integer}  value. The resource id must correspond to a valid string resource
     * @param fragmentClass
     *         The class of the fragment, which should be added, as an instance of the class {@link
     *         Class}. The class may not be null
     * @param arguments
     *         A bundle, which should be passed to the fragment, when it is shown, as an instance of
     *         the class {@link Bundle} or null, if no arguments should be passed to the fragment
     */
    void addFragment(@StringRes int resourceId, @NonNull Class<? extends Fragment> fragmentClass,
                     @Nullable Bundle arguments);

    /**
     * Adds a new fragment to the dialog.
     *
     * @param title
     *         The title of the fragment, which should be added, as an instance of the type {@link
     *         CharSequence} or null, if no title should be set
     * @param fragmentClass
     *         The class of the fragment, which should be added, as an instance of the class {@link
     *         Class}. The class may not be null
     */
    void addFragment(@Nullable CharSequence title,
                     @NonNull Class<? extends Fragment> fragmentClass);

    /**
     * Adds a new fragment to the dialog.
     *
     * @param title
     *         The title of the fragment, which should be added, as an instance of the type {@link
     *         CharSequence} or null, if no title should be set
     * @param fragmentClass
     *         The class of the fragment, which should be added, as an instance of the class {@link
     *         Class}. The class may not be null
     * @param arguments
     *         A bundle, which should be passed to the fragment, when it is shown, as an instance of
     *         the class {@link Bundle} or null, if no arguments should be passed to the fragment
     */
    void addFragment(@Nullable CharSequence title, @NonNull Class<? extends Fragment> fragmentClass,
                     @Nullable Bundle arguments);

    /**
     * Removes the fragment at a specific index from the dialog>.
     *
     * @param index
     *         The index of the fragment, which should be removed, as an {@link Integer value}
     */
    void removeFragment(int index);

    /**
     * Removes all fragments from the dialog.
     */
    void clearFragments();

    /**
     * Returns the index of a specific fragment.
     *
     * @param fragmentClass
     *         The class of the fragment, whose index should be returned, as an instance of the
     *         class {@link Class}. The class may not be null
     * @return The index of the given fragment as an {@link Integer} value or -1, if the adapter
     * does not contain the given fragment
     */
    int indexOfFragment(@NonNull Class<? extends Fragment> fragmentClass);

    /**
     * Returns the number of fragments, which are contained by the dialog.
     *
     * @return The number of fragments, which are contained by the dialog, as an {@link Integer}
     * value
     */
    int getFragmentCount();

    /**
     * Returns the position of the tabs, which indicate the currently shown fragment.
     *
     * @return The position of the tabs, which indicate the currently shown fragment, as a value of
     * the enum {@link TabPosition}
     */
    TabPosition getTabPosition();

    /**
     * Sets the position of the tabs, which indicate the currently shown fragment.
     *
     * @param tabPosition
     *         The position, which should be set, as a value of the enum {@link TabPosition}. The
     *         position may either be <code>USE_HEADER</code>, <code>PREFER_HEADER</code> or
     *         <code>NO_HEADER</code>
     */
    void setTabPosition(@NonNull TabPosition tabPosition);

    /**
     * Returns, whether the tabs, which indicate the currently shown fragment, are enabled, or not.
     *
     * @return True, if the tabs, which indicate the currently shown fragment, are enabled, false
     * otherwise
     */
    boolean isTabLayoutEnabled();

    /**
     * Enables or disables the tabs, which indicate the currently shown fragment. When the tabs are
     * enabled, it is possible to switch between the fragments by clicking the tabs.
     *
     * @param enable
     *         True, if the tabs should be enabled, false otherwise
     */
    void enableTabLayout(boolean enable);

    /**
     * Returns, whether the tabs, which indicate the currently shown fragment, are shown, or not.
     *
     * @return True, if the tabs, which indicate the currently shown fragment, are shown, false
     * otherwise
     */
    boolean isTabLayoutShown();

    /**
     * Sets, whether the tabs, which indicate the currently shown fragment, should be shown shown,
     * or not.
     *
     * @param show
     *         True, if the tabs, which indicate the currently shown fragment, should be shown,
     *         false otherwise
     */
    void showTabLayout(boolean show);

    /**
     * Returns the height of the indicator, which indicates the currently shown fragment.
     *
     * @return The height of the indicator, which indicates the currently shown fragment, in pixels
     * as an {@link Integer} value
     */
    int getTabIndicatorHeight();

    /**
     * Sets the height of the indicator, which indicates the currently shown fragment.
     *
     * @param height
     *         The height, which should be set, in pixels as an {@link Integer} value. The height
     *         must be at least 1
     */
    void setTabIndicatorHeight(int height);

    /**
     * Returns the color of the indicator, which indicates the currently shown fragment.
     *
     * @return The color of the indicator, which indicates the currently shown fragment, as an
     * {@link Integer} value
     */
    int getTabIndicatorColor();

    /**
     * Sets the color of the indicator, which indicates the currently shown fragment.
     *
     * @param color
     *         The color, which should be set, as an {@link Integer} value
     */
    void setTabIndicatorColor(@ColorInt int color);

    /**
     * Returns the text color of the tabs, which indicate the currently shown fragment.
     *
     * @return The text color of the tabs, which indicate the currently shown fragment, as an {@link
     * Integer} value
     */
    int getTabTextColor();

    /**
     * Sets the text color of the tabs, which indicates the currently shown fragment.
     *
     * @param textColor
     *         The text color, which should be set, as an {@link Integer} value
     */
    void setTabTextColor(@ColorInt int textColor);

    /**
     * Returns the selected text color of the tabs, which indicate the currently shown fragment.
     *
     * @return The selected text color of the tabs, which indicate the currently shown fragment, as
     * an {@link Integer} value
     */
    int getTabSelectedTextColor();

    /**
     * Sets the selected text color of the tabs, which indicate the currently shown fragment.
     *
     * @param selectedTextColor
     *         The selected text color, which should be set, as an {@link Integer} value
     */
    void setTabSelectedTextColor(@ColorInt int selectedTextColor);

    /**
     * Returns, whether switching fragments using swipe gestures is enabled, or not.
     *
     * @return True, if switching fragments using swipe gestures is enabled, false otherwise
     */
    boolean isSwipeEnabled();

    /**
     * Sets, whether switching fragments using swipe gestures should be enabled, or not.
     *
     * @param enable
     *         True, if switching fragments using swipe gestures should be enabled, false otherwise
     */
    void enableSwipe(boolean enable);

}