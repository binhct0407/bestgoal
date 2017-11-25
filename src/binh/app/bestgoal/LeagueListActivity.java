package binh.app.bestgoal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import binh.app.bestgoal.adapter.PageAdapter;
import binh.app.bestgoal.prepare.Constant;
import binh.app.bestgoal.prepare.VideoEntry;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;

public final class LeagueListActivity extends Activity implements
		OnFullscreenListener {

	private static final int ANIMATION_DURATION_MILLIS = 300;
	private VideoListFragment listFragment;
	private VideoFragment videoFragment;
	private static int index;
	private View videoBox;
	private ArrayList<VideoEntry> championleague = new ArrayList<VideoEntry>();

	private ArrayList<VideoEntry> english = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> laliga = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> seria = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> bundesliga = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> ligue = new ArrayList<VideoEntry>();

	public static ArrayList<ArrayList<VideoEntry>> father = new ArrayList<ArrayList<VideoEntry>>();
	private static List<VideoEntry> VIDEO_LIST;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loaddata();
		SharedPreferences pref = getSharedPreferences("binh", MODE_PRIVATE);
		index = pref.getInt("gridposition", 0);
		List<VideoEntry> list = new ArrayList<VideoEntry>();
		list = father.get(index);
		VIDEO_LIST = Collections.unmodifiableList(list);
		setContentView(R.layout.video_league_list);
		AdView adView = (AdView) this.findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"DC0F1B53FF17383006FBB574CC3C7213").build();
		adView.loadAd(adRequest);
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color
				.parseColor("#ffdd4b39")));

		listFragment = (VideoListFragment) getFragmentManager()
				.findFragmentById(R.id.list_fragment);

		videoBox = findViewById(R.id.video_box);

		videoBox.setVisibility(View.INVISIBLE);

	}

	private void loaddata() {
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.championtitle[i],
					Constant.championlist[i]);
			championleague.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.EnglishTitle[i],
					Constant.Englishlist[i]);
			english.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.laligatitle[i],
					Constant.laligalist[i]);
			laliga.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.seriatitle[i],
					Constant.serialist[i]);
			seria.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.bundestitle[i],
					Constant.bundeslist[i]);
			bundesliga.add(v);
		}
		for (int i = 0; i < 7; i++) {
			VideoEntry v = new VideoEntry(Constant.liguetitle[i],
					Constant.liguelist[i]);
			ligue.add(v);
		}
		father.add(championleague);
		father.add(english);
		father.add(laliga);
		father.add(seria);
		father.add(bundesliga);
		father.add(ligue);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

	}

	@Override
	public void onFullscreen(boolean isFullscreen) {

	}

	public void onClickClose(View view) {
		listFragment.getListView().clearChoices();
		listFragment.getListView().requestLayout();
		videoFragment.pause();
		videoBox.animate().translationYBy(videoBox.getHeight())
				.setDuration(ANIMATION_DURATION_MILLIS)
				.withEndAction(new Runnable() {
					@Override
					public void run() {
						videoBox.setVisibility(View.INVISIBLE);
					}
				});
	}

	public static class VideoListFragment extends ListFragment {

		private PageAdapter adapter;

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			adapter = new PageAdapter(getActivity(), VIDEO_LIST);
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			getActivity().findViewById(R.id.video_box);
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			setListAdapter(adapter);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {

			SharedPreferences pref = getActivity().getSharedPreferences("binh",
					MODE_PRIVATE);
			SharedPreferences.Editor editor = pref.edit();
			editor.putInt("vitri", position);
			editor.commit();
			Intent intent = new Intent(getActivity(), VideoforLeague.class);
			startActivity(intent);
		}

		@Override
		public void onDestroyView() {
			super.onDestroyView();

			adapter.releaseLoaders();
		}

		public void setLabelVisibility(boolean visible) {
			adapter.setLabelVisibility(visible);
		}

	}

	public static final class VideoFragment extends YouTubePlayerFragment
			implements OnInitializedListener {

		private YouTubePlayer player;
		private String videoId;

		public static VideoFragment newInstance() {
			return new VideoFragment();
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			initialize(DeveloperKey.DEVELOPER_KEY, this);
		}

		@Override
		public void onDestroy() {
			if (player != null) {
				player.release();
			}
			super.onDestroy();
		}

		public void setVideoId(String videoId) {
			if (videoId != null && !videoId.equals(this.videoId)) {
				this.videoId = videoId;
				if (player != null) {
					player.cueVideo(videoId);
				}
			}
		}

		public void pause() {
			if (player != null) {
				player.pause();
			}
		}

		@Override
		public void onInitializationSuccess(Provider provider,
				YouTubePlayer player, boolean restored) {
			this.player = player;
			player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
			player.setOnFullscreenListener((LeagueListActivity) getActivity());
			if (!restored && videoId != null) {
				player.cueVideo(videoId);
			}
		}

		@Override
		public void onInitializationFailure(Provider provider,
				YouTubeInitializationResult result) {
			this.player = null;
		}

	}

}
