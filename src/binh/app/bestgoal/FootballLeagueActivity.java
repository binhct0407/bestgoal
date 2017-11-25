package binh.app.bestgoal;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import binh.app.bestgoal.adapter.LeagueAdapter;

public class FootballLeagueActivity extends Activity {
	String[] name = { "UEFA Champions League", "English Premier League",
			"Spanish Primera Division", "Italian Seria A", "German Bundesliga",
			"French Ligue 1" };
	Integer[] imagelist = { R.drawable.champion, R.drawable.league_1_icon,
			R.drawable.league_3_icon, R.drawable.league_4_icon,
			R.drawable.league_2_icon, R.drawable.league_5_icon };
	ListView mlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.leagues_activity);
		AdView adView = (AdView) this.findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"DC0F1B53FF17383006FBB574CC3C7213").build();
		adView.loadAd(adRequest);
		mlist = (ListView) findViewById(R.id.league);
		LeagueAdapter adapter = new LeagueAdapter(this, name, imagelist);
		mlist.setAdapter(adapter);
		mlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				SharedPreferences pref = getSharedPreferences("binh",
						MODE_PRIVATE);
				SharedPreferences.Editor editor = pref.edit();
				editor.putInt("gridposition", arg2);
				editor.commit();
				Intent intent = new Intent(getBaseContext(),
						LeagueListActivity.class);
				startActivity(intent);
			}
		});
	}

}