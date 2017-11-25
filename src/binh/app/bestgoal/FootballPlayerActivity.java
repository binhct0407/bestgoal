package binh.app.bestgoal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import binh.app.bestgoal.adapter.GridImageAdapter;

public class FootballPlayerActivity extends Activity {
	private ArrayList<String> pathlist = new ArrayList<String>();
	private Bitmap[] mBitArray = new Bitmap[24];
	private GridView mgallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_activity);
		AdView adView = (AdView) this.findViewById(R.id.adView);

		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"DC0F1B53FF17383006FBB574CC3C7213").build();
		adView.loadAd(adRequest);
		mgallery = (GridView) findViewById(R.id.gridView1);

		PandaTask p = new PandaTask();
		p.execute();

		mgallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				SharedPreferences pref = getSharedPreferences("binh",
						MODE_PRIVATE);
				SharedPreferences.Editor editor = pref.edit();
				editor.putInt("gridposition", arg2);
				editor.commit();
				Intent intent = new Intent(getBaseContext(),
						PlayerListActivity.class);
				startActivity(intent);

			}
		});

	}

	private Bitmap getBitmapFromAsset(String strName) throws IOException {
		AssetManager assetManager = getAssets();

		InputStream istr = assetManager.open(strName);
		Bitmap bitmap = BitmapFactory.decodeStream(istr);
		istr.close();

		return bitmap;
	}

	class PandaTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			for (int i = 0; i <= 23; i++) {
				pathlist.add("pic/a (" + i + ").jpg");
			}

			try {
				for (int i = 0; i < 24; i++)
					mBitArray[i] = getBitmapFromAsset(pathlist.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			mgallery.setAdapter(new GridImageAdapter(getApplicationContext(),
					R.layout.grid_item, mBitArray));
		}

	}

}
