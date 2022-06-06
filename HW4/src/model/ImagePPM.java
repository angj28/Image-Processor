package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * represents an image file as a 2D array of {@code RGB Pixel}.
 */
public class ImagePPM implements Image {

  ArrayList<ArrayList<RGBPixel>> image;

  /**
   * constructs an image array by reading the image file
   * @param filename the name of the file to be converted to an array
   */
  public ImagePPM(String filename) throws FileNotFoundException {
    this.image = ImageUtil.readPPM(filename);
  }

  @Override
  public void accept(ProcessCommand command) {
    command.start(this);
  }
}

