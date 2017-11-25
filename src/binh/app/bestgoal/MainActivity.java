package binh.app.bestgoal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	InterstitialAd interstitial;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		interstitial = new InterstitialAd(this);

		interstitial.setAdUnitId("ca-app-pub-4153930654681746/2856464114");
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"DC0F1B53FF17383006FBB574CC3C7213").build();

		interstitial.loadAd(adRequest);

		interstitial.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {

				if (interstitial.isLoaded()) {
					interstitial.show();
				}

			}

			@Override
			public void onAdOpened() {

			}

			@Override
			public void onAdFailedToLoad(int errorCode) {

			}
		});

		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

		TabSpec tab1 = tabHost.newTabSpec("1 Tab");
		TabSpec tab2 = tabHost.newTabSpec("2 Tab");
		TabSpec tab3 = tabHost.newTabSpec("3 Tab");

		tab1.setIndicator("League");
		tab1.setContent(new Intent(this, FootballLeagueActivity.class));

		tab2.setIndicator("Club");
		tab2.setContent(new Intent(this, FootballClubActivity.class));

		tab3.setIndicator("Player");
		tab3.setContent(new Intent(this, FootballPlayerActivity.class));

		/** Add the tabs to the TabHost to display. */
		tabHost.addTab(tab1);
		tabHost.addTab(tab2);
		tabHost.addTab(tab3);
		TabHost tabhost = getTabHost();
		for (int i = 0; i < tabhost.getTabWidget().getChildCount(); i++) {

			TextView tv = (TextView) tabhost.getTabWidget().getChildAt(i)
					.findViewById(android.R.id.title);
			tv.setTextColor(Color.parseColor("#FFFFFF"));
			Typeface tf = Typeface.createFromAsset(getAssets(),
					"pic/Roboto-Light.ttf");
			tv.setTextSize(22);
			tv.setTypeface(tf);
			tv.setAllCaps(false);
		}

	}
}