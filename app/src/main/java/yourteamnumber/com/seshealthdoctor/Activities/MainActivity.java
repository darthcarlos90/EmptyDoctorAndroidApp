package yourteamnumber.com.seshealthdoctor.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import yourteamnumber.com.seshealthdoctor.Fragments.HomeFragment;
import yourteamnumber.com.seshealthdoctor.Fragments.PairPatientFragment;
import yourteamnumber.com.seshealthdoctor.Fragments.ReceiveDataFragment;
import yourteamnumber.com.seshealthdoctor.Fragments.SendFeedbackFragment;
import yourteamnumber.com.seshealthdoctor.Fragments.SendLocationFragment;
import yourteamnumber.com.seshealthdoctor.Fragments.ViewPacketFragment;
import yourteamnumber.com.seshealthdoctor.R;


/**
 * Class: MainActivity
 * Extends:  {@link AppCompatActivity}
 * Author:  Carlos Tirado < Carlos.TiradoCorts@uts.edu.au>, and YOU!
 * Description:
 * <p>
 * This is an exact copy of the functionality of the other project's main activity, with
 * some changes.
 */
public class MainActivity extends AppCompatActivity {


    /**
     * A basic Drawer layout that helps you build the side menu. I followed the steps on how to
     * build a menu from this site:
     * https://developer.android.com/training/implementing-navigation/nav-drawer
     * I recommend you to have a read of it if you need to do any changes to the code.
     */
    private DrawerLayout mDrawerLayout;

    /**
     * A reference to the toolbar
     */
    private Toolbar toolbar;

    /**
     * Helps to manage the fragment that is being used in the main view.
     */
    private FragmentManager fragmentManager;

    /**
     * TAG to use
     */
    private static String TAG = "MainActivity";


    private enum MenuStates {
        PAIR_PATIENT, RECEIVE_DATA, VIEW_PACKETS, SEND_FEEDBACK, SEND_LOCATIONS, HOME_PAGE
    }

    private MenuStates currentState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the default fragment on display is the patient information
        currentState = MenuStates.HOME_PAGE;

        // go look for the main drawer layout
        mDrawerLayout = findViewById(R.id.main_drawer_layout);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Set up the menu button
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        // Setup the navigation drawer, most of this code was taken from:
        // https://developer.android.com/training/implementing-navigation/nav-drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Using a switch to see which item on the menu was clicked
                        switch (menuItem.getItemId()) {
                            // You can find these id's at: res -> menu -> drawer_view.xml
                            case R.id.home_button:
                                if (currentState != MenuStates.HOME_PAGE) {
                                    ChangeFragment(new HomeFragment());
                                    currentState = MenuStates.HOME_PAGE;
                                }
                                break;
                            case R.id.npair_patient_nav:
                                if (currentState != MenuStates.PAIR_PATIENT) {
                                    ChangeFragment(new PairPatientFragment());
                                    currentState = MenuStates.PAIR_PATIENT;
                                }
                                break;
                            case R.id.receive_datanav:
                                if (currentState != MenuStates.RECEIVE_DATA) {
                                    ChangeFragment(new ReceiveDataFragment());
                                    currentState = MenuStates.RECEIVE_DATA;
                                }
                                break;
                            case R.id.view_packet_nav:
                                if (currentState != MenuStates.VIEW_PACKETS) {
                                    ChangeFragment(new ViewPacketFragment());
                                    currentState = MenuStates.VIEW_PACKETS;
                                }
                                break;
                            case R.id.send_feedback_nav:
                                if (currentState != MenuStates.SEND_FEEDBACK) {
                                    ChangeFragment(new SendFeedbackFragment());
                                    currentState = MenuStates.SEND_FEEDBACK;
                                }
                                break;
                            case R.id.send_location_nav:
                                if (currentState != MenuStates.SEND_LOCATIONS) {
                                    ChangeFragment(new SendLocationFragment());
                                    currentState = MenuStates.SEND_LOCATIONS;
                                }
                                break;
                        }
                        return true;
                    }
                });


        // If you need to listen to specific events from the drawer layout.
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );


        // More on this code, check the tutorial at http://www.vogella.com/tutorials/AndroidFragments/article.html
        fragmentManager = getFragmentManager();

        // Add the default Fragment once the user logged in
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, new HomeFragment());
        ft.commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * This function changes the title of the fragment.
     *
     * @param newTitle The new title to write in the
     */
    public void ChangeTitle(String newTitle) {
        toolbar.setTitle(newTitle);
    }


    /**
     * This function allows to change the content of the Fragment holder
     *
     * @param fragment The fragment to be displayed
     */
    private void ChangeFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
