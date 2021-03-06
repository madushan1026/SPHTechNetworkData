package com.kasundesilva.sphtechnetworkdata;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UsageListTest {

    private static final String FIRST_ITEM_YEAR = "2008";
    private static final String LAST_ITEM_YEAR = "2018";
    private static final int ITEM_WITH_IMGE_BUTTON = 3;
    RecyclerView usageRecyclerView;

    @Rule
    public ActivityTestRule<DataUsageInfoActivity> mActivityTestRule = new ActivityTestRule<>(DataUsageInfoActivity.class);

    // open activity before testing
    @Before
    public void launchActivity() {
        ActivityScenario.launch(DataUsageInfoActivity.class);
    }

    @Before
    public void initTest() {
        usageRecyclerView = mActivityTestRule.getActivity().findViewById(R.id.data_info_recycler_view);
    }

    // check for last usge item is there

    @Test
    public void dataFilterTestFirstEntry() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withRecyclerView(R.id.data_info_recycler_view).atPosition(0))
                .check(matches(hasDescendant(withText(FIRST_ITEM_YEAR))));
    }

    @Test
    public void dataFilterTestLastEntry() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // scroll to the bottom
        onView(withId(R.id.data_info_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(usageRecyclerView.getAdapter().getItemCount() - 1));

        onView(withRecyclerView(R.id.data_info_recycler_view).atPosition(usageRecyclerView.getAdapter().getItemCount() - 1))
                .check(matches(hasDescendant(withText(LAST_ITEM_YEAR))));

    }

    @Test
    public void imageButtonTest() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withRecyclerView(R.id.data_info_recycler_view).atPositionOnView(ITEM_WITH_IMGE_BUTTON, R.id.down_trend_imagebutton)).perform(click());
        onView(withText("Usage Trends")).check(matches(isDisplayed()));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }


}
