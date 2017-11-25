package binh.app.bestgoal.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import binh.app.bestgoal.R;

public class GridImageAdapter extends ArrayAdapter<Bitmap> {

	Context context;
	int layoutResourceId;
	Bitmap[] data;

	public GridImageAdapter(Context context, int layoutResourceId, Bitmap[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new RecordHolder();
			holder.imageItem = (ImageView) row.findViewById(R.id.thumbImage);
			holder.imageItem.setPadding(10, 10, 10, 10);
			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}
		holder.imageItem.setImageBitmap(data[position]);
		return row;
	}

	static class RecordHolder {
		ImageView imageItem;
	}
}
