package binh.app.bestgoal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoforClub extends YouTubeFailureRecoveryActivity {
	private int index, position;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerview_demo);
		AdView adView = (AdView) this.findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"DC0F1B53FF17383006FBB574CC3C7213").build();
		adView.loadAd(adRequest);

		SharedPreferences pref = getSharedPreferences("binh", MODE_PRIVATE);
		index = pref.getInt("vitri", 0);
		position = pref.getInt("gridposition", 0);
		YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
		youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
	}

	@Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider,
			YouTubePlayer player, boolean wasRestored) {
		if (!wasRestored) {
			player.cueVideo(ClubListActivity.father.get(position).get(index)
					.getVideoId());
			int b = player.getDurationMillis();
			Log.d("tag", "b is " + b);
		}
	}

	@Override
	protected YouTubePlayer.Provider getYouTubePlayerProvider() {
		return (YouTubePlayerView) findViewById(R.id.youtube_view);
	}

}
