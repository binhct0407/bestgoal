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
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerFragment;

public final class ClubListActivity extends Activity implements
		OnFullscreenListener {

	private static final int ANIMATION_DURATION_MILLIS = 300;
	private VideoListFragment listFragment;
	private VideoFragment videoFragment;
	private static int index;
	private View videoBox;
	private ArrayList<VideoEntry> barca = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> real = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> valencia = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> aleltico = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> manc = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> manu = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> chel = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> liv = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> ars = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> acm = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> juve = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> inter = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> lazio = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> byern = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> dort = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> weder = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> lyon = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> psg = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> marcey = new ArrayList<VideoEntry>();
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
		setContentView(R.layout.video_club_list);
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
			VideoEntry v = new VideoEntry(Constant.barcatitle[i],
					Constant.barcalist[i]);
			barca.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.realtitle[i],
					Constant.reallist[i]);
			real.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.valentitle[i],
					Constant.valenlist[i]);
			valencia.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.alelticotitle[i],
					Constant.alelticolist[i]);
			aleltico.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.manctitle[i],
					Constant.manclist[i]);
			manc.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.manutitle[i],
					Constant.manulist[i]);
			manu.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.cheltitle[i],
					Constant.chellist[i]);
			chel.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.livtitle[i],
					Constant.livlist[i]);
			liv.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.arstitle[i],
					Constant.arslist[i]);
			ars.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.acmtitle[i],
					Constant.acmlist[i]);
			acm.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.juvetitle[i],
					Constant.juvelist[i]);
			juve.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.intertitle[i],
					Constant.interlist[i]);
			inter.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.lazioitle[i],
					Constant.laziolist[i]);
			lazio.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.byerntitle[i],
					Constant.byernlist[i]);
			byern.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.dorttitle[i],
					Constant.dortlist[i]);
			dort.add(v);
		}
		for (int i = 0; i < 6; i++) {
			VideoEntry v = new VideoEntry(Constant.werdertitle[i],
					Constant.werderlist[i]);
			weder.add(v);
		}
		for (int i = 0; i < 6; i++) {
			VideoEntry v = new VideoEntry(Constant.lyontitle[i],
					Constant.lyonlist[i]);
			lyon.add(v);
		}
		for (int i = 0; i < 6; i++) {
			VideoEntry v = new VideoEntry(Constant.psgltitle[i],
					Constant.psglist[i]);
			psg.add(v);
		}
		for (int i = 0; i < 6; i++) {
			VideoEntry v = new VideoEntry(Constant.marceytitle[i],
					Constant.marceylist[i]);
			marcey.add(v);
		}
		father.add(barca);
		father.add(real);
		father.add(valencia);
		father.add(aleltico);
		father.add(manc);
		father.add(manu);
		father.add(chel);
		father.add(liv);
		father.add(ars);
		father.add(acm);
		father.add(juve);
		father.add(inter);
		father.add(lazio);
		father.add(byern);
		father.add(dort);
		father.add(weder);
		father.add(lyon);
		father.add(psg);
		father.add(marcey);
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
			Intent intent = new Intent(getActivity(), VideoforClub.class);
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
			player.setOnFullscreenListener((ClubListActivity) getActivity());
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
