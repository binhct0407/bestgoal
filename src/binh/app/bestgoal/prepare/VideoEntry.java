package binh.app.bestgoal.prepare;

public class VideoEntry {
	private String text;
	private String videoId;

	public VideoEntry(String text, String videoId) {
		this.text = text;
		this.videoId = videoId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

}
