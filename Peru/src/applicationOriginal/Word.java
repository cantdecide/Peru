package applicationOriginal;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class Word {
	
	private String _english;
	private String _quechua;
	private Image _image;
	private Media _sound;
	private int _spacedRepetition;
	
	Word(String english, String quechua, Image image, String filename) {
		_english = english;
		_quechua = quechua;
		_image = image;
		_spacedRepetition = 1;
	    URL resource = this.getClass().getResource("sounds/" + filename);
	    Media media = new Media(resource.toString());
	    _sound = media;
	}
	public void setEnglish(String english) {
		_english = english;
}

	public void setQuechua(String quechua) {
		_quechua = quechua;
}

	public void setImage(Image image) {
		_image = image;
}

	public void setSound(String filename) {
		  URL resource = this.getClass().getResource("sounds/" + filename);
	    Media media = new Media(resource.toString());
	    _sound = media;
		
}


	public String getEnglish() {
	return _english;
}

	public String getQuechua() {
	return _quechua;
}

	public Image getImage() {
	return _image;
}

	public Media getSound() {
	return _sound;
}

}




	

