package binh.app.bestgoal.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import binh.app.bestgoal.R;

public class LeagueAdapter extends ArrayAdapter<String> {

	private final Activity context;
	private final String[] name;
	private final Integer[] imageId;

	public LeagueAdapter(Activity context, String[] name, Integer[] imageId) {
		super(context, R.layout.leagues_list_item, name);
		this.context = context;
		this.name = name;
		this.imageId = imageId;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.leagues_list_item, null,
				true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.leagueName);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.leagueIcon);
		txtTitle.setText(name[position]);
		Typeface tf = Typeface.createFromAsset(context.getAssets(),
		        "pic/Roboto-Light.ttf");
		txtTitle.setTypeface(tf);
		imageView.setImageResource(imageId[position]);
		return rowView;
	}
}
