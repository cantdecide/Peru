package applicationOriginal;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public class Word {
	
	private String _english;
	private String _quechua;
	private Image _image;
	private Media _sound;
	
	Word(String english, String quechua, Image image, String filename) {
		_english = english;
		_quechua = quechua;
		_image = image;
	    URL resource = this.getClass().getResource("sounds/" + filename);
	    Media media = new Media(resource.toString());
	    _sound = media;
	}
	
	

}
