package applicationOriginal;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class Word {
	
	private String _english;
	private String _quechua;
	private Image _image;
	private Media _sound;
	
	Word(String english, String quechua, String imageFilename, String soundFilename) {
		_english = english;
		_quechua = quechua;
		URL imageResource = this.getClass().getResource("images/" + imageFilename);
	    Image image = new Image(imageResource.toString());
		setImage(image);
	    URL soundResource = this.getClass().getResource("sounds/" + soundFilename);
	    Media media = new Media(soundResource.toString());
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
	
	public void setEnglish(String s) {
		_english = s;
	}
	
	public void setQuechua(String s) {
		_quechua = s;
	}

	public void setImage(Image image) {
		_image = image;
	}
	
	public void setSound(Media m) {
		_sound = m;
	}
	
	

}
