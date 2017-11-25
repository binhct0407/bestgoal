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

public final class PlayerListActivity extends Activity implements
		OnFullscreenListener {

	private static final int ANIMATION_DURATION_MILLIS = 300;
	private VideoListFragment listFragment;
	private VideoFragment videoFragment;
	private static int index;
	private View videoBox;
	private ArrayList<VideoEntry> messi = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> ronaldo = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> zatan = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> rooney = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> ribery = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> xavi = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> pirlo = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> vanpersie = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> ozil = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> tores = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> reus = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> gerrard = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> kun = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> neymar = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> robben = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> iniesta = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> bale = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> alonxo = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> dimaria = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> kaka = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> lampard = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> tevez = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> mata = new ArrayList<VideoEntry>();
	private ArrayList<VideoEntry> gigs = new ArrayList<VideoEntry>();

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
		setContentView(R.layout.video_player_list);
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
		for (int i = 0; i < 15; i++) {
			VideoEntry v = new VideoEntry(Constant.messititle[i],
					Constant.messilist[i]);
			messi.add(v);
		}
		for (int i = 0; i < 15; i++) {
			VideoEntry video = new VideoEntry(Constant.ronaldotitle[i],
					Constant.ronaldolist[i]);
			ronaldo.add(video);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.zatantitle[i],
					Constant.zatanlist[i]);
			zatan.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.rooneytitle[i],
					Constant.rooneylist[i]);
			rooney.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.riberytitle[i],
					Constant.riberylist[i]);
			ribery.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.xavititle[i],
					Constant.xavilist[i]);
			xavi.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.pirlotitle[i],
					Constant.pirlolist[i]);
			pirlo.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.vantitle[i],
					Constant.vanlist[i]);
			vanpersie.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.oziltitle[i],
					Constant.ozillist[i]);
			ozil.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.torestitle[i],
					Constant.toreslist[i]);
			tores.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.reustitle[i],
					Constant.reuslist[i]);
			reus.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.gerrardtitle[i],
					Constant.gerrardlist[i]);
			gerrard.add(v);
		}

		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.kuntitle[i],
					Constant.kunlist[i]);
			kun.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.neymartitle[i],
					Constant.neymarlist[i]);
			neymar.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.robbentitle[i],
					Constant.robbenlist[i]);
			robben.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.iniestatitle[i],
					Constant.iniestalist[i]);
			iniesta.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.baletitle[i],
					Constant.balelist[i]);
			bale.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.alontitle[i],
					Constant.alonsolist[i]);
			alonxo.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.dimariatitle[i],
					Constant.dimarialist[i]);
			dimaria.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.kakatitle[i],
					Constant.kakalist[i]);
			kaka.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.lampardtitle[i],
					Constant.lampardlist[i]);
			lampard.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.teveztitle[i],
					Constant.tevezlist[i]);
			tevez.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.matatitle[i],
					Constant.matalist[i]);
			mata.add(v);
		}
		for (int i = 0; i < 10; i++) {
			VideoEntry v = new VideoEntry(Constant.gistitle[i],
					Constant.giglist[i]);
			gigs.add(v);
		}
		father.add(messi);
		father.add(ronaldo);
		father.add(zatan);
		father.add(rooney);
		father.add(ribery);
		father.add(xavi);
		father.add(pirlo);
		father.add(vanpersie);
		father.add(ozil);
		father.add(tores);
		father.add(reus);
		father.add(gerrard);
		father.add(kun);
		father.add(neymar);
		father.add(robben);
		father.add(iniesta);
		father.add(bale);
		father.add(alonxo);
		father.add(dimaria);
		father.add(kaka);
		father.add(lampard);
		father.add(tevez);
		father.add(mata);
		father.add(gigs);
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
			Intent intent = new Intent(getActivity(), VideoforPlayer.class);
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
			player.setOnFullscreenListener((PlayerListActivity) getActivity());
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
